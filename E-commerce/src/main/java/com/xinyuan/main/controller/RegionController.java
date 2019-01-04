package com.xinyuan.main.controller;

import com.xinyuan.main.service.RegionService;
import com.xinyuan.main.utils.ServiceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: chenxin
 * @Date: 2019/1/3 20:32
 * @Description:
 */
@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionService regionService = null;

    /**
     * 所有的省
     * @return
     */
    @GetMapping("/readAll")
    public ServiceVO readAll(){

        return new ServiceVO(regionService.readAll());
    }

    /**
     * 根据省获取市列表
     * @param id
     * @return
     */
    @GetMapping("/readCity/{id}")
    public ServiceVO readCityById(@PathVariable("id") short id){

        return new ServiceVO(regionService.readCityById(id));
    }

    /**
     * 根据市获取县、区列表
     * @param id
     * @return
     */
    @GetMapping("/readCounty/{id}")
    public ServiceVO readCountyById(@PathVariable("id") short id){

        return new ServiceVO(regionService.readCountyById(id));
    }
}
