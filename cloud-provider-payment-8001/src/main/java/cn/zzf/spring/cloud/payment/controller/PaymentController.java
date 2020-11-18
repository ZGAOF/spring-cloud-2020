package cn.zzf.spring.cloud.payment.controller;

import cn.zzf.spring.cloud.entity.Payment;
import cn.zzf.spring.cloud.entity.ResponseResult;
import cn.zzf.spring.cloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

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

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discovery")
    public DiscoveryClient discovery() {
        discoveryClient.getServices().forEach(log::info);
        discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE").forEach(instance -> {
            log.info(instance.getInstanceId() + ":" + instance.getServiceId());
        });
        return discoveryClient;
    }

    @GetMapping("/port")
    public String getPort() {
        return port;
    }

    @GetMapping("/timeout")
    public String timeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return port;
    }

    @GetMapping("/zipkin")
    public String zipkin() {
        return "payment-zipkin-" + port + "is response";
    }
}
