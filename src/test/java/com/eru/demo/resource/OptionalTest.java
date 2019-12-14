package com.eru.demo.resource;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by eru on 2019/12/14.
 */
public class OptionalTest {

    @Test
    public void test(){

        // 创建空的optional对象
        Optional.empty();

        Optional.of("erudev");

        Optional.ofNullable("erudev");
    }
}
