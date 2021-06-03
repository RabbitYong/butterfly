package com.rbty.nio.bytebuffer;

import java.nio.ByteBuffer;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/22 14:32
 */
public class TestByteBufferReadWrite {
    // position limit capacity
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        //a
        byteBuffer.put((byte) 0x61);
        //b,c,d
        byteBuffer.put(new byte[]{0x62,0x63,0x64});

        byteBuffer.flip();

        System.out.println(byteBuffer.get());

        //切换写模式，将未读取的内容 前移
        byteBuffer.compact();

    }
}
