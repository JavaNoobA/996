package com.eru.demo.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class SkuServiceTest {

    @Test
    public void filterElectronics() {

        List<Sku> cartSkuList = CartService.getCartSkuList();

        List<Sku> electronics = CartService.filterElectronics(cartSkuList);

        electronics.forEach(e-> System.out.println(JSON.toJSONString(e, true)));
    }

    @Test
    public void filterByCategory(){
        List<Sku> cartSkuList = CartService.getCartSkuList();

        List<Sku> skuList = CartService.filterByCategory(cartSkuList, SkuCategoryEnum.BOOKS);

        skuList.forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    @Test
    public void filterByCategoryAndPriceTest(){
        List<Sku> cartSkuList = CartService.getCartSkuList();

        List<Sku> skuList = CartService.filterByCategoryAndPrice(cartSkuList, SkuCategoryEnum.BOOKS,
                Double.valueOf(85.1), false);

        skuList.forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    @Test
    public void filterByBookCategoryTest(){
        List<Sku> cartSkuList = CartService.getCartSkuList();

        List<Sku> skus = CartService.filterByPredicate(cartSkuList, new SkuBookCategoryPredicate());
        skus.forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    @Test
    public void filterByTotalPriceTest(){
        List<Sku> cartSkuList = CartService.getCartSkuList();

        List<Sku> skus = CartService.filterByPredicate(cartSkuList, new SkuTotalpricePredicate());
        skus.forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    @Test
    public void filterByTotalPriceTest2(){
        List<Sku> cartSkuList = CartService.getCartSkuList();

        List<Sku> skus = CartService.filterByPredicate(cartSkuList, (Sku sku) -> sku.getTotalPrice() > 1000);
        skus.forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }
}
