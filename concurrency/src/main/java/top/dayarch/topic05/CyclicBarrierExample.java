package top.dayarch.topic05;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * CyclicBarrierExample
 *
 * @author fraser
 * @date 2020/6/27 3:13 PM
 */
@Slf4j
public class CyclicBarrierExample {

	private static Executor executor = Executors.newSingleThreadExecutor();

	// 创建 CyclicBarrier 实例，计数器的值设置为2
	private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
		executor.execute(() -> gather());
	});

	private static void gather() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("全部运行结束");
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		int breakCount = 0;

		executorService.submit(() -> {
			try {
				log.info(Thread.currentThread() + "第一回合");
				Thread.sleep(1000);
				cyclicBarrier.await();

				log.info(Thread.currentThread() + "第二回合");
				Thread.sleep(2000);
				cyclicBarrier.await();

				log.info(Thread.currentThread() + "第三回合");
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		});

		executorService.submit(() -> {
			try {
				log.info(Thread.currentThread() + "第一回合");
				Thread.sleep(2000);
				cyclicBarrier.await();

				log.info(Thread.currentThread() + "第二回合");
				Thread.sleep(1000);
				cyclicBarrier.await();

				log.info(Thread.currentThread() + "第三回合");
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		});

		executorService.shutdown();
	}

}
