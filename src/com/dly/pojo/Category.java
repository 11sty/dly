package com.dly.pojo;

public class Category {
    //分类的自增id
    private Integer category_id;

    //分类的名字
    private  String category_name;

    //分类的描述
    private  String category_desc;

    //是否显示再导航栏
    private Integer category_is_show;

    public Category() {
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_desc() {
        return category_desc;
    }

    public void setCategory_desc(String category_desc) {
        this.category_desc = category_desc;
    }

    public Integer getCategory_is_show() {
        return category_is_show;
    }

    public void setCategory_is_show(Integer category_is_show) {
        this.category_is_show = category_is_show;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                ", category_desc='" + category_desc + '\'' +
                ", category_is_show=" + category_is_show +
                '}';
    }
}
