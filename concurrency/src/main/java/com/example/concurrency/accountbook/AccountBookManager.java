package com.example.concurrency.accountbook;

/**
 * 账户管理员
 *
 * @author fraser
 * @date 2019/10/18 11:24 AM
 */
public class AccountBookManager {
	synchronized boolean getAllRequiredAccountBook( Object from, Object to){
		if(拿到所有账本){
			return true;
		} else{
			return false;
		}
	}
	// 归还资源
	synchronized void releaseObtainedAccountBook(Object from, Object to){
		归还获取到的账本
	}
}
