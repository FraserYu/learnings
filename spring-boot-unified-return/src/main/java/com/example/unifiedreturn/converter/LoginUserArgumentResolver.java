package com.example.unifiedreturn.converter;

import com.example.unifiedreturn.annotation.LoginUser;
import com.example.unifiedreturn.vo.LoginUserVo;
import com.example.unifiedreturn.vo.UserVo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆用户信息 resolver
 *
 * @author fraser
 * @date 2019/12/12 2:12 PM
 */
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.hasParameterAnnotation(LoginUser.class);
	}

	@Override
	public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

		HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();

		LoginUserVo loginUserVo = new LoginUserVo();

		String token = request.getHeader("token");
		if (Strings.isNotBlank(token)){
			//通常这里需要编写 token 解析逻辑，并将其放到 LoginUserVo 对象中
			//logic
		}

		//在此为了快速简洁的做演示说明，省略掉解析 token 部分，直接从 header 指定 key 中获取数据
		loginUserVo.setId(Long.valueOf(request.getHeader("userId")));
		loginUserVo.setName(request.getHeader("userName"));
		return loginUserVo;
	}
}
