package com.rbty.nio.bytebuffer;

import java.nio.ByteBuffer;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/22 14:40
 */
public class TestByteBufferAllocate {
    public static void main(String[] args) {
        //堆内存 读写效率低 收到GC影响 GC时会进行数据复制迁移
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        //直接内存 读写效率高 不受GC影响 分配效率低
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(16);
        //class java.nio.HeapByteBuffer
        System.out.println(byteBuffer.getClass());
        //class java.nio.DirectByteBuffer
        System.out.println(directBuffer.getClass());

    }
}
