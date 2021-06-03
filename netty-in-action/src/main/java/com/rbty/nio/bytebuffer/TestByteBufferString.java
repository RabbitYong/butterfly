package com.rbty.nio.bytebuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/22 14:50
 */
public class TestByteBufferString {
    public static void main(String[] args) {
        //字符串转为 ByteBuffer
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(16);
        byteBuffer1.put("hello".getBytes());

        //自动切换读模式
        ByteBuffer byteBuffer2 = StandardCharsets.UTF_8.encode("hello");

        //wrap
        ByteBuffer byteBuffer3 = ByteBuffer.wrap("hello".getBytes());

        StandardCharsets.UTF_8.decode(byteBuffer2).toString();



    }
}
