package cn.zzf.spring.cloud.stream.provider.controller;

import cn.zzf.spring.cloud.stream.provider.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author GaoFeng
 * @date 2020/11/5 22:38
 */
@Slf4j
@RestController
@RequestMapping("/message")
@Validated
public class MessageProviderController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public void send() {
        messageProvider.send();
    }
}
