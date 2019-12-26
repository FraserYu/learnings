package top.dayarch.startup.activity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import top.dayarch.startup.service.StartupService;

/**
 * @author fraser
 * @date 2019/12/19 9:17 PM
 */
@Slf4j
@Component
@Order(0)
public class MyApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private StartupService startupService;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
		log.info("MyApplicationListener is started up");
//		startupService.printLog();
	}
}
