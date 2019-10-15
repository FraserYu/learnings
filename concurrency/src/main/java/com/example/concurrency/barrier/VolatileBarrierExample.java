package com.example.concurrency.barrier;

/**
 * 内存屏障测试
 *
 * @author fraser
 * @date 2019/9/24 9:21 PM
 */
public class VolatileBarrierExample {

	private int a;
	private volatile int v1 = 1;
	private volatile int v2 = 2;

	void readAndWrite() {
		int i = v1; //第一个volatile读
		int j = v2;    //第二个volatile读
		a = i + j;    //普通写
		v1 = i + 1;    //第一个volatile写
		v2 = j * 2;    //第二个volatile写
	}
}
