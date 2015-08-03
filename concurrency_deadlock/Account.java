package concurrency_deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	private int balance;
	private Lock lock;
		
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}

	public Account(int initialBalance){
		this.balance = initialBalance;
		lock = new ReentrantLock();
		lock.lock();
	}
	
	public void withdraw(int amount){
		balance -= amount;
	}
	
	public void deposit(int amount){
		balance += amount;
	}

	@Override
	public String toString() {
		return "Account [balance: " + balance + "]";
	}
	
}
