package cn.zzf.spring.cloud.seata.account.service;

import cn.zzf.spring.cloud.seata.account.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class AccountService {
    @Resource
    private AccountMapper accountMapper;

    public void deduct(Integer money) {
        log.info("开始扣减余额");
        accountMapper.update(money);
        log.info("扣减账户余额成功");
    }
}
