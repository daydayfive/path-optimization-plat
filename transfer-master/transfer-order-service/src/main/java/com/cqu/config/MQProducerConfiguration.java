package com.cqu.config;


import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;


// 该生产者用于返回匹配结果，让 原来的生产者去订阅他，topic采用生产者的id
@SpringBootConfiguration
public class MQProducerConfiguration {

    @Value("${mq.rocketmq.producer.group}")
    private String producerGroup;

    @Value("${mq.rocketmq.name-server}")
    private String namesrvAddr;

    @Value("${mq.rocketmq.producer.send-message.timeout}")
    private int sendMsgTimeout;


    @Bean
    public DefaultMQProducer getRocketMQProducer() throws MQClientException {
        DefaultMQProducer producer;
        producer=new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setSendMsgTimeout(sendMsgTimeout);
        producer.start();
        System.out.println("匹配结果生产者启动");

        return producer;

    }


}
