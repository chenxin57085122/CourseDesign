package com.xinyuan.main.dao;

import com.xinyuan.main.domain.PlateContent;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface PlateContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(PlateContent record);

    PlateContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlateContent record);

    List<PlateContent> selectAllByPlateId(int id);
}