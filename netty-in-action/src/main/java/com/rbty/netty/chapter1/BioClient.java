package com.rbty.netty.chapter1;

import java.io.*;
import java.net.Socket;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/3/30 14:49
 */
public class BioClient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 9090);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));

            String req = "<body>\n" +
                    "<business></business>\n" +
                    "</body>";
            bw.write(req);
            bw.flush();

            String message = null;
            StringBuilder sb = new StringBuilder();
            int i = 0;
            char[] buf = new char[4096];
            while ((i = br.read(buf)) != -1) {
                sb.append(buf, 0, i);
                message = sb.toString();
                if (message.contains("</body>")) {
                    break;
                }
            }
            System.out.println("message:" + message);

            System.in.read();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
