package cn.zzf.spring.cloud.alibaba.nacos.provider.controller;

import cn.zzf.spring.cloud.entity.Payment;
import cn.zzf.spring.cloud.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author GaoFeng
 * @date 2020/11/10 0:15
 */
@Slf4j
@RestController
@RequestMapping("/payment")
@Validated
public class PaymentController {

    private static final ConcurrentHashMap<Integer, Payment> db = new ConcurrentHashMap<>();

    static {
        db.put(1, new Payment(1L, "zzf"));
        db.put(2, new Payment(2L, "ysl"));
        db.put(3, new Payment(3L, "hyb"));
        db.put(4, new Payment(4L, "lzc"));
        db.put(5, new Payment(5L, "zhz"));
        db.put(6, new Payment(6L, "xhl"));
    }

    @GetMapping("/{id}")
    public ResponseResult<Payment> getPaymentById(@PathVariable("id") Integer id) {
        return ResponseResult.ok(db.get(id));
    }


}
