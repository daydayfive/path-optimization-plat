package com.cqu.mq;

import com.alibaba.fastjson.JSON;
import com.cqu.api.FeatureSearchService;
import com.cqu.api.TaskFeatureMakeService;
import com.cqu.pojo.Feature;
import com.cqu.pojo.SolveList;
import com.cqu.pojo.TaskFeature;
import com.cqu.pojo.TaskInfo;
import com.cqu.service.SolutionService;
import com.cqu.service.SolveListService;
import com.cqu.service.TaskFeatureService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Slf4j
public class TaskConsumerMessageListener  implements MessageListenerConcurrently {


        @DubboReference(version="${featuremake.version}",url="${featuremake.url}")
        private TaskFeatureMakeService taskFeatureMakeService;

        @DubboReference(version="${featuresearch.version}",url="${featuresearch.url}")
        private FeatureSearchService featureSearchService;


        @Autowired
        TaskFeatureService taskFeatureService;

        @Autowired
        SolutionService solutionService;

        @Autowired
        SolveListService solveListService;

//        @Autowired
//        DefaultMQProducer producer;
//
//        @Value("${mq.task.result.topic}")
//        String topic;




        @SneakyThrows
        @Override
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {


            for(MessageExt messageExt:list){

                //1.解析消息
                String body = new String(messageExt.getBody(),"UTF-8");
                TaskInfo info= JSON.parseObject(body,TaskInfo.class);
                log.info("任务已收到"+messageExt.getMsgId());


                //2.特征构造
                // 写入数据库
                Feature feature = featureMake(info);

                TaskFeature taskFeature=new TaskFeature();
                taskFeature.setTaskId(info.getTask().getTaskId());
                taskFeature.setCreateTime(new Date());
                taskFeature.setLastEditTime(new Date());
                taskFeatureService.insertOne(taskFeature);



                //3.特征匹配
                List<Long> ids=featureMatch(feature);



                //4.找到k个任务中有解的任务id
                Long id=matchSolved(ids);



                //5. 构建任务清单，然后让算法服务去求解

                SolveList toDoList = createToDoList(id, info.getTask().getTaskId());



//                sendProducerOrder(topic,Long.toString(info.getUserId()),JSON.toJSONString(toDoList));


            }


            // 消费者流程
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }

        //特征构造
        public Feature featureMake(TaskInfo info){
            return taskFeatureMakeService.generateFeatrue(info);

        }

        //特征匹配，返回最接近任务k个任务的mivus-id
        public List<Long> featureMatch(Feature feature){
            return featureSearchService.getTopKIds(feature,10);
        }


        public Long matchSolved(List<Long> ids){
            for(Long id:ids){
                Long similarTask = solutionService.getSimilarTask(id);
                if(similarTask!=null) return similarTask;
            }
            return null;

        }



         //5.构建任务清单
        public SolveList createToDoList(Long similarId,Long optimizedId){
            //不存在
            SolveList solveList=new SolveList();
            solveList.setCreateTime(new Date());
            solveList.setSimilarTaskId(similarId);
            solveList.setOptimizedId(optimizedId);
            solveList.setLastEditTime(new Date());
            solveListService.insertSolveList(solveList);
            //
            return solveList;
        }


        //发送匹配结果

//        private void sendProducerOrder(String topic,String tag,String body) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
//            Message message= new Message(topic,tag,body.getBytes(StandardCharsets.UTF_8));
//            SendResult send = producer.send(message);
//        }

}


