package com.dly.service.impl;

import com.dly.dao.ScanDao;
import com.dly.dao.impl.ScanDaoImpl;
import com.dly.dto.BaseDto;
import com.dly.pojo.Scan;
import com.dly.service.ScanService;
import com.dly.utils.TimeUtil;

import java.util.List;

public class ScanServiceImpl implements ScanService {
    private ScanDao sd=new ScanDaoImpl();
    @Override
    public BaseDto<Scan> saveScan(Scan scan) {
        //进行数据填充
        scan.setScan_time((int) TimeUtil.getTimeStamp());

        //先查询数据库是否相同的数据
        Scan dbScan=sd.findByGoodsMember(scan.getScan_goods_id(),scan.getScan_member_id());
        Boolean save=false;
        if(dbScan!=null){
            //更新数据
            scan.setScan_time((int) TimeUtil.getTimeStamp());
            scan.setScan_id(dbScan.getScan_id());
            save= sd.updateScan(scan);
        }else{
            //直接添加
            save=sd.addScan(scan);
        }

        if(save){
            return new BaseDto<>(200,"添加成功！",null);
        }
        return new BaseDto<>(400,"添加失败！",null);
    }


}
