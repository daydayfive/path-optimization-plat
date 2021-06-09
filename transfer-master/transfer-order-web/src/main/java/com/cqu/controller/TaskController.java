package com.cqu.controller;



import com.alibaba.fastjson.JSON;

import com.cqu.pojo.Result;
import com.cqu.pojo.Task;
import com.cqu.pojo.TaskInfo;
import com.cqu.mapperservice.TaskService;

import com.cqu.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;


// 负责任务的处理，即上传， 匹配以及生成
@Controller
@Slf4j
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private DefaultMQProducer producer;



    @Value("${mq.rocketmq.producer.group}")
    private String groupName;

    @Value("${mq.task.match.topic}")
    private String topic;

    @Value("${mq.task.match.tag}")
    private String tag;


    @GetMapping("/upload")
    public String upload(){
        return "upload";
    }


    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file , HttpSession httpSession, Model model){

        if(file.isEmpty()){
            log.warn("导入的文件为空");
        }
        String fileName=file.getOriginalFilename();

        String filePath="D://task";
        File dest= new File(filePath+"/"+fileName);


        try{
            file.transferTo(dest);
            log.info("上传成功");
            //将任务
            Task task=new Task();
            task.setTaskName(fileName);
            task.setTaskAddr(filePath+"/"+fileName);
            task.setCreateTime(new Date());
            task.setLastEditTime(new Date());

            taskService.insertTask(task);


            return "上传成功";


        } catch (IOException e) {
            log.error("文件上传失败");
            e.printStackTrace();
        }


        return "上传失败";
    }



    @GetMapping ("/match")
    public String match(HttpSession httpSession) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {


        TaskInfo task=new TaskInfo();
        User loginUser= (User) httpSession.getAttribute("loginUser");
        task.setUserId(loginUser.getUserId());
        sendProducerOrder(topic,tag, JSON.toJSONString(task));
        System.out.println(Thread.currentThread());

        return "service";
    }


    private void sendProducerOrder(String topic,String tag,String body) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        Message message= new Message(topic,tag,body.getBytes(StandardCharsets.UTF_8));
        SendResult send = producer.send(message);
        System.out.println("消息发送成功");

    }

}
