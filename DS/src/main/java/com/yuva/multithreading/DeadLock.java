package com.yuva.multithreading;

public class DeadLock {

	private int counter = 0;
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	Runnable incrementerTask = new Runnable() {
		@Override
		public void run() {
			try {
				for (int i = 0; i < 100; i++) {
					incrementCounter();
					System.out.println("Incrementing " + i);
				}
			} catch (InterruptedException ie) {
			}
		}
	};

	Runnable decrementerTask = new Runnable() {

		@Override
		public void run() {
			try {
				for (int i = 0; i < 100; i++) {
					decrementCounter();
					System.out.println("Decrementing " + i);
				}
			} catch (InterruptedException ie) {
			}

		}
	};

	public void runTest() throws InterruptedException {

		Thread thread1 = new Thread(incrementerTask);
		Thread thread2 = new Thread(decrementerTask);

		thread1.start();
		// sleep to make sure thread 1 gets a chance to acquire lock1
		Thread.sleep(100);
		thread2.start();

		thread1.join();
		thread2.join();

		System.out.println("Done : " + counter);
	}

	void incrementCounter() throws InterruptedException {
		synchronized (lock1) {
			System.out.println("Acquired lock1");
			Thread.sleep(100);

			synchronized (lock2) {
				counter++;
			}
		}
	}

	void decrementCounter() throws InterruptedException {
		synchronized (lock2) {
			System.out.println("Acquired lock2");

			Thread.sleep(100);
			synchronized (lock1) {
				counter--;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		DeadLock obj = new DeadLock();
		obj.runTest();
	}
}
