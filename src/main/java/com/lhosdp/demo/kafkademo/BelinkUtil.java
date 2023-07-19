package com.lhosdp.demo.kafkademo;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;

public class BelinkUtil {
    public static String getHostName() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            return addr.getHostName();
        } catch (UnknownHostException e) {
        }
        return "";
    }

    public static boolean isHandout(String opType) {
        if ("HANDOUT".equals(opType) || "REWARD".equals(opType)) {
            return true;
        }
        return false;
    }

    public static boolean isNotBlank(String str){
        return (null != str && (!"".equals(str.trim())));
    }

    public static int hash(String value, int seed) {
        int result = 0;
        for (int i = 0; i< value.length(); ++ i) {
            result = result * seed + value.charAt(i);
        }
        return result & (Constants.bloomCapacity - 1);
    }

    public static long calcAssetBudget(String assetCode, long amount) {
        String sql = "select type, exchange_unit from wl_bonus_definition where asset_code = ?";

        try (Connection con = DriverManager.getConnection(Constants.databaseUrl, Constants.databaseUser,
                Constants.databasePassword);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, assetCode);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    String type = rs.getString(1);
                    long exchangeUnit = rs.getLong(2);
                    if ("DIGIT".equals(type)) {
                        return amount * 100 / exchangeUnit;
                    } else {
                        String extendSql = "select coupon_iss_org_cate_cd, coupon_cost_ratio, coupon_sub_type, " +
                                "coupon_cost, coupon_amt, interest_rate, valid_dur, max_dscnt_amt " +
                                "from wl_bonus_extend where asset_code = ?";
                        try (PreparedStatement extPs = con.prepareStatement(extendSql)) {
                            extPs.setString(1, assetCode);
                            try (ResultSet extRs = extPs.executeQuery()) {
                                if (extRs.next()) {
                                    long costRatio = 100L;
                                    String couponIssOrgCateCd = extRs.getString(1);
                                    if ("MERCHANT".equals(couponIssOrgCateCd)) {
                                        costRatio = extRs.getLong(2);
                                    }
                                    String couponSubtype = extRs.getString(3);
                                    if ("CASHDEDUCTION".equals(couponSubtype) || "GOODSCOUPON".equals(couponSubtype)) {
                                        return amount * extRs.getLong(4);
                                    }
                                    if ("FINANCIALCOUPON".equals(couponSubtype)) {
                                        long couponAmt = extRs.getLong(5);
                                        long interestRate = extRs.getLong(6);
                                        int validDur = extRs.getInt(7);
                                        return amount * couponAmt * interestRate * validDur / 3650000 * costRatio / 100;
                                    }
                                    long maxDscntAmt = extRs.getLong(8);
                                    return amount * maxDscntAmt * costRatio / 100;
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
        }
        return 0;
    }
}
