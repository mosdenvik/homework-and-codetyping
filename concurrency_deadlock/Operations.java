package concurrency_deadlock;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Operations {

	public static final Logger logger = Logger.getLogger(Operations.class
			.getSimpleName());

	public static void main(String[] args) {
		final Account a = new Account(1000);
		final Account b = new Account(2000);

		new Thread(new Runnable() {
			@Override
			public void run() {
				logger.info("Hello from 2nd thread: " + Thread.currentThread().getName());
				try {
					transfer(a, b, 500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		logger.info("Hello from main 2nd thread: "	+ Thread.currentThread().getName());

		try {
			transfer(b, a, 300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	static void transfer(Account acc1, Account acc2, int amount) throws InterruptedException {
		if (acc1.getBalance() < amount) {
			System.err.println("No enough money at:" + acc1.toString());
		}

		logger.info("Trying to lock 1st transfer...");
		if (acc1.getLock().tryLock(10, TimeUnit.SECONDS)) {
			try {
				logger.info("Trying to lock 2nd transfer...");
				if (acc2.getLock().tryLock(10, TimeUnit.SECONDS)) {
					try {
						logger.info("Trying to withdraw " + amount + " from: " + acc1.getBalance());
						acc1.withdraw(amount);
						logger.info("Trying to deposit " + amount +  " to: " + acc2.getBalance());
						acc2.deposit(amount);
					} finally {
						acc2.getLock().unlock();
					}
				}
			} finally {
				acc1.getLock().unlock();
			}
			System.out.println("Transfer succesfull! \nNow acc1 = "
					+ acc1.getBalance() + ", \nacc2 = " + acc2.getBalance());
		} else {
			logger.info("The transaction is not possible...");
		}

		
	}
}
