package cn.zzf.spring.cloud.alibaba.nacos.consumer.controller;

import cn.zzf.spring.cloud.alibaba.nacos.consumer.api.PaymentApi;
import cn.zzf.spring.cloud.entity.Payment;
import cn.zzf.spring.cloud.entity.ResponseResult;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author GaoFeng
 * @date 2020/11/10 0:45
 */
@Slf4j
@RestController
@RequestMapping("/nacos/consumer")
@Validated
public class NacosConsumerController {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentApi paymentApi;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @SentinelResource(value = "fallback",
            fallback = "fallback2",
            blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    @GetMapping("/fallback/{id}")
    public ResponseResult fallback(@PathVariable("id") Integer id) {

        if (id == 4) {
            throw new IllegalArgumentException("非法的id參數");
        }

        ResponseResult responseResult = restTemplate.getForObject(serviceUrl + "/" + id, ResponseResult.class);

        if (responseResult == null) {
            throw new NullPointerException("数据未找到，请稍后再试！！！");
        }

        return responseResult;
    }

    @GetMapping("/feign/{id}")
    public ResponseResult<Payment> getPaymentById(@PathVariable("id") Integer id) {
        return paymentApi.getPaymentById(id);
    }

    public ResponseResult fallback2(Integer id) {
        return ResponseResult.fail(-1, "trigger fallback fallback");
    }

    public ResponseResult blockHandler(Integer id,BlockException blockException) {
        return ResponseResult.fail(-2, "trigger block handler-id-" + id);
    }

}
