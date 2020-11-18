package cn.zzf.spring.cloud.seata.storage.mapper;

import cn.zzf.spring.cloud.entity.ProductStorage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GaoFeng
 * @date 2020/11/12 11:17
 */
public interface StorageMapper {
    int insert(ProductStorage storage);
    List<ProductStorage> selectByUserId(Long userId);
    int update(@Param("quantity") Integer quantity);
}
