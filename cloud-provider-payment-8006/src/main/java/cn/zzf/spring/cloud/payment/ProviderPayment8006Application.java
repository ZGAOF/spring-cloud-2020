package cn.zzf.spring.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GaoFeng
 * @date 2020/11/2 17:13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment8006Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment8006Application.class, args);
    }
}
