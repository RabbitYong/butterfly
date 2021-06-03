package com.rbty.nio.nioserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/5/21 9:29
 */
public class Server {
    int port;
    public Server(int port){
        this.port = port;
    }

    public void startup(){
        try {
            ServerSocketChannel server = ServerSocketChannel.open();
            Selector selector = Selector.open();
            server.bind(new InetSocketAddress(port));
            server.configureBlocking(false);
            server.register(selector, SelectionKey.OP_ACCEPT);
            //selector.select();
            SocketAccepter socketAccepter = new SocketAccepter(selector);
            new Thread(socketAccepter).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server(8081);
        server.startup();
    }
}
