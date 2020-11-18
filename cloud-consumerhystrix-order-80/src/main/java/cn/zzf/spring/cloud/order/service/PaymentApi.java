package cn.zzf.spring.cloud.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author GaoFeng
 * @date 2020/11/3 20:11
 */
@Service
@FeignClient(name = "CLOUD-PAYMENT-HYSTRIX-SERVICE", path = "/payment/hystrix", fallback = PaymentApiHandler.class)
public interface PaymentApi {
    @GetMapping("/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id);

    @GetMapping("/timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id") Integer id);
}
