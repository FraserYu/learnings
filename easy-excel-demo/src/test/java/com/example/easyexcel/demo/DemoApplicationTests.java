package com.example.easyexcel.demo;

import com.alibaba.excel.EasyExcel;
import com.example.easyexcel.demo.entity.User;
import com.example.easyexcel.demo.listener.UserExcelListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	/**
	 * 非web环境的简单读取excel内容
	 */
	@Test
	public void readExcel(){
		String fileName = TestUtils.getPath() + "excel" + File.separator + "users1.xlsx";
		EasyExcel.read(fileName, User.class, new UserExcelListener()).sheet().doRead();
	}

}
