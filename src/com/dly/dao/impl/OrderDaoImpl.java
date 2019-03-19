package com.dly.dao.impl;

import com.dly.dao.OrderDao;
import com.dly.pojo.Cart;
import com.dly.pojo.Goods;
import com.dly.pojo.Member;
import com.dly.pojo.Order;
import com.dly.utils.DruidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {

    private QueryRunner runner = new QueryRunner(DruidUtil.getDataSource());

    @Override
    public Boolean updateOrderCode(Order order) {
        String sql = "insert into `order` (order_code,order_email,order_user_name,order_pay_status,order_total_price,order_add_time,order_member_id) values (?,?,?,?,?,?,?);";

        int effectRows = 0;
        try {
            effectRows = runner.execute(sql, order.getOrder_code(),order.getOrder_email(),order.getOrder_user_name(),order.getOrder_pay_status(),order.getOrder_total_price(),order.getOrder_add_time(),order.getOrder_member_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return effectRows > 0 ? true : false;
    }

    @Override
    public String findOrderCode(Integer member_id) {
        String sql = "SELECT order_code FROM `order` where order_member_id=? limit 1";

        String order_code = null;
        try {
            order_code = runner.query(sql, new ScalarHandler<>(),member_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order_code;
    }

    @Override
    public List<Order> findAllOrderByMemberId(Integer memberId) {
        String sql="SELECT * FROM cart c RIGHT JOIN goods g ON c.cart_goods_id=g.goods_id " +
                "LEFT JOIN `order` o ON c.cart_order_code=o.order_code WHERE o.order_member_id=? and o.order_pay_status=1";
        List<Order> orders=new ArrayList<>();
        try {
            List<Map<String, Object>> query = runner.query(sql, new MapListHandler(), memberId);
            for (Map<String, Object> map : query) {
                Order order=new Order();
                Goods goods=new Goods();
                Cart cart=new Cart();

                BeanUtils.populate(goods,map);
                BeanUtils.populate(cart,map);
                BeanUtils.populate(order,map);

                cart.setGoods(goods);
                order.setCart(cart);

                // 将填充好的数据 加入list
                orders.add(order);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
