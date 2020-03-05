package top.dayarch;

/**
 * 线程不安全的操作
 *
 * @author fraser
 * @date 2020/3/2 2:06 PM
 */
public class ThreadNotSafeInteger {
	/**
	 * 共享变量 value
	 */
	private int value;

	public synchronized int getValue() {
		return value;
	}

	public synchronized void setValue(int value) {
		this.value = value;
	}
}
