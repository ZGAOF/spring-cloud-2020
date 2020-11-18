package cn.zzf.spring.cloud.alibaba.nacos.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GaoFeng
 * @date 2020/11/10 0:15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment9004Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment9004Application.class, args);
    }
}
