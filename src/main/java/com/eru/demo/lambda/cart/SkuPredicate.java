package com.eru.demo.lambda.cart;

/**
 * SKU策略接口
 * Created by eru on 2019/12/14.
 */
public interface SkuPredicate {

    /**
     * 选择判断标准
     * @param sku
     * @return
     */
    boolean test(Sku sku);
}
