package com.example.concurrency.accountbook;

import java.math.BigDecimal;

/**
 * 账户
 *
 * @author fraser
 * @date 2019/10/18 11:24 AM
 */
public class Account {
	//单例的账本管理员
	private AccountBookManager accountBookManager;

	private int balance;

	public void transfer(Account target, int amt){
		// 一次性申请转出账户和转入账户，直到成功
		while(accountBookManager.getAllRequiredAccountBook(this, target));

		try{
			// 锁定转出账户
			synchronized(this){
				// 锁定转入账户
				synchronized(target){
					if (this.balance > amt){
						this.balance -= amt;
						target.balance += amt;
					}
				}
			}
		} finally {
			accountBookManager.releaseObtainedAccountBook(this, target);
		}

	}
}
