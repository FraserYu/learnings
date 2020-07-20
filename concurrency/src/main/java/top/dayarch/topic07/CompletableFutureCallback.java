package top.dayarch.topic07;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * callback
 *
 * @author fraser
 * @date 2020/7/19 6:59 PM
 */
@Slf4j
public class CompletableFutureCallback {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
//		CompletableFuture<String> comboText = CompletableFuture.supplyAsync(() -> {
//			try {
//				TimeUnit.SECONDS.sleep(3);
//			} catch (InterruptedException e) {
//				throw new IllegalStateException(e);
//			}
////			log.info("👍");
//			return "赞";
//		})
//				.thenApply(first -> {
//					log.info("在看");
//					return first + ", 在看";
//				})
//				.thenApply(second -> second + ", 转发");
//
//		log.info("三连有没有？");
//		log.info(comboText.get());


//		final CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(
//				// 模拟远端API调用，这里只返回了一个构造的对象
//				() -> Product.builder().id(12345L).name("颈椎/腰椎治疗仪").build())
//				.thenAccept(product -> {
//					log.info("获取到远程API产品名称 " + product.getName());
//				});
//		voidCompletableFuture.get();

		CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
			log.info("前序操作");
			return "前需操作结果";
		}).thenApplyAsync(result -> {
			log.info("后续操作");
			return "后续操作结果";
		});

		stringCompletableFuture.get();

	}

}
