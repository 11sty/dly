package com.dly.dao;

import com.dly.pojo.Goods;
import com.dly.pojo.Scan;

import java.util.List;

public interface GoodsDao {
    //查询推荐的商品
    List<Goods> findReGoods();

    //查询新书
    List<Goods> findNewGoods();

    /**
     * 分类列表
     * @param category_id
     * @return
     */
    List<Goods> listCategory(Integer category_id);

    /**
     * 分页的分类列表
     * @param category_id：分类id
     * @param page：当前页
     * @param pageSize：页容量
     * @return
     */
    List<Goods> listCategory(Integer category_id,Integer page,Integer pageSize);

    /**
     * 通过主键id去查询数据
     * @param id：主键id
     * @return
     */
    Goods findById(Integer id);

    /**
     * 获取当前分类下所有的条数
     * @param category_id：分类id
     * @return
     */
    Integer getTotalCount(Integer category_id);

    /**
     * 根据会员ID查询其浏览记录
     * @param memberId
     * @return
     */
    List<Goods> findScan(Integer memberId);

    /**
     * 模糊查询分页
     * @param keyWords :关键字
     * @param page ： 当前页数
     * @param pageSize ：页容量
     * @return
     */
    List<Goods> selectByKeyWord(String keyWords,Integer page,Integer pageSize);

    /**
     * 模糊查询记录条数
     * @param keyWords : 关键字
     * @return
     */
    Integer getTotalCount(String keyWords);
}
