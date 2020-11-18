package cn.zzf.spring.cloud.stream.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author GaoFeng
 * @date 2020/11/5 23:21
 */
@SpringBootApplication
@EnableEurekaClient
public class MessageConsumer8803Application {
    public static void main(String[] args) {
        SpringApplication.run(MessageConsumer8803Application.class, args);
    }
}
