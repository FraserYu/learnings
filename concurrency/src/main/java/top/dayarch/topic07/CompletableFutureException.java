package top.dayarch.topic07;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * callback exception
 *
 * @author fraser
 * @date 2020/7/19 6:59 PM
 */
@Slf4j
public class CompletableFutureException {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Integer age = -1;

		CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
			if( age < 0 ) {
				throw new IllegalArgumentException("何方神圣？");
			}
			if(age > 18) {
				return "大家都是成年人";
			} else {
				return "未成年禁止入内";
			}
		}).thenApply((str) -> {
			log.info("游戏开始");
			return str;
		}).handle((res, ex) -> {
			if(ex != null) {
				log.info("必有蹊跷，来者" + ex.getMessage());
				return "Unknown!";
			}
			return res;
		});

		log.info(maturityFuture.get());
	}
}
