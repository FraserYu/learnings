package com.example.unifiedreturn.service;

import com.example.unifiedreturn.vo.UserVo;

/**
 * 用户服务
 *
 * @author fraser
 * @date 2019-08-09 11:22
 */
public interface UserService {

	/**
	 * 根据用户ID查询用户
	 *
	 * @param id
	 * @return
	 */
	public UserVo getUserById(Long id);
}
