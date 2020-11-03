package io.github.kimmking.gateway.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Created by aaron.zqf 2020/11/3
 */
public class CurrentLimitHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("execute CurrentLimitHandler");
        ctx.fireChannelRead(msg);
    }
}
