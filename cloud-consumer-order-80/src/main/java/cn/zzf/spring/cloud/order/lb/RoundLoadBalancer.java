package cn.zzf.spring.cloud.order.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author GaoFeng
 * @date 2020/11/2 23:46
 */
@Slf4j
@Component
public class RoundLoadBalancer implements LoadBalancer {

    private AtomicInteger requestCounter;

    public RoundLoadBalancer() {
        requestCounter = new AtomicInteger();
    }

    @Override
    public String choose(List<ServiceInstance> instances) {
        int currentIndex = this.currentIndex(instances.size());
        return instances.get(currentIndex).getUri().toString();
    }

    private int currentIndex(int instanceSize) {
        int oldIndex;
        int newIndex;
        do {
            oldIndex = requestCounter.get();
            newIndex = oldIndex >= Integer.MAX_VALUE ? 1 : oldIndex + 1;
            log.info("当前请求数[{}]", newIndex);
        } while (!requestCounter.compareAndSet(oldIndex, newIndex));
        return newIndex % instanceSize;
    }
}
