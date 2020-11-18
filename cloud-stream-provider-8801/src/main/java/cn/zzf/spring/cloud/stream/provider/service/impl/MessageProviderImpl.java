package cn.zzf.spring.cloud.stream.provider.service.impl;

import cn.zzf.spring.cloud.stream.provider.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @author GaoFeng
 * @date 2020/11/5 22:33
 */
@Slf4j
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String seq = UUID.randomUUID().toString();
        boolean send = output.send(MessageBuilder.withPayload(seq).build());
        log.info(seq + "-isSend:" + send);
        return null;
    }



}
