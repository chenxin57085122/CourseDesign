package com.xinyuan.main.dao;

import com.xinyuan.main.domain.Region;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RegionMapper {

    Region selectByPrimaryKey(Short id);


    /**
     * 省
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
     * 县
     * @param id
     * @return
     */
    List<Region> readCountyById(short id);
}