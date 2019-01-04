package com.xinyuan.main.service;

import com.xinyuan.main.dao.RegionMapper;
import com.xinyuan.main.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/3 20:28
 * @Description:
 */
@Service("regionService")
public class RegionServiceImpl implements RegionService{

    @Autowired
    private RegionMapper regionMapper = null;

    /**
     * 读取所有的省、市
     * @return
     */
    @Override
    public List<Region> readAll() {
        return regionMapper.readAll();
    }

    @Override
    public List<Region> readCityById(short id) {

        return regionMapper.readCityById(id);
    }

    @Override
    public List<Region> readCountyById(short id) {
        return regionMapper.readCountyById(id);
    }
}
