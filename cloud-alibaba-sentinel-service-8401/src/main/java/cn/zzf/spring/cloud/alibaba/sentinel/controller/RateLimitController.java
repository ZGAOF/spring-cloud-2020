package cn.zzf.spring.cloud.alibaba.sentinel.controller;

import cn.zzf.spring.cloud.alibaba.sentinel.block.handler.CommonHandler;
import cn.zzf.spring.cloud.entity.ResponseResult;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GaoFeng
 * @date 2020/11/9 23:40
 */
@Slf4j
@RestController
@RequestMapping("/rate/limit")
@Validated
public class RateLimitController {

    @GetMapping("/resource")
    @SentinelResource(value = "byResource", blockHandler = "commonBlockHandler")
    public ResponseResult<String> byResource() {
        return ResponseResult.ok("rate limit by resource");
    }

    @GetMapping("/url")
    @SentinelResource(value = "byUrl",
            blockHandlerClass = CommonHandler.class, blockHandler = "urlBlockHandle")
    public ResponseResult<String> byUrl() {
        return ResponseResult.ok("rate limit by url");
    }

    public ResponseResult<Object> commonBlockHandler(BlockException blockException) {
        return ResponseResult.fail(-1, "rate limit common block handler");
    }

}
