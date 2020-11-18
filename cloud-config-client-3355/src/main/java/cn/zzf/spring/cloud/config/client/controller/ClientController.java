package cn.zzf.spring.cloud.config.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GaoFeng
 * @date 2020/11/5 13:56
 */
@Slf4j
@RestController
@RequestMapping("/config")
@Validated
@RefreshScope
public class ClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/info")
    public String configInfo() {
        return configInfo;
    }

}
