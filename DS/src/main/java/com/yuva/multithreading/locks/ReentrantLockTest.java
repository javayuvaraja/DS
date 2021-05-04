package com.yuva.multithreading.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Polled and Timed Lock Acquisition
 * @author ykanagar
 *
 */
public class ReentrantLockTest {

	public boolean transferMoneyWithTryLock(Account fromAccount, Account toAccount, float amount)
			throws InsufficientAmountException, InterruptedException {

		// we are defining a stopTime
		long stopTime = System.nanoTime() + 5000;
		while (true) {
			if (fromAccount.lock.tryLock()) {
				try {
					if (toAccount.lock.tryLock()) {
						try {
							if (amount > fromAccount.getCurrentAmount()) {
								throw new InsufficientAmountException("Insufficient Balance");
							} else {
								fromAccount.debit(amount);
								toAccount.credit(amount);
							}

						} finally {
							toAccount.lock.unlock();
						}
					}

				} finally {
					fromAccount.lock.unlock();
				}
			}
			if (System.nanoTime() < stopTime)
				return false;

			Thread.sleep(100);
		} // while
	}

	class Account {
		float amount;
		ReentrantLock lock = new ReentrantLock();

		void credit(float amount) {

		}

		void debit(float amount) {

		}

		float getCurrentAmount() {
			return amount;
		}
	}

	class InsufficientAmountException extends Exception {
		InsufficientAmountException() {
			super();
		}

		InsufficientAmountException(String message) {
			super(message);
		}
	}
}
