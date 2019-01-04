package com.xinyuan.main.service;

import com.xinyuan.main.dao.PlateMapper;
import com.xinyuan.main.domain.Plate;
import com.xinyuan.main.domain.vo.PlateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/4 20:56
 * @Description:
 */
@Service("plateService")
public class PlateServiceImpl implements PlateService{

    @Autowired
    private PlateMapper plateMapper = null;
    /**
     *
     * 功能描述:
     *
     * @param:
     * @return: 查询当前模块数据
     * @auther: chenxin
     * @date: 2019/1/4 21:01
     */
    @Override
    public List<PlateVO> selectByPlate() {

        return plateMapper.selectByPlate();
    }

    /**
     *
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/4 21:10
     */
    @Override
    public int insertSelective(Plate plate) {
        return plateMapper.insertSelective(plate);
    }
}
