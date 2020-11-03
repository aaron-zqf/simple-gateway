package io.github.kimmking.gateway.handler;

import io.github.kimmking.gateway.router.ServiceRouterHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Created by aaron.zqf 2020/11/3
 */
public class HandlerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline p = socketChannel.pipeline();
//		if (sslCtx != null) {
//			p.addLast(sslCtx.newHandler(ch.alloc()));
//		}
        p.addLast(new HttpServerCodec());
        //p.addLast(new HttpServerExpectContinueHandler());
        p.addLast(new HttpObjectAggregator(1024 * 1024));
        p.addLast(new BlacklistHandler());
        p.addLast(new CurrentLimitHandler());
        p.addLast(new PreFilterHandler());
        p.addLast(new ServiceRouterHandler());
//        p.addLast(new HttpInboundHandler(this.proxyServer));
    }
}
