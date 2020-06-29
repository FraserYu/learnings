package top.dayarch.topic05;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch 使用案例
 *
 * @author fraser
 * @date 2020/6/26 6:08 PM
 */
@Slf4j
public class CountDownLatchTimeoutExample {

	private static CountDownLatch countDownLatch = new CountDownLatch(2);

	public static void main(String[] args) throws InterruptedException {
		// 这里不推荐这样创建线程池，最好通过 ThreadPoolExecutor 手动创建线程池
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.submit(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				log.info("Thread-1 执行完毕");
				//计数器减1
				countDownLatch.countDown();
			}
		});

		executorService.submit(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				log.info("Thread-2 执行完毕");
				//计数器减1
				countDownLatch.countDown();
			}
		});

		log.info("主线程等待子线程执行完毕");
		log.info("计数器值为：" + countDownLatch.getCount());
		countDownLatch.await(2, TimeUnit.SECONDS);
		log.info("计数器值为：" + countDownLatch.getCount());
		log.info("主线程执行完毕");
		executorService.shutdown();
	}
}
