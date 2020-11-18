package cn.zzf.spring.cloud.alibaba.nacos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GaoFeng
 * @date 2020/11/6 20:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfig3377Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfig3377Application.class, args);
    }

}
