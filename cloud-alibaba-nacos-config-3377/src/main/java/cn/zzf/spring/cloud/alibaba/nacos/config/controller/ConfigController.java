package cn.zzf.spring.cloud.alibaba.nacos.config.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GaoFeng
 * @date 2020/11/6 20:56
 */
@Slf4j
@RestController
@RequestMapping("/config")
@Validated
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/info")
    public String configInfo() {
        return "nacos-config-info-" + configInfo;
    }
}
