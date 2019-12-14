package com.eru.demo.lambda.cart;

/**
 * 下单商品信息对象
 * Created by eru on 2019/12/14.
 */
public class Sku {

    /**
     * 商品编号
     */
    private Integer skuId;

    /**
     * 商品价格
     */
    private Double skuPrice;

    /**
     * 商品名称
     */
    private String skuName;

    /**
     * 购买总数
     */
    private Integer totalNum;

    /**
     * 总价
     */
    private Double totalPrice;

    /**
     * 商品类型
     */
    private Enum skuCategory;

    public Sku(Integer skuId, String skuName, Double skuPrice, Integer totalNum, Double totalPrice, Enum skuCategory) {
        this.skuId = skuId;
        this.skuName = skuName;
        this.skuPrice = skuPrice;
        this.totalNum = totalNum;
        this.totalPrice = totalPrice;
        this.skuCategory = skuCategory;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Double getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(Double skuPrice) {
        this.skuPrice = skuPrice;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Enum getSkuCategory() {
        return skuCategory;
    }

    public void setSkuCategory(Enum skuCategory) {
        this.skuCategory = skuCategory;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "skuId=" + skuId +
                ", skuPrice=" + skuPrice +
                ", skuName='" + skuName + '\'' +
                ", totalNum=" + totalNum +
                ", totalPrice=" + totalPrice +
                ", skuCategory=" + skuCategory +
                '}';
    }
}
