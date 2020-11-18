package cn.zzf.spring.cloud.seata.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GaoFeng
 * @date 2020/11/12 16:17
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"cn.zzf.spring.cloud.seata.storage.mapper"})
public class SeataStorageService2002Application {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageService2002Application.class);
    }
}
