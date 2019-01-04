package com.xinyuan.main;

import com.alibaba.druid.util.ListDG;
import com.xinyuan.main.domain.Region;
import com.xinyuan.main.service.RegionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/3 20:59
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplication.class})
public class RegionTest {

    @Autowired
    private RegionService regionService = null;

    /**
     * test:获取省
     */
    @Test
    public void provinceTest(){
        List<Region> list = regionService.readAll();
        for (Region region : list){
            System.out.println(region.getText());
        }
    }

    /**
     * 测试通过省查询城市
     */
    @Test
    public void cityTest(){
        short id = 3;
        List<Region> list = regionService.readCityById(id);
        for (Region region : list){
            System.out.println(region.getText());
        }
    }

    @Test
    public void countyTest(){
        short id = 51;
        List<Region> list = regionService.readCountyById(id);
        for (Region region : list){
            System.out.println(region.getText());
        }
    }




}
