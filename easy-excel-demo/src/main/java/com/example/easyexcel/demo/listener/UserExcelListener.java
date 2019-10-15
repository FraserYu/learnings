package com.example.easyexcel.demo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.example.easyexcel.demo.entity.User;
import com.example.easyexcel.demo.service.IUser;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户人员excel监听器
 *
 * @author fraser
 * @date 2019/10/6 10:22 AM
 */
@Slf4j
public class UserExcelListener extends AnalysisEventListener<User> {

	private IUser iUser;

	public UserExcelListener(){

	}

	public UserExcelListener(IUser iUser){
		this.iUser = iUser;
	}


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

}
