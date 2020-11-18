package cn.zzf.spring.cloud.alibaba.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GaoFeng
 * @date 2020/11/8 15:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelService8402Application {
    public static void main(String[] args) {
        SpringApplication.run(SentinelService8402Application.class, args);
    }
}
