package com.rbty.nio.bytebuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/22 15:15
 */
public class TestByteBufferExam {
    public static void main(String[] args) {
        /* 网络上有多条数据发送给服务器，数据之间使用 \n 分割
        有与某种原因 这些数据在接收时。被进行了重新组合，例如原始数据有3条
            Hello,world\n
            I am zhangsan\n
            How are you?\n
           变成了下面两个 bytebuffer （黏包，半包）
            Hello,world\nI am zhangsan\nHo
            w are you?\n
            要求编写程序 还原
         */
        //System.out.println("Hello,world\nI am zhangsan\nHow are you?\n".getBytes().length);
        ByteBuffer buffer = ByteBuffer.allocate(39);
        buffer.put("Hello,world\nI am zhangsan\nHo".getBytes());
        split(buffer);
        buffer.compact();
        buffer.put("w are you?\n".getBytes());
        split(buffer);
    }

    public static void split(ByteBuffer source){
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            if (source.get(i) == '\n'){
                int length = i+1-source.position();
                ByteBuffer buffer = ByteBuffer.allocate(length);

                for (int j = 0; j < length; j++) {
                    buffer.put(source.get());
                }
                buffer.flip();
                System.out.println(StandardCharsets.UTF_8.decode(buffer));
            }
        }
    }
}
