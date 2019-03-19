package com.dly.service.impl;

import com.dly.dao.GoodsDao;
import com.dly.dao.impl.GoodsDaoImpl;
import com.dly.pojo.Goods;
import com.dly.pojo.Scan;
import com.dly.service.GoodsService;
import com.dly.utils.PageUtil;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao gd=new GoodsDaoImpl();

    @Override
    public List<Goods> getReGoods() {
        List<Goods> reGoods = gd.findReGoods();

        return reGoods;
    }

    @Override
    public List<Goods> getNewGoods() {
        List<Goods> newGoods = gd.findNewGoods();

        return newGoods;
    }

    @Override
    public List<Goods> getCategoryList(Integer category_id){
        //做数据验证
        if(category_id<=0){
            return null;
        }

        List<Goods> goods = gd.listCategory(category_id);

        return goods;
    }

    @Override
    public void getCategoryList(PageUtil<Goods> pageUtil, Integer category_id) {
        //做数据验证
        if(category_id<=0){
            return;
        }

        //获取分页的数据
        List<Goods> goods = gd.listCategory(category_id, pageUtil.getNowPage(), pageUtil.getPageSize());

        //获取总的条数
        Integer totalCount=gd.getTotalCount(category_id);

        //设置相应的值
        pageUtil.setTotalNums(totalCount);
        pageUtil.setContent(goods);
    }

    @Override
    public Goods detail(Integer id) {
        if(id<=0 || id==null){
            return null;
        }
        Goods byId=gd.findById(id);

        return byId;
    }

    @Override
    public List<Goods> getScanList(Integer memberId) {
        //做数据验证
        if(memberId<=0){
            return null;
        }

        List<Goods> scan = gd.findScan(memberId);

        return scan;
    }

    @Override
    public void getSelectResultByKeyWord(PageUtil<Goods> pageUtil, String keyWords) {
        //获取分页数据
        List<Goods> Goodss = gd.selectByKeyWord(keyWords, pageUtil.getNowPage(), pageUtil.getPageSize());
        //获取总的条数
        Integer totalCount = gd.getTotalCount(keyWords);
        //设置相应的值
        pageUtil.setTotalNums(totalCount);
        pageUtil.setContent(Goodss);
    }

}
