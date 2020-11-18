package cn.zzf.spring.cloud.order.controller;

import cn.zzf.spring.cloud.order.service.PaymentApi;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GaoFeng
 * @date 2020/11/3 21:00
 */
@Slf4j
@RestController
@RequestMapping("order/hystrix")
@Validated
@DefaultProperties(defaultFallback = "commonHandler")
public class OrderController {
    @Autowired
    private PaymentApi paymentApi;

    @GetMapping("/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        return paymentApi.paymentInfoOk(id);
    }

    /*@HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "1000")
    })*/
    // @HystrixCommand
    @GetMapping("/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        // int num = 1/0;
        return paymentApi.paymentInfoTimeout(id);
    }

    public String paymentInfoTimeoutHandler(@PathVariable("id") Integer id) {
        return Thread.currentThread().getName() + " provider payment service-80 超时, paymentInfoTimeoutHandler-" + id;
    }

    public String commonHandler() {
        return "全局fallback触发";
    }
}
