package cn.zzf.spring.cloud.payment.controller;

import cn.zzf.spring.cloud.entity.Payment;
import cn.zzf.spring.cloud.entity.ResponseResult;
import cn.zzf.spring.cloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author GaoFeng
 * @date 2020/10/31 20:52
 */
@Slf4j
@RestController
@RequestMapping("/payment")
@Validated
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/create")
    public ResponseResult<Object> create(@RequestBody Payment payment) {
        int addCount = paymentService.create(payment);
        if (addCount <= 0) {
            return ResponseResult.fail(-1, "添加失败");
        } else {
            return ResponseResult.ok();
        }
    }

    @GetMapping("/{id}")
    public ResponseResult<Object> selectPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.selectPaymentById(id);
        if (payment == null) {
            return ResponseResult.fail(-1, "数据未找到");
        } else {
            ResponseResult<Object> ok = ResponseResult.ok(payment);
            ok.setMessage(this.port);
            return ok;
        }
    }

    @GetMapping("/port")
    public String getPort() {
        return port;
    }

}
