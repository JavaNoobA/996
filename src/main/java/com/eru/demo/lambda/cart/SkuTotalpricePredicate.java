package com.eru.demo.lambda.cart;

/**
 * 总价判断标准
 * Created by eru on 2019/12/14.
 */
public class SkuTotalpricePredicate implements SkuPredicate {
    @Override
    public boolean test(Sku sku) {
        return sku.getTotalPrice() > 2000;
    }
}
