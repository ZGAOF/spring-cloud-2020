package cn.zzf.spring.cloud.order;

import cn.zzf.spring.cloud.irule.CustomIRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author GaoFeng
 * @date 2020/11/1 0:04
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = {CustomIRule.class})
public class ConsumerOrder80Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder80Application.class, args);
    }
}
