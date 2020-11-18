package cn.zzf.spring.cloud.order.service;

import org.springframework.stereotype.Service;

/**
 * @author GaoFeng
 * @date 2020/11/3 23:51
 */
@Service
public class PaymentApiHandler implements PaymentApi {

    @Override
    public String paymentInfoOk(Integer id) {
        return "paymentInfoOk-统配服务降级";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "paymentInfoTimeout-统配服务降级";
    }

}
