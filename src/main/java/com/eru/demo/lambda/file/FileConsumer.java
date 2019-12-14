package com.eru.demo.lambda.file;

/**
 * 文件处理函数式接口
 * Created by eru on 2019/12/14.
 */
@FunctionalInterface
public interface FileConsumer {

    void fileHandler(String fileContent);
}
