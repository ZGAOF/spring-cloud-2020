package cn.zzf.spring.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GaoFeng
 * @date 2020/11/1 0:04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZkOrder80Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZkOrder80Application.class, args);
    }
}
