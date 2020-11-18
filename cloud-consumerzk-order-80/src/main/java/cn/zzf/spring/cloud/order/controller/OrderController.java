package cn.zzf.spring.cloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author GaoFeng
 * @date 2020/11/2 14:41
 */
@Slf4j
@RestController
@RequestMapping("/order/payment")
@Validated
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String PAYMENT_SERVICE_URL = "http://cloud-provider-payment/payment";

    @GetMapping("/zk")
    public String zk() {
        return restTemplate.getForObject(PAYMENT_SERVICE_URL + "/zk", String.class);
    }
}
