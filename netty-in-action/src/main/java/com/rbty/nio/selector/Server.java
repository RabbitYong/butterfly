package com.rbty.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import static com.rbty.nio.bytebuffer.ByteBufferUtil.debugAll;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/5/18 10:57
 */
public class Server {
    public static void main(String[] args){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 30_000_000; i++) {
            stringBuilder.append("d");
        }

        try (Selector selector = Selector.open();
             ServerSocketChannel server = ServerSocketChannel.open()) {
            server.bind(new InetSocketAddress(8081));
            server.configureBlocking(false);
            server.register(selector, SelectionKey.OP_ACCEPT);

            while (true){
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while(iterator.hasNext()){

                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()){
                        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = channel.accept();
                        socketChannel.configureBlocking(false);
                        //ByteBuffer byteBuffer = ByteBuffer.allocate(4);
                        socketChannel.register(selector,SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                    }else if (key.isWritable()){
                        SocketChannel channel = (SocketChannel) key.channel();


                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        if (buffer == null){
                            buffer = StandardCharsets.UTF_8.encode(stringBuilder.toString());
                        }
                        int write = channel.write(buffer);
                        System.out.println(write);
                        if (buffer.hasRemaining()){
                            key.attach(buffer);
                        }else {
                            key.interestOps(key.interestOps() - SelectionKey.OP_WRITE);
                            key.attach(null);
                        }
                    }
                    iterator.remove();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void split(ByteBuffer source) {
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            // 找到一条完整消息
            if (source.get(i) == '\n') {
                int length = i + 1 - source.position();
                // 把这条完整消息存入新的 ByteBuffer
                ByteBuffer target = ByteBuffer.allocate(length);
                // 从 source 读，向 target 写
                for (int j = 0; j < length; j++) {
                    target.put(source.get());
                }
                debugAll(target);
            }
        }
        source.compact(); // 0123456789abcdef  position 16 limit 16
    }
}
