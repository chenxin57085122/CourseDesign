package com.xinyuan.main;

import com.xinyuan.main.dao.PlateContentMapper;
import com.xinyuan.main.domain.PlateContent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/4 18:02
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplication.class})
public class PlateContentServiceTest {

    @Autowired
    private PlateContentMapper plateContentMapper = null;

    @Test
    public void selectPlateContentByPlateIdTest(){
        List<PlateContent> lists = plateContentMapper.selectAllByPlateId(7);
        for (PlateContent list : lists){
            System.out.println(list.getProductName());
        }
    }
}
