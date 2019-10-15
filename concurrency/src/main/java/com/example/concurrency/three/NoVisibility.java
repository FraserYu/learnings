package com.example.concurrency.three;

/**
 * @author fraser
 * @date 2019-07-28 20:38
 */

/**
 * NoVisibility
 * <p/>
 * Sharing variables without synchronization
 *
 * @author Brian Goetz and Tim Peierls
 */

public class NoVisibility {
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {

		@Override
		public void run() {
			while (!ready) {
				Thread.yield();
			}
			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		new ReaderThread().start();
		number = 42;
		ready = true;
	}
}
