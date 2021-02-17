package top.dayarch.topic08;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinDemo
 *
 * @author rgyb
 * @date 2020/12/29 9:56 PM
 */
@Slf4j
public class ForkJoinDemo {
	public static void main(String[] args) {
		int n = 6;

		// 为了追踪子线程名称，需要重写 ForkJoinWorkerThreadFactory 的方法
		final ForkJoinPool.ForkJoinWorkerThreadFactory factory = pool -> {
			final ForkJoinWorkerThread worker = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
			worker.setName("my-thread" + worker.getPoolIndex());
			return worker;
		};

		//创建分治任务线程池，可以追踪到线程名称
		ForkJoinPool forkJoinPool = new ForkJoinPool(4, factory, null, false);

		// 快速创建 ForkJoinPool 方法
//		 ForkJoinPool forkJoinPool = new ForkJoinPool(4);
//		 ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

		//创建分治任务
		Fibonacci fibonacci = new Fibonacci(n);

		//调用 invoke 方法启动分治任务
		Integer result = forkJoinPool.invoke(fibonacci);
		log.info("Fibonacci {} 的结果是 {}", n, result);
	}
}

@Slf4j
class Fibonacci extends RecursiveTask<Integer> {
	final int n;
	Fibonacci(int n) {
		this.n = n;
	}

	@Override
	public Integer compute() {
		//和递归类似，定义可计算的最小单元
		if (n <= 1) {
			return n;
		}
		// 想查看子线程名称输出的可以打开下面注释
		log.info(Thread.currentThread().getName() + "#" + n);

		Fibonacci f1 = new Fibonacci(n - 1);
		// 拆分成子任务
		f1.fork();
		Fibonacci f2 = new Fibonacci(n - 2);
		// f1.join 等待子任务执行结果
		return f2.compute() + f1.join();
	}
}
