package top.dayarch.topic03;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程状态测试
 *
 * @author fraser
 * @date 2020/3/22 9:15 PM
 */
@Slf4j
public class ThreadStateTest {

	public static void main(String[] args) throws InterruptedException {
		TestLock testLock = new TestLock();

		Thread thread2 = new Thread(() -> {
			testLock.myTestLock();
		}, "thread2");

		Thread thread1 = new Thread(() -> {
				testLock.myTestLock();
			}, "thread1");

		thread1.start();
		Thread.sleep(1000);

		thread2.start();
		Thread.sleep(1000);

		System.out.println("****" + (thread2.getState()));

		Thread.sleep(20000);


//		Thread thread = new Thread(() -> {});
//		thread.start();
////		Thread.sleep(1000);
//		System.out.println(thread.getState());

//		Thread t1 = new Thread(new DemoThreadB());
//		Thread t2 = new Thread(new DemoThreadB());
//
//		t1.start();
//		t2.start();
//
//		Thread.sleep(1000);
//
//		System.out.println((t2.getState()));
//		System.exit(0);
//		Thread main = Thread.currentThread();
//
//		Thread thread2 = new Thread(() -> {
//			try {
//				Thread.sleep(100000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println(main.getState());
//		});
//		thread2.start();
//		thread2.join();

//		Thread thread3 = new Thread(() -> {
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				Thread.currentThread().interrupt();
//				e.printStackTrace();
//			}
//		});
//		thread3.start();
//
//		Thread.sleep(1000);
//		System.out.println(thread3.getState());
	}


}

@Slf4j
class TestLock{
	private final Lock lock = new ReentrantLock();

	public void myTestLock(){
		lock.lock();
		try{
			Thread.sleep(10000);
			log.info("testLock status");
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		} finally {
			lock.unlock();
		}
	}
}

//class DemoThreadB implements Runnable {
//	@Override
//	public void run() {
//		commonResource();
//	}
//
//	public static synchronized void commonResource() {
//		while(true) {
//
//		}
//	}
//}
