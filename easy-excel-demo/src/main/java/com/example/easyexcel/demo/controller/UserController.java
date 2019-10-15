package com.example.easyexcel.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.example.easyexcel.demo.entity.User;
import com.example.easyexcel.demo.listener.UserExcelListener;
import com.example.easyexcel.demo.service.IUser;
import com.example.easyexcel.demo.utils.ExcelDemoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 用户人员API
 *
 * @author fraser
 * @date 2019/10/6 9:40 AM
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private IUser iUser;

	@PostMapping("/upload")
	public String upload(MultipartFile file) throws IOException {
		EasyExcel.read(file.getInputStream(), User.class, new UserExcelListener()).sheet().doRead();
		return "success";
	}

	@PostMapping("/uploadWithAnonyInnerClass")
	public String uploadWithAnonyInnerClass(MultipartFile file) throws IOException {
		EasyExcel.read(file.getInputStream(), User.class, new AnalysisEventListener<User>(){
			/**
			 * 批处理阈值
			 */
			private static final int BATCH_COUNT = 2;
			List<User> list = new ArrayList<User>();

			@Override
			public void invoke(User user, AnalysisContext analysisContext) {
				log.info("解析到一条数据:{}", JSON.toJSONString(user));
				list.add(user);
				if (list.size() >= BATCH_COUNT) {
					saveData();
					list.clear();
				}
			}

			@Override
			public void doAfterAllAnalysed(AnalysisContext analysisContext) {
				saveData();
				log.info("所有数据解析完成！");
			}

			private void saveData(){
				iUser.saveData(list);
			}
		}).sheet().doRead();
		return "success";
	}

	@PostMapping("/uploadWithConstructor")
	public String uploadWithConstructor(MultipartFile file) throws IOException {
		EasyExcel.read(file.getInputStream(), User.class, new UserExcelListener(iUser)).sheet().doRead();
		return "success";
	}

	@PostMapping("/uploadWithLambda")
	public String uploadWithLambda(MultipartFile file) throws IOException {
		AnalysisEventListener<User> userAnalysisEventListener = ExcelDemoUtils.getListener(this.batchInsert(), 2);
		EasyExcel.read(file.getInputStream(), User.class, userAnalysisEventListener).sheet().doRead();
		return "success";
	}


	private Consumer<List<User>> batchInsert(){
		return users -> iUser.saveData(users);
	}

}
