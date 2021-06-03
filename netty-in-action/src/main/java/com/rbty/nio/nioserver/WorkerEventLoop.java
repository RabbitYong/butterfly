package com.rbty.nio.nioserver;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.rbty.nio.bytebuffer.ByteBufferUtil.debugAll;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/5/21 10:59
 */
@Slf4j
public class WorkerEventLoop implements Runnable{
    SocketChannel socketChannel;
    Selector selector ;
    private final ConcurrentLinkedQueue<Runnable> tasks = new ConcurrentLinkedQueue<>();

    private WorkerEventLoop (SocketChannel socketChannel){
        this.socketChannel = socketChannel;
    }

    public static WorkerEventLoop register(SocketChannel socketChannel){
        return new WorkerEventLoop(socketChannel);
    }

    public void loop(){
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_READ);
            //selector.wakeup();
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iter = keys.iterator();
            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                if (key.isReadable()) {
                    SocketChannel sc = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(128);
                    try {
                        int read = sc.read(buffer);
                        if (read == -1) {
                            key.cancel();
                            sc.close();
                        } else {
                            buffer.flip();
                            log.debug("{} message:", sc.getRemoteAddress());
                            debugAll(buffer);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        key.cancel();
                        sc.close();
                    }
                }
                iter.remove();
            }
        }catch(Exception e){

        }
    }
}
