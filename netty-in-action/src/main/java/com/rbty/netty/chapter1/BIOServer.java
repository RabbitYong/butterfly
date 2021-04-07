package com.rbty.netty.chapter1;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);

            System.out.println("服务开启，等待连接");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("服务连接，等待数据");

                new Thread(new BioServerHandler(socket)).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
