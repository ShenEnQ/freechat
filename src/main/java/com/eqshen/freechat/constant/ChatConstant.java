package com.eqshen.freechat.constant;

public class ChatConstant {
    //webSocket相关配置
    //ws请求路径前缀
    public static String WEBSOCKET_PATH_PERFIX = "/ws";
    //socket名称
    public static String WEBSOCKE_NAME = "/endpointChat";

    //消息代理路径
    public static String WEBSOCKET_BROADCAST_PATH = "/topic";
    //前端发送给服务端请求地址
    public static final String FORE_TO_SERVER_PATH = "/welcome";
    //服务端生产地址,客户端订阅此地址以接收服务端生产的消息
    public static final String PRODUCER_PATH = "/topic/chat";
    //点对点消息推送地址前缀
    public static final String P2P_PUSH_BASE_PATH = "/user";
    //点对点消息推送地址后缀,最后的地址为/user/用户识别码/msg
    public static final String P2P_PUSH_PATH = "/msg";
}
