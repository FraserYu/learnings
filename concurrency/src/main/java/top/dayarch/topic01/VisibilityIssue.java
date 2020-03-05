package top.dayarch.topic01;

import lombok.extern.slf4j.Slf4j;

/**
 * 并发编程可见性问题验证
 *
 * @author fraser
 * @date 2020/2/27 7:40 PM
 */
@Slf4j
public class VisibilityIssue {
	private static final int TOTAL = 10000;
//	private int count;

//	即便像下面这样加了 volatile 关键字修饰依旧不会解决问题，因为并没有解决原子性问题
	private volatile int count;

	public static void main(String[] args) {
		VisibilityIssue visibilityIssue = new VisibilityIssue();

		Thread thread1 = new Thread(() -> visibilityIssue.add10KCount());
		Thread thread2 = new Thread(() -> visibilityIssue.add10KCount());

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}

		log.info("count 值为：{}", visibilityIssue.count);

	}

	private void add10KCount(){
		int start = 0;
		while (start ++ < TOTAL){
			this.count ++;
		}
	}

}
