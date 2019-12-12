package com.example.unifiedreturn.api;

import com.example.unifiedreturn.annotation.LoginUser;
import com.example.unifiedreturn.vo.LoginUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * 绑定机制controller
 *
 * @author fraser
 * @date 2019/12/11 2:15 PM
 */
@RestController
@RequestMapping("/bindings/")
@Slf4j
public class BindingController {


	@GetMapping("/{date}")
	public void getSpecificDateInfo(@PathVariable("date") LocalDateTime date) {
		log.info(date.toString());
	}

	@GetMapping("/id")
	public void getLoginUserInfo(@LoginUser LoginUserVo loginUserVo) {
		log.info(loginUserVo.toString());
	}
}
