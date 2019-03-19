package com.dly.dao;

import com.dly.pojo.Member;

public interface MemberDao {
    /**
     * 通过用户名和密码进行查询
     * @param memberName
     * @param pwd
     * @return
     */
    Member findByNameAndPwd(String memberName, String pwd);

    /**
     * 通过用户名进行查询
     * @param memberName
     * @return
     */
    Member findByName(String memberName);

    /**
     * 提交表单时跟更新member,money
     * @param member
     * @return
     */
    Boolean updateMember(Member member);

    /**
     * 用户注册
     * @param member：用户对象
     * @return
     */
    Boolean addMember(Member member);
}
