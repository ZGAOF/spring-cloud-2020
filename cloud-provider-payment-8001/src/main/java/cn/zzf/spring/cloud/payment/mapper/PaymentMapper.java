package cn.zzf.spring.cloud.payment.mapper;

import cn.zzf.spring.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    int create(Payment payment);

    Payment selectPaymentById(Long id);
}
