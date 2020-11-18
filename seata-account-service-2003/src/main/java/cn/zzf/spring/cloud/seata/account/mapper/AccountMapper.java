package cn.zzf.spring.cloud.seata.account.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author GaoFeng
 * @date 2020/11/12 16:30
 */
public interface AccountMapper {
    int update(@Param("money") Integer money);
}
