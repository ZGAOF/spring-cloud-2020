package cn.zzf.spring.cloud.alibaba.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author GaoFeng
 * @date 2020/11/8 15:00
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SentinelService8401Application {
    public static void main(String[] args) {
        SpringApplication.run(SentinelService8401Application.class, args);
    }
}
