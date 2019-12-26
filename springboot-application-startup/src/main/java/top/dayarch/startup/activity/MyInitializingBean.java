package top.dayarch.startup.activity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fraser
 * @date 2019/12/19 9:28 PM
 */
//@Component
@Slf4j
public class MyInitializingBean implements InitializingBean {


	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("MyInitializingBean.afterPropertiesSet()");
	}

}
