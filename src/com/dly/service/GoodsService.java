package com.dly.service;

import com.dly.pojo.Goods;
import com.dly.pojo.Scan;
import com.dly.utils.PageUtil;

import java.util.List;

public interface GoodsService {
    List<Goods> getReGoods();

    List<Goods> getNewGoods();

    /**
     * 查询分类列表
     * @param category_id
     * @return
     */
    List<Goods> getCategoryList(Integer category_id);

    /**
     * 查询分页分类列表
     * @param pageUtil：分页类对象
     * @param category_id：分类id
     */
    void getCategoryList(PageUtil<Goods> pageUtil,Integer category_id);

    /**
     * 书籍详情
     * @param id
     * @return
     */
    Goods detail(Integer id);

    /**
     * 查询浏览记录
     * @param memberId
     * @return
     */
    List<Goods> getScanList(Integer memberId);

    /**
     * 关键字查询结果分页
     * @param pageUtil ： 分页对象
     * @param keyWords ：关键字
     */
    void getSelectResultByKeyWord(PageUtil<Goods> pageUtil,String keyWords);

}
