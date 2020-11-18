package cn.zzf.spring.cloud.alibaba.nacos.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GaoFeng
 * @date 2020/11/6 18:14
 */
@Slf4j
@RestController
@RequestMapping("/payment")
@Validated
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/{id}")
    public String getPaymentById(@PathVariable("id") Integer id) {
        return serverPort + "-nacos provider payment id-" + id;
    }
}
