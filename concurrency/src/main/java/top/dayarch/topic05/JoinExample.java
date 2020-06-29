package top.dayarch.topic05;

import lombok.extern.slf4j.Slf4j;

/**
 * Join 的使用
 *
 * @author fraser
 * @date 2020/6/26 5:39 PM
 */
@Slf4j
public class JoinExample {

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				log.info("Thread-1 执行完毕");
			}
		}, "Thread-1");

		Thread thread2 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				log.info("Thread-2 执行完毕");
			}
		}, "Thread-2");

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		log.info("主线程执行完毕");
	}
}
