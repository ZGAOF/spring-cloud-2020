package cn.zzf.spring.cloud.stream.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author GaoFeng
 * @date 2020/11/5 22:39
 */
@SpringBootApplication
@EnableEurekaClient
public class MessageProvider8801Application {
    public static void main(String[] args) {
        SpringApplication.run(MessageProvider8801Application.class, args);
    }
}
