package com.dly.service.impl;

import com.dly.dao.CartDao;
import com.dly.dao.impl.CartDaoImpl;
import com.dly.dto.BaseDto;
import com.dly.pojo.Cart;
import com.dly.service.CartService;
import com.dly.utils.TimeUtil;

import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDao cd=new CartDaoImpl();

    @Override
    public BaseDto<Cart> addCard(Cart cart) {
        //验证member_id
        if(cart.getCart_member_id()<=0 || cart.getCart_member_id()==null){
            return new BaseDto<>(400,"会员数据出错！",null);
        }

        //进行数据填充
        cart.setCart_goods_count(1);
        cart.setCart_add_time((int) TimeUtil.getTimeStamp());
        cart.setCart_order_status(0);

        //先查询数据库是否相同的数据
        Cart dbCart=cd.findByGoodsMemberOrder(cart.getCart_goods_id(),cart.getCart_member_id(),0);
        Boolean save=false;
        if(dbCart!=null){
            //更新数据
            cart.setCart_id(dbCart.getCart_id());
            save= cd.update(cart);
        }else{
            //直接添加
            save=cd.save(cart);
        }

        if(save){
            return new BaseDto<>(200,"添加购物车成功！",null);
        }
        return new BaseDto<>(400,"添加购物车失败！",null);
    }

    @Override
    public List<Cart> cartList(Integer memberId) {
        if(memberId==null || memberId<=0){
            return null;
        }
        List<Cart> carts= cd.findAllByCartMemberId(memberId);
        return carts;
    }

    @Override
    public BaseDto<Cart> delCart(Cart cart) {
        //Cart dbCart=cd.findCartId(cart.getCart_id());
        cart.setCart_id(cart.getCart_id());
        Boolean delCart=false;
        delCart = cd.deleteCart(cart);

        if(delCart){
            return new BaseDto<>(200,"删除该购物车记录成功！",null);
        }
        return new BaseDto<>(400,"删除该购物车记录失败！",null);
    }

    @Override
    public BaseDto<Cart> delAllCart(Cart cart) {
        cart.setCart_member_id(cart.getCart_member_id());
        Boolean delCart=false;
        delCart = cd.deleteAllCart(cart);

        if(delCart){
            return new BaseDto<>(200,"清空购物车成功！",null);
        }
        return new BaseDto<>(400,"清空购物车失败！",null);
    }

    @Override
    public BaseDto<Cart> updateCartCount(Cart cart) {
        cart.setCart_id(cart.getCart_id());
        cart.setCart_goods_count(cart.getCart_goods_count());
        Boolean upCart=false;
        upCart = cd.updateCartCount(cart);

        if(upCart){
            return new BaseDto<>(200,"成功！",null);
        }
        return new BaseDto<>(400,"失败！",null);
    }
}
