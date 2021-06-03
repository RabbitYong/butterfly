package com.rbty.nio.bytebuffer;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/21 10:50
 */
@Slf4j
public class TestByteBuffer {
    //static Logger logger = LoggerFactory.getLogger(TestByteBuffer.class);
    public static void main(String[] args) {
        log.debug("dd");
        URL url = TestByteBuffer.class.getClassLoader().getResource("data.txt");
        try {
            assert url != null;
            try (FileChannel channel = new FileInputStream(url.getPath()).getChannel()) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(10);
                while(channel.read(byteBuffer) != -1){
                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()){
                        byte b = byteBuffer.get();
                        System.out.println((char) b);
                    }
                    byteBuffer.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
