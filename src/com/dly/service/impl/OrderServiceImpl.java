package com.dly.service.impl;

import com.dly.dao.MemberDao;
import com.dly.dao.OrderDao;
import com.dly.dao.impl.MemberDaoImpl;
import com.dly.dao.impl.OrderDaoImpl;
import com.dly.dto.BaseDto;
import com.dly.pojo.Cart;
import com.dly.pojo.Member;
import com.dly.pojo.Order;
import com.dly.service.OrderService;
import com.dly.utils.OrderNumberUtil;
import com.dly.utils.TimeUtil;

import java.util.List;

import static com.dly.utils.OrderNumberUtil.getOrderIdByUUId;

public class OrderServiceImpl implements OrderService {

    private OrderDao od = new OrderDaoImpl();


    @Override
    public BaseDto<Order> addOrderinfo(Order order) {

        //基础的判断放在服务端
        /*// 1. 数据验证
        if(order.getOrder_user_name() == null || order.getOrder_user_name().isEmpty()){
            return new BaseDto<>(400,"收货不能为空!",null);
        }
        if(order.getOrder_email() == null || order.getOrder_email().isEmpty()){
            return new BaseDto<>(400,"邮箱不能为空!",null);
        }*/


        Boolean save = false;
        save = od.updateOrderCode(order);

        //通过member获取money
        Member member  = new Member();
        MemberDao memberDao = new MemberDaoImpl();
        member = memberDao.findByName(order.getOrder_user_name());


        if(order.getOrder_total_price()<=member.getMember_money()){
            /***
             * 修改member的钱数
             */
            Member mem = new Member();
            MemberDao member1 = new MemberDaoImpl();
            //封装member
            mem.setMember_nikname(order.getOrder_user_name());
            mem.setMember_money(member.getMember_money()-order.getOrder_total_price());
            Boolean tag = member1.updateMember(mem);
            System.out.println("tag:"+tag);
            return new BaseDto<>(200,"购买成功",null);
        }


        return new BaseDto<>(400,"购买失败,余额不足",null);
        //return new BaseDto<>(400,"购买失败",null);

    }

    @Override
    public List<Order> orderList(Integer memberId) {
        if(memberId == null || memberId <= 0 ){
            return null;
        }
        List<Order> orders=od.findAllOrderByMemberId(memberId);
        return orders;
    }
}
