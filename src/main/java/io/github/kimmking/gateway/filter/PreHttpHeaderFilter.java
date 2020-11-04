package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @Created by aaron.zqf 2020/11/3
 */
public class PreHttpHeaderFilter extends HttpRequestFilter{
    @Override
    public void doFilter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        System.out.println("execute headerFilter");
        execute(fullRequest,ctx);
    }
}
