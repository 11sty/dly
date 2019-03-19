package com.dly.service;

import com.dly.dto.BaseDto;
import com.dly.pojo.Member;

import javax.swing.*;

public interface MemberService {
    /**
     * 登录的方法
     * @param member
     * @return
     */
    BaseDto<Member> login(Member member);

    /**
     * 用户注册
     * @param member
     * @return
     */
    BaseDto<Member> regist(Member member,String surePwd,String veriCode,String sureCode);
}
