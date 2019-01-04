package com.xinyuan.main;

import com.xinyuan.main.dao.RegionMapper;
import com.xinyuan.main.domain.Region;
import com.xinyuan.main.domain.User;
import com.xinyuan.main.service.UserService;
import com.xinyuan.main.utils.FastDFSUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(MainApplicationTests.class);

	@Autowired
	private RegionMapper regionMapper = null;

	@Autowired
	private UserService userService = null;

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

	/**
	 * 测试登录接口
	 */
	@Test
	public void testLogin(){
		logger.info("username:123456,password:123456");
		System.out.println(userService.login("123456","123456"));
		System.out.println(userService.login("1004498612@qq.com","123456"));
		System.out.println(userService.login("18336038878","123456"));
	}

	@Test
	public void testRegister(){
		User user = new User();
		user.setAccount("123456");
		user.setPassword("1234567");
		user.setEmail("1004498612@qq.com");
		//System.out.println("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException");
		System.out.println(userService.reister(user));
	}

}

