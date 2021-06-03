package com.rbty.nio.channel;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/23 15:37
 */
public class TestFileChannel {
    public static void main(String[] args) throws IOException {
        String FROM = "netty-in-action\\src\\main\\resources\\data.txt";
        String TO = "netty-in-action\\src\\main\\resources\\to.txt";

        File file;
        try (FileChannel from = new FileInputStream(FROM).getChannel();
            FileChannel to = new FileOutputStream(TO).getChannel()) {
            from.transferTo(0, from.size(),to);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Files.walkFileTree(Paths.get(""),new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                Objects.requireNonNull(dir);
                Objects.requireNonNull(attrs);
                return FileVisitResult.CONTINUE;
            }
        });


    }
}
