package cn.zzf.spring.cloud.seata.order.service;

import cn.zzf.spring.cloud.entity.UserOrder;
import cn.zzf.spring.cloud.seata.order.manager.AccountManager;
import cn.zzf.spring.cloud.seata.order.manager.StorageManager;
import cn.zzf.spring.cloud.seata.order.mapper.OrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GaoFeng
 * @date 2020/11/12 10:45
 */
@Slf4j
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StorageManager storageManager;

    @Autowired
    private AccountManager accountManager;

    @GlobalTransactional(rollbackFor = Exception.class,timeoutMills = 300000)
    public void create(UserOrder userOrder) {

        log.info("开始创建订单");
        orderMapper.insert(userOrder);
        log.info("订单创建成功");

        storageManager.deduct(userOrder.getQuantity());
        accountManager.deduct(userOrder.getQuantity() * userOrder.getMoney());

        log.info("更新订单状态");
        orderMapper.update(userOrder.getId(), (byte) 1);
        log.info("更新订单状态成功");
    }

}
