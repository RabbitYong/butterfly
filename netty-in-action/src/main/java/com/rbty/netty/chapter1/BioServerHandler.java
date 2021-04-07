package com.rbty.netty.chapter1;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/3/30 14:46
 */
public class BioServerHandler implements Runnable{
    private Socket socket;
    private BufferedReader br;
    private BufferedWriter bw;
    public BioServerHandler(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //获取BufferedReader和BufferedWriter，设置socket数据编码为UTF-8
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            //判断客户端连接断开,客户端断开，线程退出
            try {
                socket.sendUrgentData(0);
            } catch (IOException e) {
                break;
            }
            try {
                //1、数据有固定的协议，或者以某个字符串结尾，这种按照协议来解析就行
                /**
                 *  以xml数据为例：
                 *  <?xml version="1.0" encoding="utf-8"?>
                 *  <body>
                 *      <business></business>
                 *   </body>
                 */
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

                //2、数据以\r或者\n结尾，使用readLine读取
//                String line = null;
//                while((line = br.readLine()) != null) {
//                    message += line;
//                }

                /**
                 *  3、如果数据没有固定字符串结尾，也没有\n结尾，那就只有等待超时：SocketTimeoutException
                 *  socket.setSoTimeout(8000);
                 *
                 */

                bw.write(message);
                bw.flush();

            }catch(SocketTimeoutException e){
                //e.printStackTrace();
                //如果设置了超时，此处添加自己的read超时处理机制
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
