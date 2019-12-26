package top.dayarch.startup.activity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * MyApplicationRunner 测试类
 *
 * @author fraser
 * @date 2019/12/19 8:48 PM
 */
@Component
@Slf4j
@Order(1)
public class MyApplicationRunner implements ApplicationRunner {


	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("MyApplicationRunner order is 1");
		log.info("MyApplicationRunner Current parameter is {}:", args.getOptionValues("foo"));
	}
}
