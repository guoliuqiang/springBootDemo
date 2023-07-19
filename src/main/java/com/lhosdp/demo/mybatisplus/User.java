package com.lhosdp.demo.mybatisplus;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guoliuqaing
 */
@Data
@TableName("t_user")
@AllArgsConstructor
public class User {

    private String id;

    private String accountID;

    private String userName;

    private EnumStatus statusDef; //枚举属性，使用mybatis默认转换类

    private EnumStatus statusOrdinal; //枚举属性，使用EnumOrdinalTypeHandler转换

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getAccountID() {
        return accountID;
    }


    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public EnumStatus getStatusDef() {
        return statusDef;
    }

    public void setStatusDef(EnumStatus statusDef) {
        this.statusDef = statusDef;
    }

    public EnumStatus getStatusOrdinal() {
        return statusOrdinal;
    }

    public void setStatusOrdinal(EnumStatus statusOrdinal) {
        this.statusOrdinal = statusOrdinal;
    }

    @Override
    public String toString() {
        return "id:" + id + "\naccountID:" + accountID + "\nuserName:" + userName + "\nstatusDef:" + statusDef.getDescription() + "\nstatusOrdinal:" + statusOrdinal.getDescription();
    }

}
