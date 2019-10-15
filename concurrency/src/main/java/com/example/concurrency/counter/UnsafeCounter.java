package com.example.concurrency.counter;

/**
 * 线程不安全的计数器
 *
 * @author fraser
 * @date 2019/9/3 9:24 AM
 */
public class UnsafeCounter {

	private long count;

	private final Object obj = new Object();

	public void counter(){
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

	public long getCount() {
		return count;
	}


	public void testSynBlock(){
		synchronized (obj){
			count++;
		}
	}

	public synchronized void testSynMethod(){
//		synchronized (obj){
			count++;
//		}
	}
}
