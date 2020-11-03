package io.github.kimmking.gateway.router;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class ServiceRouterHandler extends ChannelInboundHandlerAdapter {

    private static ConcurrentHashMap routeMap = new ConcurrentHashMap<>();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("execute router...");
        ctx.write(new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT));
        ctx.flush();
    }

    public static void initRouterTable(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("router", Locale.getDefault());
        Enumeration<String> keys = resourceBundle.getKeys();
        while(keys.hasMoreElements()){
            String uri = keys.nextElement();
            String targetHost = resourceBundle.getString(uri);
            routeMap.put(uri,targetHost);
        }
    }

}
