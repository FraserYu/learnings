package com.example.concurrency.happensbefore;

/**
 * @author fraser
 * @date 2019/9/11 4:34 PM
 */
public class SynchronizedExample {
	private int x = 0;

	public void synBlock() {
		// 1.加锁
		synchronized (SynchronizedExample.class) {
			x = 1; // 对x赋值
		}
		// 3.解锁
	}

	// 1.加锁
	public synchronized void synMethod() {
		x = 2; // 对x赋值
	}
	// 3. 解锁
}
