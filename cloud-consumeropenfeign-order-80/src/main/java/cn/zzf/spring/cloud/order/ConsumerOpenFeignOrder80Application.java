package cn.zzf.spring.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author GaoFeng
 * @date 2020/11/3 14:49
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ConsumerOpenFeignOrder80Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOpenFeignOrder80Application.class, args);
    }
}
