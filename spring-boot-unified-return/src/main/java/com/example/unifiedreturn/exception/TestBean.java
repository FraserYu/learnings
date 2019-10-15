package com.example.unifiedreturn.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author fraser
 * @date 2019-08-09 11:50
 */
@Slf4j
public class TestBean implements InitializingBean {
	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("TestBean");
	}
}
