package com.rbty.nio.bytebuffer;

import java.nio.ByteBuffer;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/22 14:45
 */
public class TestByteBufferRead {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a','b','c','d'});

        buffer.flip();

        buffer.get(new byte[4]);

        //将 position 设置为 0，重新读取
        buffer.rewind();
        System.out.println(buffer.get());

        // mark & reset
        // 标记    跳转到标记处
        buffer.get();
        buffer.get();
        buffer.mark();
        buffer.get();
        buffer.reset();
        System.out.println(buffer.get());

        // get(i) 不改变 position
        System.out.println(buffer.get(0));
    }
}
