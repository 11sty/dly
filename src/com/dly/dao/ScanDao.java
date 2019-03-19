package com.dly.dao;

import com.dly.pojo.Scan;

import java.util.List;

public interface ScanDao {
    /**
     * 添加浏览记录
     * @param scan
     * @return
     */
    Boolean addScan(Scan scan);

    /**
     * 根据商品和会员查询浏览记录
     * @param goodsId
     * @param memberId
     * @return
     */
    Scan findByGoodsMember(Integer goodsId,Integer memberId);

    /**
     * 更新浏览记录
     * @param scan
     * @return
     */
    Boolean updateScan(Scan scan);

}
