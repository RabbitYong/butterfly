package com.rbty.netty.chapter1;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("服务开启，等待连接");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("服务连接，等待数据");

            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            String request, response;

        }
    }
}
