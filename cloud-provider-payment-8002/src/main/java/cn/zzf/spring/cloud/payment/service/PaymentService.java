package cn.zzf.spring.cloud.payment.service;


import cn.zzf.spring.cloud.entity.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment selectPaymentById(Long id);
}
