package com.eqshen.freechat.service;

import com.eqshen.freechat.constant.ChatConstant;
import com.eqshen.freechat.domain.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class WebSocketService {
    @Autowired
    private SimpMessagingTemplate template;

    /**
     * 广播
     * 发给所有在线用户
     *
     * @param msg
     */
    public void sendMsg(ChatMessage msg) {
        template.convertAndSend(ChatConstant.PRODUCER_PATH, msg);
    }

    /**
     * 发送给指定用户
     * @param users
     * @param msg
     */
    public void send2Users(List<String> users, ChatMessage msg) {
        users.forEach(userName -> {
            template.convertAndSendToUser(userName, ChatConstant.P2P_PUSH_PATH, msg);
        });
    }


    public void send2User(String userId, ChatMessage msg) {
        template.convertAndSendToUser(userId, ChatConstant.P2P_PUSH_PATH, msg);
    }
}
