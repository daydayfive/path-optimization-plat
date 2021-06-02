package com.cqu.config;

import com.cqu.mq.TaskConsumerMessageListener;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootConfiguration
public class TaskConsumerMQListener {

    @Value("${mq.rocketmq.name-server}")
    private String namesrvAddr;

    @Value("${mq.rocketmq.consumer.group}")
    private String groupName;

    @Value("${mq.task.match.topic}")
    private String topic;

    @Value("${mq.task.match.tag}")
    private String tag;

    @Value("${mq.rocketmq.consumer.consumeThreadMin}")
    private int consumeThreadMin;
    @Value("${mq.rocketmq.consumer.consumeThreadMax}")
    private int consumeThreadMax;

    @Bean
    public DefaultMQPushConsumer getPaymentRocketMQConsumer() throws MQClientException {

        DefaultMQPushConsumer consumer= new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.setConsumeThreadMax(consumeThreadMax);
        consumer.setConsumeThreadMin(consumeThreadMin);
        consumer.registerMessageListener(new TaskConsumerMessageListener());
        consumer.subscribe(topic,tag);
        consumer.start();
        System.out.println("TaskConsumerMQListener消费者启动");
        return consumer;

    }










}
