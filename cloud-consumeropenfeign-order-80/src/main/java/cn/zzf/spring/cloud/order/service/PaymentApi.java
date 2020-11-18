package cn.zzf.spring.cloud.order.service;

import cn.zzf.spring.cloud.entity.Payment;
import cn.zzf.spring.cloud.entity.ResponseResult;
import cn.zzf.spring.cloud.order.config.PaymentFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(name = "CLOUD-PAYMENT-SERVICE", path = "/payment", configuration = PaymentFeignConfig.class)
public interface PaymentApi {
    @PostMapping("/create")
    ResponseResult<Object> create(@RequestBody Payment payment);

    @GetMapping("/{id}")
    ResponseResult<Object> selectPaymentById(@PathVariable("id") Long id);

    @GetMapping("/timeout")
    String timeout();
}
