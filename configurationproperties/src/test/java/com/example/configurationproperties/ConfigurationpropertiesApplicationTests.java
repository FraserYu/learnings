package com.example.configurationproperties;

import com.example.configurationproperties.properties.MailModuleProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ConfigurationpropertiesApplicationTests {

	@Autowired
	private MailModuleProperties mailModuleProperties;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testProperties() {
		log.info(mailModuleProperties.toString());
	}

}
