package cn.zzf.spring.cloud.alibaba.nacos.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author GaoFeng
 * @date 2020/11/6 19:37
 */
@Slf4j
@RestController
@RequestMapping("/consumer/")
@Validated
public class NacosConsumerController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping("/{id}")
    public String getPaymentById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(serviceUrl + "/" + id, String.class);
    }


}
