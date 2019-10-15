package com.example.concurrency.atomicresolver;

import java.util.Objects;

/**
 * 有效的锁
 *
 * @author fraser
 * @date 2019/9/18 9:38 PM
 */
public class ValidLock {

	private static final Object object = new Object();

	private int count;

	public synchronized void badSync(){
		//其他与共享变量count无关的业务逻辑
		count++;
	}

	public void goodSync(){
		//其他与共享变量count无关的业务逻辑
		synchronized (object){
			count++;
		}
	}
}
