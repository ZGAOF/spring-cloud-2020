package cn.zzf.spring.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author GaoFeng
 * @date 2020/11/3 21:03
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class OrderConsumerHystrix80Application {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerHystrix80Application.class, args);
    }
}
