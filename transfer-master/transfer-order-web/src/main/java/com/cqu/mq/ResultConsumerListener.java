//package com.cqu.mq;
//
//
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
//import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
//import org.apache.rocketmq.common.message.MessageExt;
//import org.springframework.beans.factory.annotation.Value;
//
//import java.util.List;
//
//@Slf4j
//public class ResultConsumerListener implements MessageListenerConcurrently {
//
//
//        @Value("${mq.task.match.result.topic}")
//        String topic;
//
//
//
//
//        @SneakyThrows
//        @Override
//        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
//
//
//            for(MessageExt messageExt:list){
//
//
//
//
//            }
//
//
//            // 消费者流程
//            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//        }
//
//
//
//
//
//}
//
//
