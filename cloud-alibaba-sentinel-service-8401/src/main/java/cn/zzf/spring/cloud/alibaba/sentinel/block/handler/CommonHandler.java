package cn.zzf.spring.cloud.alibaba.sentinel.block.handler;

import cn.zzf.spring.cloud.entity.ResponseResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author GaoFeng
 * @date 2020/11/9 23:46
 */
public class CommonHandler {
    public static ResponseResult<Object> urlBlockHandle(BlockException blockException) {
        return ResponseResult.fail(-2, "urlBlockHandle");
    }
}
