package com.example.concurrency.atomicresolver;

/**
 * 非线程安全计数器
 *
 * @author fraser
 * @date 2019/9/18 2:44 PM
 */
public class UnsafeCounter {

	private static int count;

	public synchronized void counter(){
		count++;
	}

	public static synchronized int calc(){
		return count++;
	}
}
