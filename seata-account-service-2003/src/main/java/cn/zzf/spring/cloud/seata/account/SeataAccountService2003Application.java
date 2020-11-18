package cn.zzf.spring.cloud.seata.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GaoFeng
 * @date 2020/11/12 16:28
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"cn.zzf.spring.cloud.seata.account.mapper"})
public class SeataAccountService2003Application {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountService2003Application.class, args);
    }
}
