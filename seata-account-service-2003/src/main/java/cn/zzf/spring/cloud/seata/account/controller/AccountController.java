package cn.zzf.spring.cloud.seata.account.controller;

import cn.zzf.spring.cloud.seata.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/account")
@Validated
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping("/deduct")
    public void deduct(Integer money) {
        accountService.deduct(money);
    }
}

