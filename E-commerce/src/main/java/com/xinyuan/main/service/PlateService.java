package com.xinyuan.main.service;

import com.xinyuan.main.domain.Plate;
import com.xinyuan.main.domain.vo.PlateVO;

import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/4 20:54
 * @Description:
 */
public interface PlateService {

    /**
     *
     * 功能描述:
     *
     * @param:
     * @return: 返回首页模块数据
     * @auther: chenxin
     * @date: 2019/1/4 20:55
     */
    List<PlateVO> selectByPlate();

    /**
     *
     * 功能描述: 新增模块数据
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/4 21:10
     */
    int insertSelective(Plate plate);
}
