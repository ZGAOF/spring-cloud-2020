package cn.zzf.spring.cloud.alibaba.sentinel.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author GaoFeng
 * @date 2020/11/8 18:35
 */

@Service
@FeignClient(name = "sentinel-service2", path = "/sentinel")
public interface SentinelService2Api {
    @GetMapping("/service2")
    String monitorTestA();
}
