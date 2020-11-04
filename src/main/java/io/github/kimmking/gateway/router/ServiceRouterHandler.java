package io.github.kimmking.gateway.router;

import io.github.kimmking.gateway.outbound.httpclient4.HttpOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;

import java.util.HashMap;
import java.util.Map;

public class ServiceRouterHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpRequest request = (FullHttpRequest)msg;
        Map<String,String> routeMap = new HashMap<>();
        routeMap.put("/service1","http://www.baidu.com");
        routeMap.put("/service2","https://www.sogou.com/");
        String host = routeMap.get(request.uri());
        request.setUri(host);
        HttpOutboundHandler httpOutboundHandler = new HttpOutboundHandler(request.uri());
        httpOutboundHandler.handle(request,ctx);
    }

}
