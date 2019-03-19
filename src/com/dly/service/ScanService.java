package com.dly.service;

import com.dly.dto.BaseDto;
import com.dly.pojo.Scan;

import java.util.List;

public interface ScanService {
    /**
     * 添加浏览记录数据
     * @param scan
     * @return
     */
    BaseDto<Scan> saveScan(Scan scan);


}
