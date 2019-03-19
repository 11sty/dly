package com.dly.dao.impl;

import com.dly.dao.MemberDao;
import com.dly.pojo.Member;
import com.dly.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class MemberDaoImpl implements MemberDao {
    private QueryRunner runner=new QueryRunner(DruidUtil.getDataSource());

    @Override
    public Member findByNameAndPwd(String memberName, String pwd) {
        /**
         * 用户登录：
         * 用户名错误：提示没有该用户
         * 用户密码错误：密码错误
         * 用户没有验证：未验证
         *
         * 先通过用户名去查询，没有数据，有数据：对比密码
         */

        return null;
    }

    @Override
    public Member findByName(String memberName) {
        String sql="select * from member where member_nikname=? limit 1";

        Member query=null;
        try {
            query = runner.query(sql, new BeanHandler<>(Member.class), memberName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    @Override
    public Boolean updateMember(Member member) {
        String sql="update member set member_money=? where member_nikname=?";
        int effectRows=0;
        try {
            effectRows = runner.execute(sql,member.getMember_money(),member.getMember_nikname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return effectRows>0?true:false;
    }

    @Override
    public Boolean addMember(Member member) {
        String sql = "insert into member(member_nikname,member_pwd, member_email, member_name, member_phone, member_status,member_reg_time,member_money,member_vcode) values (?,?,?,?,?,?,?,?,?)";
        int effectRows = 0;
        try {
            effectRows = runner.execute(sql,member.getMember_nikname(),member.getMember_pwd(),member.getMember_email(),member.getMember_name(),member.getMember_phone(),member.getMember_status(),member.getMember_reg_time(),member.getMember_money(),member.getMember_vcode());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return effectRows > 0 ? true : false;
    }
}
