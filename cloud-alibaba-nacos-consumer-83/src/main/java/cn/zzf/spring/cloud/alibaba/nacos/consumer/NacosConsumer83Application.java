package cn.zzf.spring.cloud.alibaba.nacos.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author GaoFeng
 * @date 2020/11/6 19:35
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumer83Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumer83Application.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
