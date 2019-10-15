package com.example.concurrency.testindaily;


/**
 * @author fraser
 * @date 2019-08-12 16:48
 */
public class AtomicTest {

	private long value;


	public synchronized long getValue() {
		return value;
	}

	public synchronized void inc() {
		++value;
	}
}
