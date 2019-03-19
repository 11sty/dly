package com.dly.service.impl;

import com.dly.dao.MemberDao;
import com.dly.dao.impl.MemberDaoImpl;
import com.dly.dto.BaseDto;
import com.dly.pojo.Member;
import com.dly.service.MemberService;
import com.dly.utils.DataValidationUtil;
import com.dly.utils.MD5Util;
import com.dly.utils.TimeUtil;

public class MemberServiceImpl implements MemberService {
    private MemberDao md=new MemberDaoImpl();

    @Override
    public BaseDto<Member> login(Member member) {

        /**
         * 用户登录：
         * 用户名错误：提示没有该用户
         * 用户密码错误：密码错误
         * 用户没有验证：未验证
         *
         * 先通过用户名去查询，没有数据，有数据：对比密码
         */

        //1、数据验证
        if(member.getMember_nikname()==null || member.getMember_nikname().isEmpty()){
            return new BaseDto<>(400,"用户名不能为空！",null);
        }
        if(member.getMember_pwd()==null || member.getMember_pwd().isEmpty()){
            return new BaseDto<>(400,"密码不能为空！",null);
        }

        //2、查询数据库
        Member dbMember = md.findByName(member.getMember_nikname());
        if (dbMember==null){
            return new BaseDto<>(400,"用户不存在！",dbMember);
        }

        //3、进行密码验证
        if(!MD5Util.MD5(member.getMember_pwd()).equals(dbMember.getMember_pwd())){
            return new BaseDto<>(400,"密码错误！",dbMember);
        }

        //4、验证状态
        if(dbMember.getMember_status()!=1){
            return new BaseDto<>(400,"用户未验证！",dbMember);
        }

        //5、登录成功
        return new BaseDto<>(200,"登录成功！",dbMember);
    }

    @Override
    public BaseDto<Member> regist(Member member,String surePwd,String veriCode,String sureCode) {
        //验证验证码
        System.out.print(veriCode+","+sureCode);
        if(!veriCode.equalsIgnoreCase(sureCode)){
            return new BaseDto<>(400,"验证码错误!",null);
        }
        //确认密码
        if(!MD5Util.MD5(surePwd).equals(member.getMember_pwd())){
            return new BaseDto<>(400,"请确认密码!",null);
        }
        if(!DataValidationUtil.isEmail(member.getMember_email())){
            return new BaseDto<>(400,"请输入正确的邮箱!",null);
        }
        if(!DataValidationUtil.isPhone(member.getMember_phone().toString())){
            return new BaseDto<>(400,"请输入正确的手机号码!",null);
        }
        //填充数据
        member.setMember_status(0);
        member.setMember_reg_time((int) TimeUtil.getTimeStamp());
        member.setMember_money(0);
        member.setMember_vcode("");
        //查询数据库是否有相同记录(是否已注册)
        Member dbMember = md.findByName(member.getMember_nikname());
        Boolean save = false;
        if(dbMember !=null){
            //数据库不为空，已注册
            return new BaseDto<>(400,"此用户已注册!",dbMember);
        }else{
            //数据库为空，直接添加
            save = md.addMember(member);
        }
        if(save){
            return new BaseDto<>(200,"注册成功!",dbMember);
        }
        return new BaseDto<>(400,"注册失败!",null);
    }
}
