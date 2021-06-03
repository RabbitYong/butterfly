package com.rbty.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/22 15:06
 */
public class TestGatheringWrites {
    public static void main(String[] args) {
        ByteBuffer b1 = StandardCharsets.UTF_8.encode("hello");
        ByteBuffer b2 = StandardCharsets.UTF_8.encode("world");
        ByteBuffer b3 = StandardCharsets.UTF_8.encode("你好");

        try (FileChannel fileChannel = new RandomAccessFile("word2.txt", "rw").getChannel()) {
            fileChannel.write(new ByteBuffer[]{b1,b2,b3});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
