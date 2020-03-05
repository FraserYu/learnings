package top.dayarch.topic01;

/**
 * 并发编程有序性问题验证
 *
 * @author fraser
 * @date 2020/2/27 8:04 PM
 */
public class OrderIssue {
	private static OrderIssue instance;

	public static OrderIssue getInstance(){
		if (instance == null){
			synchronized (OrderIssue.class){
				if (instance == null){
					instance = new OrderIssue();
				}
			}
		}
		return instance;
	}

	//TODO 单例模式的其他几种模式
}
