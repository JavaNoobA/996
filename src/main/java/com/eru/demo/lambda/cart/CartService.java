package com.eru.demo.lambda.cart;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 购物车服务类
 * Created by eru on 2019/12/14.
 */
public class CartService {

    // 加入到购物车中的商品信息
    private static List<Sku> cartSkuList =
        new ArrayList<Sku>(){
            {
                add(new Sku(654032, "无人机",
                        4999.00, 1,
                        4999.00, SkuCategoryEnum.ELECTRONICS));

                add(new Sku(642934, "VR一体机",
                        2299.00, 1,
                        2299.00, SkuCategoryEnum.ELECTRONICS));

                add(new Sku(645321, "纯色衬衫",
                        409.00, 3,
                        1227.00, SkuCategoryEnum.CLOTHING));

                add(new Sku(654327, "牛仔裤",
                        528.00, 1,
                        528.00, SkuCategoryEnum.CLOTHING));

                add(new Sku(675489, "跑步机",
                        2699.00, 1,
                        2699.00, SkuCategoryEnum.SPORTS));

                add(new Sku(644564, "Java编程思想",
                        79.80, 1,
                        79.80, SkuCategoryEnum.BOOKS));

                add(new Sku(678678, "Java核心技术",
                        149.00, 1,
                        149.00, SkuCategoryEnum.BOOKS));

                add(new Sku(697894, "算法",
                        78.20, 1,
                        78.20, SkuCategoryEnum.BOOKS));

                add(new Sku(696968, "TensorFlow进阶指南",
                        85.10, 1,
                        85.10, SkuCategoryEnum.BOOKS));
            }
        };

    /**
     * 获取商品信息列表
     * @return
     */
    public static List<Sku> getCartSkuList(){
        return cartSkuList;
    }

    /**
     * 过滤出电子产品
     * @param skuList 商品列表
     * @return
     */
    public static List<Sku> filterElectronics(List<Sku> skuList){
        return skuList.stream().filter(sku -> {
            return sku.getSkuCategory().equals(SkuCategoryEnum.ELECTRONICS);
        }).collect(Collectors.toList());
    }

    /**
     * 根据商品类型过滤
     * @param skuList 商品列表
     * @param category 商品类型
     * @return
     */
    public static List<Sku> filterByCategory(List<Sku> skuList, SkuCategoryEnum category){
        return skuList.stream().filter(sku -> {
            return sku.getSkuCategory().equals(category);
        }).collect(Collectors.toList());
    }

    /**
     * 根据商品类型、商品总价过滤过滤
     * @param skuList 商品列表
     * @param category 商品类型
     * @param price 给定价格
     * @param categoryOrPrice true->category过滤, false->totalPrice过滤
     * @return
     */
    public static List<Sku> filterByCategoryAndPrice(List<Sku> skuList, SkuCategoryEnum category, Double price,
                                                     Boolean categoryOrPrice){

        List<Sku> result = new ArrayList<>();
        for (Sku sku : skuList) {
            if (categoryOrPrice && sku.getSkuCategory().equals(category) ||
                    (!categoryOrPrice && sku.getTotalPrice() > 2000)
            ) {
                result.add(sku);
            }
        }
        return result;
    }

    /**
     * 根据不同的判断标准过滤
     * @param skuList 商品列表
     * @param predicate 判断标准
     * @return
     */
    public static List<Sku> filterByPredicate(List<Sku> skuList, SkuPredicate predicate){
        return skuList.stream().filter(sku -> {
            return predicate.test(sku);
        }).collect(Collectors.toList());

    }
}
