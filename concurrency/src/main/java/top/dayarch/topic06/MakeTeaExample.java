package top.dayarch.topic06;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 烧水泡茶程序
 *
 * @author fraser
 * @date 2020/7/5 11:58 AM
 */
@Slf4j
public class MakeTeaExample {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		// 创建线程1的FutureTask
		FutureTask<String> ft1 = new FutureTask<String>(new T1Task());
		// 创建线程2的FutureTask
		FutureTask<String> ft2 = new FutureTask<String>(new T2Task());

		executorService.submit(ft1);
		executorService.submit(ft2);

		log.info(ft1.get() + ft2.get());
		log.info("开始泡茶");

		executorService.shutdown();
	}

	static class T1Task implements Callable<String> {
		@Override
		public String call() throws Exception {
			log.info("T1:洗水壶...");
			TimeUnit.SECONDS.sleep(1);

			log.info("T1:烧开水...");
			TimeUnit.SECONDS.sleep(15);

			return "T1:开水已备好";
		}
	}

	static class T2Task implements Callable<String> {
		@Override
		public String call() throws Exception {
			log.info("T2:洗茶壶...");
			TimeUnit.SECONDS.sleep(1);

			log.info("T2:洗茶杯...");
			TimeUnit.SECONDS.sleep(2);

			log.info("T2:拿茶叶...");
			TimeUnit.SECONDS.sleep(1);
			return "T2:福鼎白茶拿到了";
		}
	}
}
