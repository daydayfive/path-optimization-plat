package com.cqu.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// 登录后跳转到这，进入服务界面
@Controller
@Slf4j
public class TransferController {

    @GetMapping("/service")
    public  String service(){
        return "service";
    }




}
