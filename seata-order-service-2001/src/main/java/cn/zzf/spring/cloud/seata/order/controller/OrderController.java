package cn.zzf.spring.cloud.seata.order.controller;

import cn.zzf.spring.cloud.entity.UserOrder;
import cn.zzf.spring.cloud.seata.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author GaoFeng
 * @date 2020/11/12 19:35
 */
@Slf4j
@RestController
@RequestMapping("/order")
@Validated
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/create")
    public void create(UserOrder userOrder) {
        orderService.create(userOrder);
    }

}
