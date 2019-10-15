package com.example.concurrency.counter;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程安全多线程技术器
 *
 * @author fraser
 * @date 2019/9/2 1:24 PM
 */
@Slf4j
public class SafeThreadCounter {

	private long count;

	public synchronized void counter(){
		long start = 0;
		while (start ++ < 10000){
			count ++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		UnsafeCounter unsafeCounter = new UnsafeCounter();

		Thread thread1 = new Thread(unsafeCounter::counter, "线程1");
		Thread thread2 = new Thread(unsafeCounter::counter, "线程2");

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		System.out.println(unsafeCounter.getCount());
	}

	public synchronized long getCount() {
		return count;
	}


}
