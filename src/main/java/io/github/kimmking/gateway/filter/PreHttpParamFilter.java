package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import org.springframework.stereotype.Component;

/**
 * @Created by aaron.zqf 2020/11/3
 */
@Component
public class PreHttpParamFilter extends HttpRequestFilter{
    @Override
    public void doFilter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        System.out.println("execute param");
        execute(fullRequest,ctx);
    }
}
