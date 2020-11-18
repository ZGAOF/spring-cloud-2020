package cn.zzf.spring.cloud.seata.order.mapper;

import cn.zzf.spring.cloud.entity.UserOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    int insert(UserOrder order);

    int update(@Param("orderId") Long orderId,
               @Param("state") Byte state);

    List<UserOrder> selectByUserId(Long userId);

}
