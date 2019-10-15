package com.example.concurrency.atomicresolver;

/**
 * 线程安全计数器
 *
 * @author fraser
 * @date 2019/9/18 2:44 PM
 */
public class SafeCounter {

	private int count;

	public synchronized void counter(){
		count++;
	}

	public synchronized int getCount(){
		return count;
	}
}
