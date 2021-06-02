package com.cqu.mq;

import com.alibaba.fastjson.JSON;
import com.cqu.api.FeatureSearchService;
import com.cqu.api.TaskFeatureService;
import com.cqu.pojo.Feature;
import com.cqu.pojo.TaskInfo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

@Slf4j
public class TaskConsumerMessageListener  implements MessageListenerConcurrently {


        @DubboReference(version="${featuremake.version}",url="${featuremake.url}")
        private TaskFeatureService taskFeatureService;

        @DubboReference(version="${featuresearch.version}",url="${featuresearch.url}")
        private FeatureSearchService featureSearchService;





        @SneakyThrows
        @Override
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {


            for(MessageExt messageExt:list){

                //1.解析消息
                String body = new String(messageExt.getBody(),"UTF-8");
                TaskInfo info= JSON.parseObject(body,TaskInfo.class);
                log.info("任务已收到");



                //2.特征构造
                Feature feature = taskFeatureService.generateFeatrue(info);

                //3.特征匹配


            }


            // 消费者流程
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }

}


