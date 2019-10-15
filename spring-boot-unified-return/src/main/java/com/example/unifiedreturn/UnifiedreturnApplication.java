package com.example.unifiedreturn;

import com.example.unifiedreturn.exception.TestBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnifiedreturnApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnifiedreturnApplication.class, args);
		TestBean testBean = new TestBean();
	}

}
