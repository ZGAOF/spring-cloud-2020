package cn.zzf.spring.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author GaoFeng
 * @date 2020/10/31 16:36
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderPayment8001Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment8001Application.class, args);
    }
}
