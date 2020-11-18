package cn.zzf.spring.cloud.payment.service.impl;

import cn.zzf.spring.cloud.entity.Payment;
import cn.zzf.spring.cloud.payment.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 付款服务
 * @author GaoFeng
 * @date 2020/10/31 20:46
 */
@Service
public class PaymentServiceImpl implements cn.zzf.spring.cloud.payment.service.PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment selectPaymentById(Long id) {
        return paymentMapper.selectPaymentById(id);
    }

}
