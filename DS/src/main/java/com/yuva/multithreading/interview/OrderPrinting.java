package com.yuva.multithreading.interview;

class OrderedPrinting {

	int count;

	public OrderedPrinting() {
		count = 1;
	}

	public void printFirst() throws InterruptedException {

		synchronized (this) {
			while (count % 3 != 1) {
				this.wait();
			}
			System.out.println("Thread " +Thread.currentThread().getName() + " - " +count );
			count++;
			this.notifyAll();
		}
	}

	public void printSecond() throws InterruptedException {

		synchronized (this) {
			while (count %3 != 2) {
				this.wait();
			}
			System.out.println("Thread " +Thread.currentThread().getName() + " - " +count);
			count++;
			this.notifyAll();
		}

	}

	public void printThird() throws InterruptedException {

		synchronized (this) {
			while (count % 3 != 0) {
				this.wait();
			}
			System.out.println("Thread " +Thread.currentThread().getName()  + " - " +count);
			count++;
			this.notifyAll();
		}

	}

	public static void main(String[] args) {
		OrderedPrinting obj = new OrderedPrinting();

		OrderedPrintingThread t1 = new OrderedPrintingThread(obj, "first");
		t1.setName("first");
		
		OrderedPrintingThread t2 = new OrderedPrintingThread(obj, "second");
		t2.setName("second");
		
		OrderedPrintingThread t3 = new OrderedPrintingThread(obj, "third");
		t3.setName("third");
		
		t2.start();
		t3.start();
		t1.start();

	}
}

class OrderedPrintingThread extends Thread {
	private OrderedPrinting obj;
	private String threadName;

	public OrderedPrintingThread(OrderedPrinting obj, String method) {
		this.threadName = method;
		this.obj = obj;
	}

	public void run() {
		// for printing "First"
		for (int i=0; i < 100; i++) {
			if ("first".equals(threadName)) {
				try {
					obj.printFirst();
				} catch (InterruptedException e) {
	
				}
			}
			// for printing "Second"
			else if ("second".equals(threadName)) {
				try {
					obj.printSecond();
				} catch (InterruptedException e) {
	
				}
			}
			// for printing "Third"
			else if ("third".equals(threadName)) {
				try {
					obj.printThird();
				} catch (InterruptedException e) {
	
				}
			}
		}
	}

}