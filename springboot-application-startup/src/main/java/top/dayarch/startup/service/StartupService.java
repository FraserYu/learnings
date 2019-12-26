package top.dayarch.startup.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author fraser
 * @date 2019/12/19 9:19 PM
 */
@Service
@Slf4j
public class StartupService {

	public void printLog(){
		log.info("StartupService");
	}
}
