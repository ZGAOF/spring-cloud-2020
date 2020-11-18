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
public class NacosProvider9001Application {
    public static void main(String[] args) {
        SpringApplication.run(NacosProvider9001Application.class, args);
    }
}
