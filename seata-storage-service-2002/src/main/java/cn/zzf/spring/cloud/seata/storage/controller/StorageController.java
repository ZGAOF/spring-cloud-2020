package cn.zzf.spring.cloud.seata.storage.controller;

import cn.zzf.spring.cloud.seata.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author GaoFeng
 * @date 2020/11/12 14:15
 */
@Slf4j
@RestController
@RequestMapping("/storage")
@Validated
public class StorageController {
    @Resource
    private StorageService storageService;

    @GetMapping("/deduct")
    public void deduct(Integer quantity) {
        // int i = 10/0;
        // try {
        //     TimeUnit.SECONDS.sleep(5);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        storageService.deduct(quantity);
    }
}
