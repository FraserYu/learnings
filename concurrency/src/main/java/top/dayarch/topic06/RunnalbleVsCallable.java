package top.dayarch.topic06;

import lombok.extern.slf4j.Slf4j;

/**
 * Runnable 与 Callable 的对比
 *
 * @author fraser
 * @date 2020/7/4 6:16 PM
 */
@Slf4j
public class RunnalbleVsCallable {

	class MyThread implements Runnable{
		@Override
		public void run() {
			log.info("my thread");
		}
	}
}
