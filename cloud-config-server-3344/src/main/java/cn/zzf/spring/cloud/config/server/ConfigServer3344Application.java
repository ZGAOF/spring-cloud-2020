package cn.zzf.spring.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author GaoFeng
 * @date 2020/11/5 11:01
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServer3344Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer3344Application.class, args);
    }
}
