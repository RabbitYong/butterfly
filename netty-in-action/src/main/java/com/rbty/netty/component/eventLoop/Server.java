package com.rbty.netty.component.eventLoop;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/5/27 9:29
 */
@Slf4j
public class Server {
    public static void main(String[] args) throws InterruptedException {
        DefaultEventLoopGroup normalWorkers = new DefaultEventLoopGroup(2);
        NioEventLoopGroup nioWorkers = new NioEventLoopGroup(3);
        new ServerBootstrap()
                .group(new NioEventLoopGroup(1), new NioEventLoopGroup(2))
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
                        ch.pipeline().addLast(normalWorkers, "normalHandler",
                                new ChannelInboundHandlerAdapter() {
                                    @Override
                                    public void channelRead(ChannelHandlerContext ctx, Object msg) {
                                        log.debug(msg.toString());
                                    }
                                });
                    }
                }).bind(8081)
                .sync();
    }
}
