package com.example.unifiedreturn.api;

import com.example.unifiedreturn.exception.BusinessException;
import com.example.unifiedreturn.service.UserService;
import com.example.unifiedreturn.vo.UserVo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用户
 *
 * @author fraser
 * @date 2019-08-08 17:12
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;


	@GetMapping("")
	public List<UserVo> getUserList() {
		List<UserVo> userVoList = Lists.newArrayListWithCapacity(2);
		userVoList.add(UserVo.builder().id(1L).name("日拱一兵").age(18).build());
		userVoList.add(UserVo.builder().id(2L).name("tan").age(19).build());
		return userVoList;
	}



	/*@GetMapping("/{id}")
	public UserVo getUserById(@PathVariable Long id){
		return UserVo.builder().id(1L).name("日拱一兵").age(18).build();
	}*/

	@GetMapping("/testResponseEntity")
	public ResponseEntity testResponseEntity() {
		return new ResponseEntity(UserVo.builder().id(1L).name("日拱一兵").age(18).build(), HttpStatus.OK);
	}

	/*@GetMapping("/{id}")
	public UserVo getUserById(@PathVariable Long id){
//		throw new BusinessException("1001", "根据ID查询用户异常");
//		return userService.getUserById(id);
		return UserVo.builder().id(1L).name("日拱一兵").age(18).build();

	}*/

	@GetMapping("/{id}")
	public String getUserById(@PathVariable Long id) {
		return "success";
//		return userService.getUserById(id);
	}

}
