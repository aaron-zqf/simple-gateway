package io.github.kimmking.gateway;


import io.github.kimmking.gateway.netty.NettyServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApplication implements CommandLineRunner {

    @Value(value = "${server.port}")
    private int port;
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        new NettyServer(port).run();
    }
}
