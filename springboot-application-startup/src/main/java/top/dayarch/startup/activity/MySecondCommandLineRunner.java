package top.dayarch.startup.activity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner 测试类
 *
 * @author fraser
 * @date 2019/12/19 7:05 PM
 */
@Slf4j
//@Component
@Order(-2)
public class MySecondCommandLineRunner implements CommandLineRunner {


	@Override
	public void run(String... args) throws Exception {
		log.info("MySecondCommandLineRunner order is -2");
		if (args.length > 0){
			for (int i = 0; i < args.length; i++) {
				log.info("MyCommandLineRunner current parameter is: {}", args[i]);
			}
		}
	}


}
