package com.example.order.Config;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceInfoUtil implements ApplicationListener<WebServerInitializedEvent> {
    //声明event对象，获取运行服务器的本地端口
    private static WebServerInitializedEvent event;
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        ServiceInfoUtil.event = event;
    }
    //获取端口号
    public static int getPort(){
        int port = event.getWebServer().getPort();
        return port;
    }
}
