package io.github.kimmking.gateway;


import io.github.kimmking.gateway.netty.NettyServer;
public class GatewayApplication {
    public static void main(String[] args) {
        try {
            new NettyServer(8888).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
