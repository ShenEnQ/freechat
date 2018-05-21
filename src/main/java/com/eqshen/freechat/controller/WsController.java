package com.eqshen.freechat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eqshen.freechat.constant.ChatConstant;
import com.eqshen.freechat.domain.ChatMessage;
import com.eqshen.freechat.domain.ChatResponse;
import com.eqshen.freechat.service.WebSocketService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class WsController {
    @Resource
    WebSocketService webSocketService;

    //@MessageMapping和@RequestMapping功能类似，用于设置URL映射地址，浏览器向服务器发起请求，需要通过该地址。
    @MessageMapping(ChatConstant.FORE_TO_SERVER_PATH)
    @SendTo(ChatConstant.PRODUCER_PATH)//如果服务器接受到了消息，就会对订阅了@SendTo括号中的地址传送消息。
    public Object brodcast(String messageJsonStr) throws Exception {
//        ChatMessage message = new ChatMessage();
//        message.setName(name);
//        message.setUserId(userId);
//        message.setMsg(msg);
//        message.setDate(new Date());
//        List<String> users = new ArrayList<>();
//        users.add("123456");//此处写死只是为了方便测试,此值需要对应页面中订阅个人消息的userId
//        webSocketService.send2Users(users, new ChatMessage());
        JSONObject jsOnObject = JSONObject.parseObject(messageJsonStr);
        jsOnObject.put("date",new Date());
             return jsOnObject;
    }

    @PostMapping("/chatP2p")
    @ResponseBody
    public Object chatP2p(String userId,ChatMessage message){
        webSocketService.send2User(userId, message);
        ChatResponse resp = new ChatResponse();
        resp.setCode("200");
        resp.setMsg("发送成功");
        return  resp;
    }
}
