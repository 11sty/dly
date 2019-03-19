package com.dly.pojo;

public class Order {
    private Integer order_id;
    private String order_code;
    private String order_email;

    private String order_user_name;
    private Integer order_pay_status;
    private Integer order_total_price;
    private Integer order_add_time;
    private Integer order_member_id;

    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Order() {
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public String getOrder_email() {
        return order_email;
    }

    public void setOrder_email(String order_email) {
        this.order_email = order_email;
    }

    public String getOrder_user_name() {
        return order_user_name;
    }

    public void setOrder_user_name(String order_user_name) {
        this.order_user_name = order_user_name;
    }

    public Integer getOrder_pay_status() {
        return order_pay_status;
    }

    public void setOrder_pay_status(Integer order_pay_status) {
        this.order_pay_status = order_pay_status;
    }

    public Integer getOrder_total_price() {
        return order_total_price;
    }

    public void setOrder_total_price(Integer order_total_price) {
        this.order_total_price = order_total_price;
    }

    public Integer getOrder_add_time() {
        return order_add_time;
    }

    public void setOrder_add_time(Integer order_add_time) {
        this.order_add_time = order_add_time;
    }

    public Integer getOrder_member_id() {
        return order_member_id;
    }

    public void setOrder_member_id(Integer order_member_id) {
        this.order_member_id = order_member_id;
    }


    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_code='" + order_code + '\'' +
                ", order_email='" + order_email + '\'' +
                ", order_user_name='" + order_user_name + '\'' +
                ", order_pay_status=" + order_pay_status +
                ", order_total_price=" + order_total_price +
                ", order_add_time=" + order_add_time +
                ", order_member_id=" + order_member_id +
                ", cart=" + cart +
                '}';
    }
}
