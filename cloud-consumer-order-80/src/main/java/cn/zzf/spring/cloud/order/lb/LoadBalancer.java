package cn.zzf.spring.cloud.order.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author GaoFeng
 * @date 2020/11/2 23:45
 */
public interface LoadBalancer {
    String choose(List<ServiceInstance> instances);
}
