package com.example.easyexcel.demo.service;

import com.example.easyexcel.demo.entity.User;

import java.util.List;

/**
 * 用户人员接口
 *
 * @author fraser
 * @date 2019/10/7 2:01 PM
 */
public interface IUser {

	public boolean saveData(List<User> users);
}
