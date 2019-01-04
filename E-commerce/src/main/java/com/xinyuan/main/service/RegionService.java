package com.xinyuan.main.service;

import com.xinyuan.main.domain.Region;

import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/3 20:27
 * @Description:
 */
public interface RegionService {

    /**
     * 读取所有的省
     * @return
     */
    List<Region> readAll();

    /**
     * 市
     * @param id
     * @return
     */
    List<Region> readCityById(short id);

    /**
     * 县、区
     * @param id
     * @return
     */
    List<Region> readCountyById(short id);

}
