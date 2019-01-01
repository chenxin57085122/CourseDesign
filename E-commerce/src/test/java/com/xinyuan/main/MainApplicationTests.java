package com.xinyuan.main;

import com.xinyuan.main.dao.RegionMapper;
import com.xinyuan.main.domain.Region;
import com.xinyuan.main.utils.FastDFSUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

	@Test
	public void testUplood(){
		File file = new File("E:123.jpg");
		String fileName = file.getName();
		String ext = fileName.substring(fileName.lastIndexOf("."));
		FileInputStream fileInputStream = null;
		MultipartFile multipartFile = null;
		try {
			fileInputStream = new FileInputStream(file);
			 multipartFile = new  MockMultipartFile(file.getName(),file.getName(),ext,fileInputStream);
			System.out.println(FastDFSUtil.uploadFile(multipartFile));;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}


}

