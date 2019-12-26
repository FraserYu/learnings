package top.dayarch.startup.activity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import top.dayarch.startup.service.StartupService;

import javax.annotation.PostConstruct;


/**
 * @author fraser
 * @date 2019/12/19 9:22 PM
 */
@Component
@Slf4j
@DependsOn("myApplicationListener")
public class MyPostConstructBean {

	@Autowired
	private StartupService startupService;

	@PostConstruct
	public void testPostConstruct(){
		log.info("MyPostConstructBean");
//		startupService.printLog();
	}
}
