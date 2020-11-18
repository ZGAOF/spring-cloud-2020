package cn.zzf.spring.cloud.seata.order.manager;

import cn.zzf.spring.cloud.seata.order.fallback.StorageManagerFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service", path = "storage", fallback = StorageManagerFallBack.class)
public interface StorageManager {
    @GetMapping("/deduct")
    void deduct(@RequestParam("quantity") Integer quantity);
}
