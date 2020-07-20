package top.dayarch.topic07;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * get() 阻塞事demo
 *
 * @author fraser
 * @date 2020/7/19 6:59 PM
 */
@Slf4j
public class CompletableFuture1 {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
//		CompletableFuture<String> completableFuture = new CompletableFuture<String>();
//		completableFuture.complete("Future's Result Here Manually");
//		completableFuture.getNow(null);
//		String result = completableFuture.get();


//		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//			try {
//				TimeUnit.SECONDS.sleep(3);
//			} catch (InterruptedException e) {
//				throw new IllegalStateException(e);
//			}
//			log.info("运行在一个单独的线程当中");
//		});
//
//		future.get();



		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			log.info("运行在一个单独的线程当中");
			return "我有返回值";
		});

		log.info(future.get());
	}
}
