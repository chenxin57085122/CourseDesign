package com.xinyuan.main;

import com.xinyuan.main.dao.PlateContentMapper;
import com.xinyuan.main.dao.PlateMapper;
import com.xinyuan.main.domain.Plate;
import com.xinyuan.main.domain.vo.PlateVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/4 19:57
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplication.class})
public class PlateServiceTest {

    @Autowired
    private PlateMapper plateMapper = null;

    @Autowired
    private PlateContentMapper plateContentMapper = null;

    @Test
    public void selectByPlateTest(){
        List<PlateVO> lists  = plateMapper.selectByPlate();
        System.out.println(lists.get(2).getCreated().getTime());
        for (PlateVO list : lists){
            System.out.println(list);

        }
        for (PlateVO list : lists){

        }
    }
}
