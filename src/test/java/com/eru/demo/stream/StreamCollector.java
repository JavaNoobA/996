package com.eru.demo.stream;

import com.alibaba.fastjson.JSON;
import com.eru.demo.lambda.cart.CartService;
import com.eru.demo.lambda.cart.Sku;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 常见预定义收集器使用
 * Created by eru on 2019/12/14.
 */
public class StreamCollector {

    List<Sku> list = CartService.getCartSkuList();

    /**
     * 集合收集器
     */
    @Test
    public void toListTest(){
        List<Sku> result =
                list.stream()
                .filter(sku -> sku.getTotalPrice() > 100)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(result, true));
    }

    /**
     * 分组
     */
    @Test
    public void group(){
        // Map<分组条件, 结果集合>
        Map<Object, List<Sku>> result = list.stream()
                .collect(Collectors.groupingBy(sku -> sku.getSkuCategory()));
        System.out.println(JSON.toJSONString(result, true));
    }

    /**
     * 分区
     */
    @Test
    public void partitionTest(){
        Map<Boolean, List<Sku>> result = list.stream()
                .collect(Collectors.partitioningBy(sku -> sku.getTotalPrice() > 100));
        System.out.println(JSON.toJSONString(result, true));
    }
}
