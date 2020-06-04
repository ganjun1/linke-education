package pay.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class AlipayConfig {
    // 商户appid
    private  String APPID = "2016101700710592";
    // 私钥 pkcs8格式的
    private  String RSA_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCTcyWz9v4hlgmUaNfMHHT9VYMfe3mn/JI8yV2iMoEEeFFyoaPrTJ98cQ9rezzgPlISo4otnfHkbX5L/WfzvkaNcc/phQoRV2DlRNEbzlrSsVBI4ALjjo4I4XsqCYmhvwFwVh2afWbgzylgboWxyruftDnAQuzox4GCOgxyc7WxqTXo/hJBybV0nPjUbTHA/fxccOFSOerMz+9btZWSiDeq2qNLd72wI9BvRII4wL0W0loHayruWtIKGY0nU6TdfoGbidBqDImNCqFzmkzfOh1h50wxMkj+DGIlNe0zUrgnzvewcNTsyz7mHpInoy0hn9IoZh0IMkn+YLNnYOoHiMsPAgMBAAECggEACEOG1Gw+V/GJveiWV5kssVoOjEAmVFTieUer2MBN3MtFfVAz2KcltRq9C4APrF2xyduijeXxPaUpU+by4YVDfP/o8CSFqO0lwBO4SH+rNW28myj64HgH29WPSo7YSNlkokAhTpxCnMzfe8kV8x3yoAPAzNazYmR0DLFmKy/y+e70ZKQloJecdssYbXMIxEv6ByCb32O6e2Qn4psUD7ey9OCiwD/KfR76DKSg1AN45p0Xo0A1vXUIk6k+WiaDrmO11M3qQ+pEQbXplK/BXTN2Q8zR//ACoDF9jjQxB34TFePhUhF82jd3VqgY9Jn3Q+rAnQRmcW4Am7iptyiAnNMNAQKBgQD4342nDxhYjkaG/90jylsHvu9pA3/VGQ6zavkuN49NLqNaJ8/TlRPfC6o47jvRR8FPYYgX01y2FLcbJL6V4kQxd4rx/9CJ9UPmIfD1/c0F8QoRMPJqGvekzfJZYplsRdi7phCLNuVL028qWIUfe0I8LK6BNWJjBLFn8rtw6+b0jwKBgQCXrBN+LIr0momEioLvsQa9eh/knjXOq/lSVHndk7kYchGJD2fhZk2u7IL5cUAQz/keI7PAHlqYh59/7BREy3UfYs+b3YwRt0SV61JaXlYyvoBoLpkLaOSGuBeDHCEs8HYdhDiiqmA6/hgMhqMdnms1rU5nEvkFc9iYWEOiIx0BgQKBgFHP65kHdVFnM/gdFG03kEUzlzBGXjeHTTXd7Jws14bf1gNFIyTC1Q11oDem2TMrC3k07rAmY0vX83mQ0rYi85fvXFXBaqRvZCq67aNwE33ohw6vsIEA7HfY29pWd2kIbP8C0F1zZl1O3DRndRusQVHWvmbrTbSPTmKFgOjWI84xAoGAEHPNBYHFbPUad7MisudsCL+nmAAFbC7Bc8nQElYE3P76ofh21z9mq9Ph/TbosSouJrPOusdQIn2Lsq+kHzZGtSndxVWJ7R4JJY4KN91F0mlRuntbhJ5TM73iZwl1G8/VsCv4jMSYfa20ZB9ysDLQBFmRSKMJOisv0o64f2z5p4ECgYANYrdmy3PyuQlPJHe+2lsdneOdr4kXJu7itq6yuPXJq8g5xmP+nbF/6K0yKtzyOf4ktV9UgfPRl5Axq1JOVUZd7V89jR5Z0uYXh20kwF5LEiBk33yjVFkKANhfKg8TbKRwUgo01p0hvy9jhPiipnRMjLlvgnRQHVCc7dxm6WO17A==";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    private  String notify_url = "http://ganjun.wezoz.com/notify";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    private  String return_url = "http://ganjun.wezoz.com/returnUrl";
    // 请求网关地址
    private  String URL = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    private  String CHARSET = "utf-8";
    // 返回格式
    private  String FORMAT = "json";
    // 支付宝公钥
    private  String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5EamlDPXAbDs/c09AMK6vuf/hBkw6gtWNPjY5T/uCuTR6Vgi6OUihQ+5mc+PzRas7BmD3g2TZG5yiE+RXnpKtn5+iiJBSn+PnFJZ/NrJuFjUM8ovoIJ4vCsZVY2rZggFZH48s3NqTJNF0hWcU06pOIxBTMafr/uCAPDx80J0XgZJz4pCIALTNkxctuUIs07QDaJPokvH67yog0qlB4CNwUwMPlimrBvILozGK1YNpP8PgQk1gyjOHEdgEjtRv574lCv6I+dUl+IAJsja7DA2fHPZpI7KepT+HLp9+01NYcyxdZO6ZuJzZAX/DtGK5By2wuyjWGNF+SIZ2c+LsaZ1OQIDAQAB";
    // 日志记录目录
    private  String log_path = "/logs";
    // RSA2
    private  String SIGNTYPE = "RSA2";
    //支付成功跳转页
    private String paymentSuccessUrl="http://localhost:8088/pay/success";
    //支付失败跳转页
    private String paymentFailureUrl="http://localhost:8088/pay/failure";

    public String getAPPID() {
        return APPID;
    }

    public void setAPPID(String APPID) {
        this.APPID = APPID;
    }

    public String getRSA_PRIVATE_KEY() {
        return RSA_PRIVATE_KEY;
    }

    public void setRSA_PRIVATE_KEY(String RSA_PRIVATE_KEY) {
        this.RSA_PRIVATE_KEY = RSA_PRIVATE_KEY;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getCHARSET() {
        return CHARSET;
    }

    public void setCHARSET(String CHARSET) {
        this.CHARSET = CHARSET;
    }

    public String getFORMAT() {
        return FORMAT;
    }

    public void setFORMAT(String FORMAT) {
        this.FORMAT = FORMAT;
    }

    public String getALIPAY_PUBLIC_KEY() {
        return ALIPAY_PUBLIC_KEY;
    }

    public void setALIPAY_PUBLIC_KEY(String ALIPAY_PUBLIC_KEY) {
        this.ALIPAY_PUBLIC_KEY = ALIPAY_PUBLIC_KEY;
    }

    public String getLog_path() {
        return log_path;
    }

    public void setLog_path(String log_path) {
        this.log_path = log_path;
    }

    public String getSIGNTYPE() {
        return SIGNTYPE;
    }

    public void setSIGNTYPE(String SIGNTYPE) {
        this.SIGNTYPE = SIGNTYPE;
    }

    public String getPaymentSuccessUrl() {
        return paymentSuccessUrl;
    }

    public void setPaymentSuccessUrl(String paymentSuccessUrl) {
        this.paymentSuccessUrl = paymentSuccessUrl;
    }

    public String getPaymentFailureUrl() {
        return paymentFailureUrl;
    }

    public void setPaymentFailureUrl(String paymentFailureUrl) {
        this.paymentFailureUrl = paymentFailureUrl;
    }
}
