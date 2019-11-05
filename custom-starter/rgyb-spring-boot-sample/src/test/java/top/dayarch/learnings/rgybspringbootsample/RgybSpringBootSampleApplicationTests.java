package top.dayarch.learnings.rgybspringbootsample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.dayarch.service.GreetingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RgybSpringBootSampleApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired(required = false)
	private GreetingService greetingService;

	@Test
	public void testGreeting() {
		greetingService.sayHello();
	}



}
