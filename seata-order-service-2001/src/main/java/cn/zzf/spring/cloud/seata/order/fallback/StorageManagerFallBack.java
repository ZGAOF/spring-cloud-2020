package cn.zzf.spring.cloud.seata.order.fallback;

import cn.zzf.spring.cloud.seata.order.manager.StorageManager;
import org.springframework.stereotype.Component;

/**
 * @author GaoFeng
 * @date 2020/11/13 2:13
 */
@Component
public class StorageManagerFallBack implements StorageManager {
    @Override
    public void deduct(Integer quantity) {
        throw new RuntimeException();
    }
}
