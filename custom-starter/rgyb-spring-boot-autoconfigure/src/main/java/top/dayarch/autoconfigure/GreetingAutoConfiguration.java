package top.dayarch.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.dayarch.service.DummyEmail;
import top.dayarch.service.GreetingService;

/**
 * 问候自动配置类
 *
 * @author fraser
 * @date 2019/10/15 4:55 PM
 */
@Configuration
@ConditionalOnProperty(value = "rgyb.greeting.enable", havingValue = "true")
@ConditionalOnClass(DummyEmail.class)
@EnableConfigurationProperties(GreetingProperties.class)
public class GreetingAutoConfiguration {

	@Bean
	public GreetingService greetingService(GreetingProperties greetingProperties){
		return new GreetingService(greetingProperties.getMembers());
	}
}
