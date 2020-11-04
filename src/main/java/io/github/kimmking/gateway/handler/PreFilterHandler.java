package io.github.kimmking.gateway.handler;

import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.github.kimmking.gateway.filter.PreHttpAuthFilter;
import io.github.kimmking.gateway.filter.PreHttpHeaderFilter;
import io.github.kimmking.gateway.filter.PreHttpParamFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @Created by aaron.zqf 2020/11/3
 */
public class PreFilterHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpRequest response = (FullHttpRequest)msg;
        HttpRequestFilter headerFilter = new PreHttpHeaderFilter();
        HttpRequestFilter authFilter = new PreHttpAuthFilter();
        HttpRequestFilter paramFilter = new PreHttpParamFilter();
        headerFilter.setHttpRequestFilter(authFilter);
        authFilter.setHttpRequestFilter(paramFilter);
        headerFilter.doFilter(response,ctx);
        ctx.fireChannelRead(msg);
    }
}
