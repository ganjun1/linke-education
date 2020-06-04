package cn.unionpay.acp.sdk;

public class UnionpayConfig {
    /**商户号*/
    public static final String MER_ID = "777290058181993";

    /**
     * 前端异步通知地址
     */
    public static String FRONT_URL = "http://localhost:8088/pay/success";

    /**
     * 后台异步通知地址
     */
    public static String BACK_URL = "http://ganjun.wezoz.com/notifyurl";

}
