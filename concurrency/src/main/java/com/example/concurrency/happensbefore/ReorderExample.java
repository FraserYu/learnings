package com.example.concurrency.happensbefore;

/**
 * 重排序例子
 *
 * @author fraser
 * @date 2019/9/10 2:34 PM
 */
public class ReorderExample {

	private int x = 0;
	private int y = 1;
	private boolean flag = false;

	public void writer() {
		x = 42;    //1
		y = 50;    //2
		flag = true;    //3
	}

	public void reader() {
		if (flag) {    //4
			System.out.println("x:" + x);    //5
			System.out.println("y:" + y);    //6
		}
	}


	public static void main(String[] args) throws InterruptedException {
		ReorderExample recordExample = new ReorderExample();

		Thread thread1 = new Thread(recordExample::writer, "线程1");
		Thread thread2 = new Thread(recordExample::reader, "线程2");

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		System.out.println("主线程结束");
	}
}

/**
 * 测试说明：
 * 通过多次执行，还暂时为得到输出x=0的情况，但确实存在冲排序隐患
 */
