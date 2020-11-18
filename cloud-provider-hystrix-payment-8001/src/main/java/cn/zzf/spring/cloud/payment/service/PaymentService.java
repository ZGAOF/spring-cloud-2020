package cn.zzf.spring.cloud.payment.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author GaoFeng
 * @date 2020/11/3 18:21
 */
@Service
public class PaymentService {

    public String paymentInfoOk(Integer id) {
        return "线程池-" + Thread.currentThread().getName() + " paymentInfoOk-id-" + id;
    }


    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "2000")
    })
    public String paymentInfoTimeout(Integer id) {
        int num = 1/0;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池-" + Thread.currentThread().getName() + " paymentInfoTimeout-id-" + id;
    }

    public String paymentInfoTimeoutHandler(Integer id) {
        return Thread.currentThread().getName() + " provider payment service-8001 超时, paymentInfoTimeoutHandler-" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            // 开启熔断机制
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED, value = "true"),
            // 某个时间窗口内的错误百分比（阀值）
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "60"),
            // 某个时间窗口内的请求数
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "10"),
            // 时间窗口的具体大小
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "10000"),
            //------ 10秒内如果10个请求里面有6个失败或超时了，那就打开熔断器
    })
    public String paymentCircuitBreaker(Integer id) {
        if  (id < 0) {
            throw new IllegalArgumentException("id不能为负数");
        }

        String simpleUUID = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + " - " + simpleUUID + "-paymentCircuitBreaker ok" + id;
    }

    public String paymentCircuitBreakerFallback(Integer id) {
        return Thread.currentThread().getName() + "paymentCircuitBreakerFallback 开始工作" + id;
    }
}
