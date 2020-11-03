package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public abstract class HttpRequestFilter {

    public abstract void doFilter(FullHttpRequest fullRequest, ChannelHandlerContext ctx);

    public HttpRequestFilter httpRequestFilter;

    public void setHttpRequestFilter(HttpRequestFilter filter){
        this.httpRequestFilter = filter;
    }

    public void execute(FullHttpRequest fullRequest, ChannelHandlerContext ctx){
        if (null != httpRequestFilter){
            httpRequestFilter.doFilter(fullRequest,ctx);
        }
    }
}
