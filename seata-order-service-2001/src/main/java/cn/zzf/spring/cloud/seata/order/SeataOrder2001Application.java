package cn.zzf.spring.cloud.seata.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author GaoFeng
 * @date 2020/11/11 21:55
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = {"cn.zzf.spring.cloud.seata.order.mapper"})
public class SeataOrder2001Application {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrder2001Application.class, args);
    }
}
