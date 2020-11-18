package cn.zzf.spring.cloud.alibaba.nacos.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GaoFeng
 * @date 2020/11/6 18:13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProvider9002Application {
    public static void main(String[] args) {
        SpringApplication.run(NacosProvider9002Application.class, args);
    }
}
