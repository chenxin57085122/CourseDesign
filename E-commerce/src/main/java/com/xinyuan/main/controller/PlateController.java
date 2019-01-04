package com.xinyuan.main.controller;

import com.xinyuan.main.domain.Plate;
import com.xinyuan.main.domain.vo.PlateVO;
import com.xinyuan.main.service.PlateService;
import com.xinyuan.main.utils.ServiceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/4 20:57
 * @Description:
 */
@RestController
@RequestMapping("/plate")
public class PlateController {

    @Autowired
    private PlateService plateService = null;

    /**
     *
     * 功能描述:
     *
     * @param:
     * @return: 查询当前模块数据
     * @auther: chenxin
     * @date: 2019/1/4 21:00
     */
    @GetMapping("/selectByPlate")
    public ServiceVO<List<PlateVO>> selectByPlate(){
        return new ServiceVO<>(plateService.selectByPlate());
    }


    /**
     *
     * 功能描述: 新增模块数据
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/4 21:13
     */
    @PostMapping("/insert")
    public ServiceVO insertSelective(@RequestBody Plate plate){
        return new ServiceVO(plateService.insertSelective(plate));
    }
}
