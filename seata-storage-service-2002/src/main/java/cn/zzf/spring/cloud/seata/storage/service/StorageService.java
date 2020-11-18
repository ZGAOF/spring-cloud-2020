package cn.zzf.spring.cloud.seata.storage.service;

import cn.zzf.spring.cloud.seata.storage.mapper.StorageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GaoFeng
 * @date 2020/11/12 11:43
 */
@Service
@Slf4j
public class StorageService {
    @Autowired
    private StorageMapper storageMapper;

    public void deduct(Integer quantity) {
        log.info("开始更新产品库存");
        // int i = 10 / 0;
        storageMapper.update(quantity);
        log.info("更新产品库存成功");
    }
}
