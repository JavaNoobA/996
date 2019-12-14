package com.eru.demo.resource;

import com.eru.demo.lambda.file.FileConsumer;
import org.junit.Test;

import java.io.*;

/**
 * Created by eru on 2019/12/14.
 */
public class NewFileCopyTest {
    @Test
    public void newFileCopyTest(String url, FileConsumer flleConsumer){
        try(
            FileInputStream fileInputStream = new FileInputStream(url);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null){
                sb.append(line);
            }
            // 调用函数式接口方法，将文件内容传递给lambda表达式，实现业务逻辑
            flleConsumer.fileHandler(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
