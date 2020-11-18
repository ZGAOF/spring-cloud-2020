package cn.zzf.spring.cloud.seata.order.manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-account-service", path = "/account")
public interface AccountManager {
    @GetMapping("/deduct")
    void deduct(@RequestParam("money") Integer money);
}
