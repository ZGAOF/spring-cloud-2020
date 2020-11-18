package cn.zzf.spring.cloud.alibaba.nacos.consumer.fallback;

import cn.zzf.spring.cloud.alibaba.nacos.consumer.api.PaymentApi;
import cn.zzf.spring.cloud.entity.ResponseResult;
import org.springframework.stereotype.Service;

/**
 * @author GaoFeng
 * @date 2020/11/10 20:39
 */
@Service
public class PaymentApiFallback implements PaymentApi {
    @Override
    public ResponseResult getPaymentById(Integer id) {
        return ResponseResult.ok("PaymentApiFallback id-" + id);
    }
}
