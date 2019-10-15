package com.example.unifiedreturn.service.impl;

import com.example.unifiedreturn.exception.BusinessException;
import com.example.unifiedreturn.service.UserService;
import com.example.unifiedreturn.vo.UserVo;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现
 *
 * @author fraser
 * @date 2019-08-09 11:23
 */
@Service
public class UserServiceImpl implements UserService {

	/**
	 * 根据用户ID查询用户
	 *
	 * @param id
	 * @return
	 */
	@Override
	public UserVo getUserById(Long id) {
		throw new BusinessException("1001", "根据ID查询用户异常");
	}
}
