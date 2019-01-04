package com.xinyuan.main.dao;

import com.xinyuan.main.domain.Plate;
import com.xinyuan.main.domain.vo.PlateVO;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface PlateMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * 功能描述:
     *
     * @param:  新的模块数据
     * @return: 修改的条数
     * @auther: chenxin
     * @date: 2019/1/4 21:08
     */
    int insertSelective(Plate record);

    Plate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Plate record);

    /**
     *
     * 功能描述:
     *
     * @param:  null
     * @return: 首页显示的板块信息
     * @auther: chenxin
     * @date: 2019/1/4 19:34
     */
    List<PlateVO> selectByPlate();


}