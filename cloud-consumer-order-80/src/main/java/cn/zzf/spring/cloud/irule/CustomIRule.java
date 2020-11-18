package cn.zzf.spring.cloud.irule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GaoFeng
 * @date 2020/11/2 21:35
 */
@Configuration
public class CustomIRule {
    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }
}
