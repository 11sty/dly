package com.dly.dao.impl;

import com.dly.dao.CartDao;
import com.dly.pojo.Cart;
import com.dly.pojo.Goods;
import com.dly.utils.DruidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartDaoImpl implements CartDao {

    private QueryRunner runner=new QueryRunner(DruidUtil.getDataSource());

    @Override
    public Boolean save(Cart cart) {
        String sql="insert into cart(cart_goods_id,cart_member_id,cart_goods_count,cart_add_time,cart_order_status,cart_order_code) values(?,?,?,?,?,?);";

        int effectRows=0;
        try {
            effectRows = runner.execute(sql, cart.getCart_goods_id(),cart.getCart_member_id(), cart.getCart_goods_count(), cart.getCart_add_time(), cart.getCart_order_status(), "");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return effectRows>0?true:false;
    }

    @Override
    public List<Cart> findAllByCartMemberId(Integer memberId) {
        String sql="select * from cart c left join goods g on c.cart_goods_id=g.goods_id where c.cart_member_id=? and c.cart_order_status=0";
        List<Cart> carts=new ArrayList<>();
        try {
            List<Map<String, Object>> query = runner.query(sql, new MapListHandler(), memberId);
            for (Map<String,Object> map:query){
                Goods goods=new Goods();
                Cart cart=new Cart();

                BeanUtils.populate(goods,map);
                BeanUtils.populate(cart,map);

                cart.setGoods(goods);

                //将填充好的数据加入list
                carts.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return carts;
    }

    @Override
    public Cart findByGoodsMemberOrder(Integer goodsId, Integer memberId, Integer orderStatus) {
        String sql="select * from cart where cart_goods_id=? and cart_member_id=? and cart_order_status=?";
        Cart query=null;
        try {
            query = runner.query(sql, new BeanHandler<>(Cart.class), goodsId, memberId, orderStatus);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    @Override
    public Boolean update(Cart cart) {
        String sql="update cart set cart_goods_count=cart_goods_count+1 where cart_id=?";

        int effectRows=0;
        try {
            effectRows = runner.execute(sql, cart.getCart_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return effectRows>0?true:false;
    }

    @Override
    public Boolean deleteCart(Cart cart) {
        String sql="delete from cart where cart_id=?";
        int effectRows=0;
        try {
            effectRows = runner.execute(sql,cart.getCart_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return effectRows>0?true:false;
    }

    @Override
    public Cart findCartId(Integer cartId) {
        String sql="select * from cart where cart_id=?";
        Cart query=null;
        try {
            query = runner.query(sql, new BeanHandler<>(Cart.class),cartId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public Boolean deleteAllCart(Cart cart) {
        String sql="update cart set cart_order_status=-1 where cart_member_id=?";
        int effectRows=0;
        try {
            effectRows = runner.execute(sql,cart.getCart_member_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return effectRows>0?true:false;
    }

    @Override
    public Boolean updateCartCount(Cart cart) {
        String sql="update cart set cart_goods_count=? where cart_id=?";

        int effectRows=0;
        try {
            effectRows = runner.execute(sql,cart.getCart_goods_count(), cart.getCart_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return effectRows>0?true:false;
    }

    @Override
    public Boolean updateCart(Cart cart) {
        String sql="update cart set cart_order_status=1,cart_order_code=? where cart_member_id=?";
        int effectRows=0;
        try {
            effectRows = runner.execute(sql,cart.getCart_order_code(), cart.getCart_member_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return effectRows>0?true:false;
    }

    @Override
    public Boolean insertCartCode(String code ,Integer member_id) {
        String sql="update cart set cart_order_code=? where cart_member_id=?";
        int effectRows=0;
        try {
            effectRows = runner.execute(sql,code,member_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return effectRows>0?true:false;
    }

}
