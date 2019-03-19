package com.dly.dao.impl;

import com.dly.dao.GoodsDao;
import com.dly.pojo.Category;
import com.dly.pojo.Goods;
import com.dly.pojo.Scan;
import com.dly.utils.DruidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class GoodsDaoImpl implements GoodsDao {

    private QueryRunner runner=new QueryRunner(DruidUtil.getDataSource());

    @Override
    public List<Goods> findReGoods() {
        String sql="select * from goods where goods_recommend=1 order by goods_id desc limit 12";

        List<Goods> query1=null;
        try {
            query1 = runner.query(sql, new BeanListHandler<>(Goods.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query1;
    }

    @Override
    public List<Goods> findNewGoods(){
        String sql="select * from goods order by goods_publish_time desc limit 12";

        List<Goods> query2=null;
        try {
            query2 = runner.query(sql, new BeanListHandler<>(Goods.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query2;
    }

    @Override
    public List<Goods> listCategory(Integer category_id){
        //准备sql语句
        String sql="select * from goods where goods_category_id=?";

        List<Goods> query3=null;
        try {
            query3 = runner.query(sql, new BeanListHandler<>(Goods.class), category_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query3;
    }

    @Override
    public List<Goods> listCategory(Integer category_id, Integer page, Integer pageSize) {
        //准备sql语句
        String sql="select * from goods where goods_category_id=? limit ?,?";

        List<Goods> query3=null;
        try {
            query3 = runner.query(sql, new BeanListHandler<>(Goods.class), category_id,(page-1)*pageSize,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query3;
    }

    @Override
    public Goods findById(Integer id) {
        String sql="select g.*,c.category_name from goods g left join category c on g.goods_category_id=c.category_id where g.goods_id=?";

        Goods query=null;
        try {
            //query = runner.query(sql, new BeanHandler<>(Goods.class), id);
            Map<String, Object> dataMap = runner.query(sql, new MapHandler(), id);

            /**
             * 将map转换成goods
             * 将map转换成cagegory
             */
            Goods goods = new Goods();
            Category category=new Category();

            BeanUtils.populate(goods,dataMap);
            BeanUtils.populate(category,dataMap);
            query=goods;

            //将category设置到goods里面
            goods.setCategory(category);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return query;
    }

    @Override
    public Integer getTotalCount(Integer category_id) {
        String sql="select count(1) from goods where goods_category_id=?";

        Long query=null;
        try {
            query = runner.query(sql, new ScalarHandler<>(), category_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(query.toString());
    }

    @Override
    public List<Goods> findScan(Integer memberId) {
        //准备sql语句
        String sql="select * from scan s join goods g on s.scan_goods_id=g.goods_id where scan_member_id=? order by scan_time desc limit 6";

        List<Goods> query3=null;
        try {
            query3 = runner.query(sql, new BeanListHandler<>(Goods.class), memberId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query3;
    }

    @Override
    public List<Goods> selectByKeyWord(String keyWords, Integer page, Integer pageSize) {
        String sql="select * from goods g where g.goods_name like ? or g.goods_author like ? or g.goods_publish like ? limit ?,?";
        List<Goods> GoodsList=null;
        try {
            GoodsList = runner.query(sql, new BeanListHandler<>(Goods.class), "%" + keyWords + "%", "%" + keyWords + "%", "%" + keyWords + "%", (page - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GoodsList;
    }

    @Override
    public Integer getTotalCount(String keyWords) {
        String sql="select count(1) from goods g where g.goods_name like ? or g.goods_author like ? or g.goods_publish like ?";
        Long total=null;
        try {
            total = runner.query(sql, new ScalarHandler<>(), "%" + keyWords + "%", "%" + keyWords + "%", "%" + keyWords + "%");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(total.toString());
    }
}
