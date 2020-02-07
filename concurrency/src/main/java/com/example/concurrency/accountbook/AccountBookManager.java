package com.example.concurrency.accountbook;

import java.util.ArrayList;
import java.util.List;

/**
 * 账户管理员
 *
 * @author fraser
 * @date 2019/10/18 11:24 AM
 */
public class AccountBookManager {

	List<Object> accounts = new ArrayList<>(2);

	synchronized boolean getAllRequiredAccountBook( Object from, Object to){
		if(accounts.contains(from) || accounts.contains(to)){
			return false;
		} else{
			accounts.add(from);
			accounts.add(to);

			return true;
		}
	}
	// 归还资源
	synchronized void releaseObtainedAccountBook(Object from, Object to){
		accounts.remove(from);
		accounts.remove(to);
	}
}
