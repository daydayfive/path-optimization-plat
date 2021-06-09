//package com.cqu.config;
//
//import com.cqu.mq.ResultConsumerListener;
//
//import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
//import org.apache.rocketmq.client.exception.MQClientException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.context.annotation.Bean;
//
//
//
//public class ResultConsumerMQConfig {
//
//    @Value("${mq.rocketmq.name-server}")
//    private String namesrvAddr;
//
//    @Value("${mq.rocketmq.match-result-consumer.group}")
//    private String groupName;
//
//
//
////    @Value("${mq.task.match.tag}")
////    private String tag;
//
//    @Value("${mq.rocketmq.match-result-consumer.consumeThreadMin}")
//    private int consumeThreadMin;
//    @Value("${mq.rocketmq.match-result-consumer.consumeThreadMax}")
//    private int consumeThreadMax;
//
//    @Bean
//    public DefaultMQPushConsumer getPaymentRocketMQConsumer() throws MQClientException {
//
//        DefaultMQPushConsumer consumer= new DefaultMQPushConsumer(groupName);
//        consumer.setNamesrvAddr(namesrvAddr);
//        consumer.setConsumeThreadMax(consumeThreadMax);
//        consumer.setConsumeThreadMin(consumeThreadMin);
//        consumer.registerMessageListener(new ResultConsumerListener());
////        consumer.subscribe(topic,tag);
////        consumer.start();
////        System.out.println("TaskConsumerMQListener消费者启动");
//        return consumer;
//
//    }
//
//
//
//
//
//
//
//
//
//
//}
