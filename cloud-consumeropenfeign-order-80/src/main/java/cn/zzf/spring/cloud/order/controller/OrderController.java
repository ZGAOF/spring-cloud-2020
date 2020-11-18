package cn.zzf.spring.cloud.order.controller;

import cn.zzf.spring.cloud.entity.Payment;
import cn.zzf.spring.cloud.entity.ResponseResult;
import cn.zzf.spring.cloud.order.service.PaymentApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author GaoFeng
 * @date 2020/11/3 14:54
 */
@Slf4j
@RestController
@RequestMapping("/order/feign")
@Validated
public class OrderController {
    @Autowired
    private PaymentApi paymentApi;

    @PostMapping("/create")
    public ResponseResult<Object> create(@RequestBody Payment payment) {
        return paymentApi.create(payment);
    }

    @GetMapping("/{id}")
    public ResponseResult<Object> selectPaymentById(@PathVariable Long id) {
        return paymentApi.selectPaymentById(id);
    }

    @GetMapping("/timeout")
    public String timeout() {
        return paymentApi.timeout();
    }
}
