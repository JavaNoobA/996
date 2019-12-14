package com.eru.demo.resource;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7之前的文件拷贝
 * Created by eru on 2019/12/14.
 */
public class FileCopyTest {

    @Test
    public void copyTest(){
        String originUrl = "lib/FileCopyTest.java";
        String targetUrl = "targetTest/target.txt";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(originUrl);
            fileOutputStream = new FileOutputStream(targetUrl);

            int content;

            while ((content = fileInputStream.read()) != -1){
                fileOutputStream.write(content);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            // 关闭流资源
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
