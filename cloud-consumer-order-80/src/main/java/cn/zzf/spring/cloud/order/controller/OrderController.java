package cn.zzf.spring.cloud.order.controller;


import cn.zzf.spring.cloud.entity.Payment;
import cn.zzf.spring.cloud.entity.ResponseResult;
import cn.zzf.spring.cloud.order.lb.RoundLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GaoFeng
 * @date 2020/11/1 0:06
 */
@Slf4j
@RestController
@RequestMapping("order/payment")
@Validated
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private RoundLoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    // private static final String PAYMENT_SERVICE_URL = "http://localhost:8001/payment";
    private static final String PAYMENT_SERVICE_URL = "http://CLOUD-PAYMENT-SERVICE/payment";

    @PostMapping("/create")
    public ResponseResult<Object> createPayment(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_SERVICE_URL + "/create", payment, ResponseResult.class);
    }

    @GetMapping("/{id}")
    public ResponseResult<Payment> selectPaymentById(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_SERVICE_URL + "/" + id, ResponseResult.class);
    }

    @GetMapping("/entity/{id}")
    public ResponseResult selectPaymentByIdWithEntity(@PathVariable Long id) {
        ResponseEntity<ResponseResult> entity = restTemplate.getForEntity(PAYMENT_SERVICE_URL + "/" + id, ResponseResult.class);
        // 包含了更重要的信息，比如响应头，响应码，响应体
        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info("entity.code[{}]:[{}]", entity.getStatusCode().value(), entity.getStatusCode().getReasonPhrase());
            return entity.getBody();
        } else {
            return ResponseResult.fail(999, "error");
        }
    }

    @GetMapping("/port")
    public ResponseEntity<String> port() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        String url = loadBalancer.choose(instances);
        log.info(url);
        return restTemplate.getForEntity(url + "/payment/port", String.class);
    }

    @GetMapping("/zipkin")
    public String zipkin() {
        return restTemplate.getForObject(PAYMENT_SERVICE_URL + "/zipkin", String.class);
    }
}
