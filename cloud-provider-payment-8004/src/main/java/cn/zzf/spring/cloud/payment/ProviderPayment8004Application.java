package cn.zzf.spring.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GaoFeng
 * @date 2020/11/2 12:22
 */
@SpringBootApplication
// 开启服务发现 使用zookeeper或consul作为注册中心时，需使用该注解
@EnableDiscoveryClient
public class ProviderPayment8004Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment8004Application.class, args);
    }
}
