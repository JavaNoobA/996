package com.eru.demo.lambda.cart;

import com.alibaba.fastjson.JSON;
import com.eru.demo.lambda.file.FileService;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by eru on 2019/12/14.
 */
public class FileHandlerTest {

    @Test
    public void fileHandlerTest() throws IOException {
        FileService.fileHandler("C:\\Code\\do\\201912\\996" +
                "\\src\\test\\java\\com\\eru\\demo\\lambda\\cart\\FileHandlerTest.java",
                fileContent -> System.out.println(JSON.toJSONString(fileContent, true)));
    }
}
