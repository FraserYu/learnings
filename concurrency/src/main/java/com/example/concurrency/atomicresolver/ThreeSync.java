package com.example.concurrency.atomicresolver;

/**
 * 三种synchronized的使用
 *
 * @author fraser
 * @date 2019/9/17 6:54 PM
 */
public class ThreeSync {

	private static final Object object = new Object();

	public synchronized void normalSyncMethod(){
		//临界区
	}

	public static synchronized void staticSyncMethod(){
		//临界区
	}

	public void syncBlockMethod(){
		synchronized (object){
			//临界区
		}
	}
}
