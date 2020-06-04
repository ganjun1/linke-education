package cn;

import cn.unionpay.acp.sdk.SDKConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.dao")
public class PayApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(PayApp.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        SDKConfig.getConfig().loadPropertiesFromSrc();
    }
}
