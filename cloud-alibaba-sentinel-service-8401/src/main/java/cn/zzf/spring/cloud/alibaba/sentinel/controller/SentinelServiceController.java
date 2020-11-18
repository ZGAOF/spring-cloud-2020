package cn.zzf.spring.cloud.alibaba.sentinel.controller;

import cn.zzf.spring.cloud.alibaba.sentinel.service.SentinelService2Api;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author GaoFeng
 * @date 2020/11/8 15:01
 */
@Slf4j
@RestController
@RequestMapping("/sentinel")
@Validated
public class SentinelServiceController {

    @Autowired
    private SentinelService2Api sentinelService2Api;

    @GetMapping("/test/monitor_a")
    public String monitorTestA() {
        return "montitorTest A";
    }

    @GetMapping("/test/monitor_b")
    public String monitorTestB() {
        log.info("{}-monitorTestB", Thread.currentThread().getName());
        return "montitorTest B";
    }

    @GetMapping("/thread_count")
    public String threadCountTest() {
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "thread count test";
    }

    @GetMapping("/service2")
    public String service2() {
        return sentinelService2Api.monitorTestA();
    }

    @GetMapping("/degrade")
    public String degradeTest() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "degradeTest";
    }

    @GetMapping("/exception")
    public String exception() {
        int i = 1/0;
        return "exception";
    }

    @SentinelResource(value = "hotKeyTest", blockHandler = "hotKeyTestBlockHandler")
    @GetMapping("/hot_key")
    public String hotKeyTest(@RequestParam(required = false) String a,
                             @RequestParam(required = false) String b) {

        int i = 10 / 0;
        return "hotKeyTest-a-" + a + "-b-" + b;
    }

    public String hotKeyTestBlockHandler(String a, String b, BlockException blockException) {
        return "hotKeyTestBlockHandler-a-" + a + "-b-" + b;
    }
}
