package com.xinyuan.main;

import com.xinyuan.main.dao.RegionMapper;
import com.xinyuan.main.domain.Region;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplication.class})
public class MainApplicationTests {

	@Autowired
	RegionMapper regionMapper = null;

	@Test
	public void contextLoads() {
		short id = 1;
		Region region = regionMapper.selectByPrimaryKey(id);
		System.out.println(region.getText());
	}

}

