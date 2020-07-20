package top.dayarch.topic07;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * callback compose
 *
 * @author fraser
 * @date 2020/7/19 6:59 PM
 */
@Slf4j
public class CompletableFutureCompose {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFutureCompose completableFutureCompose = new CompletableFutureCompose();
//		CompletableFuture<CompletableFuture<Double>> result = completableFutureCompose.getUsersDetail(12345L)
//				.thenApply(user -> completableFutureCompose.getCreditRating(user));

		CompletableFuture<Double> result = completableFutureCompose.getUsersDetail(12345L)
				.thenCompose(user -> completableFutureCompose.getCreditRating(user));
	}

	//获取用户信息详情
	CompletableFuture<User> getUsersDetail(Long userId) {
		return CompletableFuture.supplyAsync(() -> User.builder().id(12345L).name("日拱一兵").build());
	}

	//获取用户信用评级
	CompletableFuture<Double> getCreditRating(User user) {
		return CompletableFuture.supplyAsync(() -> CreditRating.builder().rating(7.5).build().getRating());
	}

}
