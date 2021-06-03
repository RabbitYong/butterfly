package com.rbty.nio.nioserver;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/5/21 9:29
 */
@Slf4j
public class SocketAccepter implements Runnable{
    private Selector selector ;

    public SocketAccepter(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        while (true){
            try {
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while(iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (key.isAcceptable()) {
                        ServerSocketChannel c = (ServerSocketChannel) key.channel();
                        SocketChannel sc = c.accept();
                        sc.configureBlocking(false);
                        log.debug("{} connected", sc.getRemoteAddress());
                        WorkerEventLoop.register(sc).loop();
                        //workers[index.getAndIncrement() % workers.length].register(sc);
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
