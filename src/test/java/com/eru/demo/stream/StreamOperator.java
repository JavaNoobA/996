package com.eru.demo.stream;

import com.alibaba.fastjson.JSON;
import com.eru.demo.lambda.cart.CartService;
import com.eru.demo.lambda.cart.Sku;
import com.eru.demo.lambda.cart.SkuCategoryEnum;
import org.junit.Test;

import java.util.*;

/**
 * 演示流的各种操作
 * Created by eru on 2019/12/14.
 */
public class StreamOperator {

    List<Sku> list = CartService.getCartSkuList();

    /**
     * filter: 过滤掉不符合断言判断的数据
     */
    @Test
    public void filterTest(){
        list.stream()
                .filter(sku -> sku.getSkuCategory().equals(SkuCategoryEnum.BOOKS))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     * map: 将一个元素转换成另一个元素
     */
    @Test
    public void mapTest(){
        list.stream()
                .map(sku -> sku.getSkuName())
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     * flatMap: 将一个对象转换成流
     */
    @Test
    public void flatMapTest(){
        list.stream()
                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     * peek: 对流中的元素进行遍历操作, 与foreach类似, 但不会销毁流元素
     */
    @Test
    public void peekTest(){
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     * sort: 对流中的元素进行排序, 可以进行自然排序或者指定排序规则. 有状态操作
     */
    @Test
    public void sortTest(){
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     * distinct: 去重. 有状态操作
     */
    @Test
    public void distinctTest(){
        list.stream()
                .map(sku -> sku.getSkuCategory())
                .distinct()
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     * skip: 跳过几条数据. 有状态操作
     */
    @Test
    public void skipTest(){
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(3)
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     * limit: 截断前N条记录. 有状态操作
     */
    @Test
    public void limitTest(){
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(3)
                .limit(3)
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     * allMatcher: 所有匹配, 返回true. 终端操作, 短路
     */
    @Test
    public void allMatcherTest(){
        boolean match = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .allMatch(sku -> sku.getTotalPrice() > 100);
        System.out.println(match);
    }

    /**
     * anyMatcher: 任意一个匹配, 返回true. 终端操作, 短路操作
     */
    @Test
    public void anyMatcherTest(){
        boolean anyMatch = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .anyMatch(sku -> sku.getTotalPrice() > 100);
        System.out.println(anyMatch);
    }

    /**
     * noneMatcher: 没有匹配
     */
    @Test
    public void noneMatcherTest(){
        boolean noneMatch = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .noneMatch(sku -> sku.getTotalPrice() > 10_000);
        System.out.println(noneMatch);
    }

    /**
     * findFirst: 找到第一个
     */
    @Test
    public void findFirstTest(){
        Optional<Sku> sku = list.stream()
                .peek(sku1 -> System.out.println(sku1.getSkuName()))
                .findFirst();
        System.out.println(JSON.toJSONString(sku, true));
    }

    /**
     * findFirst: 找到任意一个
     */
    @Test
    public void findAnyTest(){
        Optional<Sku> sku = list.stream()
                .peek(sku1 -> System.out.println(sku1.getSkuName()))
                .findAny();
        System.out.println(JSON.toJSONString(sku, true));
    }

    /**
     * max使用
     */
    @Test
    public void maxTest(){
        OptionalDouble sku = list.stream()
                .mapToDouble(Sku::getTotalPrice)
                .max();
        System.out.println(sku.getAsDouble());
    }

    /**
     * min使用
     */
    @Test
    public void minTest(){
        OptionalDouble sku = list.stream()
                .mapToDouble(Sku::getTotalPrice)
                .min();
        System.out.println(sku.getAsDouble());
    }

    /**
     * count使用
     */
    @Test
    public void countTest(){
        long count = list.stream()
                .count();
        System.out.println(count);
    }
}
