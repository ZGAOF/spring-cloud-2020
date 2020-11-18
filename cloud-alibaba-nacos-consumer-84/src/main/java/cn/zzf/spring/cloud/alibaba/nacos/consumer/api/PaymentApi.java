package cn.zzf.spring.cloud.alibaba.nacos.consumer.api;

import cn.zzf.spring.cloud.alibaba.nacos.consumer.fallback.PaymentApiFallback;
import cn.zzf.spring.cloud.entity.Payment;
import cn.zzf.spring.cloud.entity.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author GaoFeng
 * @date 2020/11/10 19:59
 */
@Service
@FeignClient(name = "nacos-provider-payment", path = "/payment", fallback = PaymentApiFallback.class)
public interface PaymentApi {
    @GetMapping("/{id}")
    ResponseResult<Payment> getPaymentById(@PathVariable("id") Integer id);
}
