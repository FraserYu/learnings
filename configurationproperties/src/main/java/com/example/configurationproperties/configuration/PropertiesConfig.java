package com.example.configurationproperties.configuration;

import com.example.configurationproperties.converter.WeightConverter;
import com.example.configurationproperties.properties.MailModuleProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 属性配置
 *
 * @author fraser
 * @date 2019-07-23 19:39
 */
@Configuration
public class PropertiesConfig {

//	@Bean
//	public MailModuleProperties mailModuleProperties(){
//		return new MailModuleProperties();
//
//	}

	@Bean
	@ConfigurationPropertiesBinding
	public WeightConverter weightConverter() {
		return new WeightConverter();
	}
}
