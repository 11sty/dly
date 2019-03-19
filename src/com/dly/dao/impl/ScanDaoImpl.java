package com.dly.dao.impl;

import com.dly.dao.ScanDao;
import com.dly.pojo.Scan;
import com.dly.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ScanDaoImpl implements ScanDao {
    private QueryRunner runner=new QueryRunner(DruidUtil.getDataSource());

    @Override
    public Boolean addScan(Scan scan) {
        String sql="insert into scan(scan_goods_id,scan_time,scan_member_id) values(?,?,?)";

        int effectRow=0;
        try {
            effectRow = runner.execute(sql, scan.getScan_goods_id(), scan.getScan_time(), scan.getScan_member_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return effectRow>0?true:false;
    }

    @Override
    public Scan findByGoodsMember(Integer goodsId, Integer memberId) {
        String sql="select * from scan where scan_goods_id=? and scan_member_id=?";
        Scan query=null;
        try {
            query = runner.query(sql, new BeanHandler<>(Scan.class), goodsId, memberId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    @Override
    public Boolean updateScan(Scan scan) {
        String sql="update scan set scan_time=? where scan_id=?";

        int effectRows=0;
        try {
            effectRows = runner.execute(sql,scan.getScan_time(),scan.getScan_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return effectRows>0?true:false;
    }


}
