package com.eru.demo.lambda.cart;

/**
 * 图书分类判断标准
 * Created by eru on 2019/12/14.
 */
public class SkuBookCategoryPredicate implements SkuPredicate {
    @Override
    public boolean test(Sku sku) {
        return SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory());
    }
}
