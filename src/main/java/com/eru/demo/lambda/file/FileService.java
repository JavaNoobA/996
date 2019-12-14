package com.eru.demo.lambda.file;

import java.io.*;

/**
 * 文件服务类
 * Created by eru on 2019/12/14.
 */
public class FileService {

    public static void fileHandler(String url, FileConsumer fileConsumer) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(url)));
        String line;
        StringBuilder sb = new StringBuilder();

        while ((line=bufferedReader.readLine()) != null){
            sb.append(line);
        }
        fileConsumer.fileHandler(sb.toString());
    }
}
