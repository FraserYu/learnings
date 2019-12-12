package com.example.unifiedreturn.config;

import com.alibaba.fastjson.JSON;
import com.example.unifiedreturn.converter.LoginUserArgumentResolver;
import com.example.unifiedreturn.converter.StringToLocalDateTimeConverter;
import com.example.unifiedreturn.exception.BusinessException;
import com.example.unifiedreturn.exception.TestBean;
import com.example.unifiedreturn.vo.CommonResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

/**
 * 统一返回配置
 *
 * @author fraser
 * @date 2019-08-08 17:07
 */
@EnableWebMvc
@Configuration
public class UnifiedReturnConfig implements WebMvcConfigurer {

	/**
	 * 配置 RESTful API 统一参数返回
	 */
	@RestControllerAdvice("com.example.unifiedreturn.api")
	static class CommonResultResponseAdvice implements ResponseBodyAdvice<Object> {
		@Override
		public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
			return true;
		}

		@Override
		public Object beforeBodyWrite(Object body, MethodParameter methodParameter,
									  MediaType mediaType,
									  Class<? extends HttpMessageConverter<?>> aClass,
									  ServerHttpRequest serverHttpRequest,
									  ServerHttpResponse serverHttpResponse) {
			//应对特殊case，返回类型是String不做处理会导致StringMessageConverter转换异常，将其封装并转换为json对象
			if (body instanceof String) {
				String stringBody = (String) body;
				CommonResult<Object> objectCommonResult = new CommonResult<>(1, stringBody);
				return JSON.toJSONString(objectCommonResult);
			}

			if (body instanceof CommonResult) {
				return body;
			}

			return new CommonResult<Object>(body);
		}
	}


	@RestControllerAdvice("com.example.unifiedreturn.api")
	static class UnifiedExceptionHandler {

		@ExceptionHandler(BusinessException.class)
		public CommonResult<Void> handleBusinessException(BusinessException be) {
			return CommonResult.errorResult(be.getErrorCode(), be.getErrorMsg());
		}
	}

	//	@Bean
	public TestBean testBean() {
		return new TestBean();
	}


	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToLocalDateTimeConverter());
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new LoginUserArgumentResolver());
	}
}
