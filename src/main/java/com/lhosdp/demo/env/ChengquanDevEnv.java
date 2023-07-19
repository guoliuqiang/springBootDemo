package com.lhosdp.demo.env;
/*
橙券--测试环境--常量
 */
public class ChengquanDevEnv extends ChengquanBaseEnv{

    @Override
    public String getAccount() {
        return "15020190001";
    }

    @Override
    public String getKey() {
        return "0BE0C9FEE504983B285B9407CB9C85D9";
    }

    @Override
    public String getAES() {
        return "7UpyiWxTijDqxYu6";
    }

    @Override
    public String getOFFET() {
        return "ifGOeBnEUUe2xo8Q";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String getBaseUrl() {
        return "http://test.api.chengquan.cn";
    }
}
