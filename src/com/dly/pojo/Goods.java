package com.dly.pojo;

public class Goods {
    private Integer goods_id;
    private String goods_name;
    private String goods_desc;
    private double goods_price;
    private String goods_author;
    private String goods_publish;
    private Integer goods_publish_time;
    private double goods_words;
    private Integer goods_category_id;
    private Integer goods_count;
    private String goods_img;
    private Integer goods_recommend;

    /**
     * 指定分类
     */
    private Category category;

    public Goods() {
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_desc() {
        return goods_desc;
    }

    public void setGoods_desc(String goods_desc) {
        this.goods_desc = goods_desc;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_author() {
        return goods_author;
    }

    public void setGoods_author(String goods_author) {
        this.goods_author = goods_author;
    }

    public String getGoods_publish() {
        return goods_publish;
    }

    public void setGoods_publish(String goods_publish) {
        this.goods_publish = goods_publish;
    }

    public Integer getGoods_publish_time() {
        return goods_publish_time;
    }

    public void setGoods_publish_time(Integer goods_publish_time) {
        this.goods_publish_time = goods_publish_time;
    }

    public double getGoods_words() {
        return goods_words;
    }

    public void setGoods_words(double goods_words) {
        this.goods_words = goods_words;
    }

    public Integer getGoods_category_id() {
        return goods_category_id;
    }

    public void setGoods_category_id(Integer goods_category_id) {
        this.goods_category_id = goods_category_id;
    }

    public Integer getGoods_count() {
        return goods_count;
    }

    public void setGoods_count(Integer goods_count) {
        this.goods_count = goods_count;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public Integer getGoods_recommend() {
        return goods_recommend;
    }

    public void setGoods_recommend(Integer goods_recommend) {
        this.goods_recommend = goods_recommend;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_desc='" + goods_desc + '\'' +
                ", goods_price=" + goods_price +
                ", goods_author='" + goods_author + '\'' +
                ", goods_publish='" + goods_publish + '\'' +
                ", goods_publish_time=" + goods_publish_time +
                ", goods_words=" + goods_words +
                ", goods_category_id=" + goods_category_id +
                ", goods_count=" + goods_count +
                ", goods_img='" + goods_img + '\'' +
                ", goods_recommend=" + goods_recommend +
                ", category=" + category +
                '}';
    }
}
