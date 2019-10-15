package com.example.easyexcel.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.easyexcel.demo.entity.User;
import com.example.easyexcel.demo.service.IUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户人员实现类
 *
 * @author fraser
 * @date 2019/10/7 2:02 PM
 */
@Service
@Slf4j
public class UserServiceImpl implements IUser {
	@Override
	public boolean saveData(List<User> users) {
		log.info("UserService {}条数据，开始存储数据库！", users.size());
		log.info(JSON.toJSONString(users));
		log.info("UserService 存储数据库成功！");
		return true;
	}
}
