package top.dayarch.topic04;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁示例一
 *
 * @author fraser
 * @date 2020/6/21 12:51 PM
 */
public class ReentrantReadWriteLockCache {

	// 定义一个非线程安全的 HashMap 用于缓存对象
	static Map<String, Object> map = new HashMap<String, Object>();
	// 创建读写锁对象
	static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	// 构建读锁
	static Lock rl = readWriteLock.readLock();
	// 构建写锁
	static Lock wl = readWriteLock.writeLock();

	public static final Object get(String key) {
		Object obj = null;
		rl.lock();
		try{
			obj = map.get(key);
		}finally {
			rl.unlock();
		}

		if (obj!= null) {
			return obj;
		}

		wl.lock();
		try{
			obj = map.get(key);
			if (obj == null) {
				obj = getDataFromDB(key); // 伪代码：getDataFromDB
				map.put(key, obj);
			}
		}finally {
			wl.unlock();
		}
		return obj;
	}

	public static final Object put(String key, Object value){
		wl.lock();
		try{
			return map.put(key, value);
		}finally {
			wl.unlock();
		}
	}

	public static final Object getLockUpgrade(String key) {
		Object obj = null;
		rl.lock();
		try{
			obj = map.get(key);
			if (obj == null){
				wl.lock();
				try{
					obj = map.get(key);
					if (obj == null) {
						obj = getDataFromDB(key); // 伪代码：getDataFromDB
						map.put(key, obj);
					}
				}finally {
					wl.unlock();
				}
			}
		}finally {
			rl.unlock();
		}

		return obj;
	}
}
