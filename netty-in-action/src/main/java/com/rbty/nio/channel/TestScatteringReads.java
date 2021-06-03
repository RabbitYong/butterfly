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
 * @date 2021/4/22 14:57
 */
public class TestScatteringReads {
    public static void main(String[] args) {
        URL url = TestScatteringReads.class.getClassLoader().getResource("words.txt");
        assert url != null;
        try (FileChannel fileChannel = new RandomAccessFile(url.getPath(),"r").getChannel();){
            ByteBuffer b1 = ByteBuffer.allocate(5);
            ByteBuffer b2 = ByteBuffer.allocate(4);
            ByteBuffer b3 = ByteBuffer.allocate(4);

            fileChannel.read(new ByteBuffer[]{b1,b2,b3});
            b1.flip();
            b2.flip();
            b3.flip();

            System.out.println(StandardCharsets.UTF_8.decode(b1));
            System.out.println(StandardCharsets.UTF_8.decode(b2));
            System.out.println(StandardCharsets.UTF_8.decode(b3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
