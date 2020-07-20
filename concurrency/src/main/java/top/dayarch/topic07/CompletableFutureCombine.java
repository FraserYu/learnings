package top.dayarch.topic07;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * callback compose
 *
 * @author fraser
 * @date 2020/7/19 6:59 PM
 */
@Slf4j
public class CompletableFutureCombine {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<Double> weightFuture = CompletableFuture.supplyAsync(() -> 65.0);
		CompletableFuture<Double> heightFuture = CompletableFuture.supplyAsync(() -> 183.8);

		CompletableFuture<Double> combinedFuture = weightFuture
				.thenCombine(heightFuture, (weight, height) -> {
					Double heightInMeter = height/100;
					return weight/(heightInMeter*heightInMeter);
				});

		log.info("身体BMI指标 - " + combinedFuture.get());
	}

}
