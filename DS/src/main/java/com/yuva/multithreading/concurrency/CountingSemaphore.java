package com.yuva.multithreading.concurrency;

public class CountingSemaphore {

	int usedPermits = 0; // permits given out
	int maxCount; // max permits to give out

	public CountingSemaphore(int capacity) {
		this.maxCount = capacity;
	}

	public synchronized void acquire() throws InterruptedException {

		while (usedPermits == maxCount)
			wait();

		usedPermits++;
		notifyAll();
	}

	public synchronized void release() throws InterruptedException {

		while (usedPermits == 0)
			wait();

		usedPermits--;
		notifyAll();
	}
}
