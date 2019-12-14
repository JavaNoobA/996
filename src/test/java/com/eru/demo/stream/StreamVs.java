package com.eru.demo.stream;

import com.alibaba.fastjson.JSON;
import com.eru.demo.lambda.cart.CartService;
import com.eru.demo.lambda.cart.Sku;
import com.eru.demo.lambda.cart.SkuCategoryEnum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * Created by eru on 2019/12/14.
 */
public class StreamVs {

    @Test
    public void findTotalpriceTop2(){
        List<Sku> skus = CartService.getCartSkuList();

        /**
         * 排序
         */
        skus.sort(new Comparator<Sku>() {
            @Override
            public int compare(Sku sku1, Sku sku2) {
                if (sku1.getTotalPrice() > sku2.getTotalPrice()){
                    return -1;
                }else if (sku1.getTotalPrice() < sku2.getTotalPrice()){
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        System.out.println(JSON.toJSONString(skus, true));

        /**
         * top2
         */
        List<Sku> top2List = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            top2List.add(skus.get(i));
        }
        System.out.println(JSON.toJSONString(top2List, true));
    }

    @Test
    public void StreamTop2Test(){
        List<Sku> skus = CartService.getCartSkuList();
        /**
         * 以Stream完成需求
         */
        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0));
        List<String> skuNameTop2List = skus.stream()
                // 打印原始商品信息
                .peek(sku -> System.out.println(JSON.toJSONString(sku, true)))
                // 过滤掉图书分类
                .filter(sku -> !sku.getSkuCategory().equals(SkuCategoryEnum.BOOKS))
                // 排序
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                // top2
                .limit(2)
                // 累加商品总金额
                .peek(sku -> money.set(money.get() + sku.getTotalPrice()))
                // 获取商品名称
                .map(sku -> sku.getSkuName())
                // 收集结果
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(skuNameTop2List, true));
        System.out.println("商品总价:" + money.get());
    }
}
