package cn.zzf.spring.cloud.alibaba.sentinel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GaoFeng
 * @date 2020/11/8 15:01
 */
@Slf4j
@RestController
@RequestMapping("/sentinel")
@Validated
public class SentinelServiceController {
    @GetMapping("/service2")
    public String monitorTestA() {
        return "sentinel service2";
    }
}
