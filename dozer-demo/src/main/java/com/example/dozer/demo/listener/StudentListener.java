package com.example.dozer.demo.listener;


import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerConverter;
import org.dozer.DozerEventListener;
import org.dozer.event.DozerEvent;

/**
 * 学生监听器
 *
 * @author fraser
 * @date 2019-05-30 13:44
 */
@Slf4j
public class StudentListener implements DozerEventListener {

	@Override
	public void mappingStarted(DozerEvent dozerEvent) {
		log.info("mappingStarted");
	}

	@Override
	public void preWritingDestinationValue(DozerEvent dozerEvent) {
		log.info("preWritingDestinationValue");

	}

	@Override
	public void postWritingDestinationValue(DozerEvent dozerEvent) {
		log.info("postWritingDestinationValue");
	}

	@Override
	public void mappingFinished(DozerEvent dozerEvent) {
		log.info("mappingFinished");
	}
}



