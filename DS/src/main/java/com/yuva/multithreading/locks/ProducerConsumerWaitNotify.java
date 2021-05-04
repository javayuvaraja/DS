package com.yuva.multithreading.locks;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerWaitNotify {

	private Queue<Integer> queue = new LinkedList<>();
	private static final int MAX_SIZE = 10;
	private Object lock = new Object();
	private int count =1;
	public void produce () {
		synchronized (lock) {
			while (queue.size() > MAX_SIZE) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Produced : "+count);
			queue.add(count++);
			lock.notify();
		}
	}
	
	public void consume () {
		synchronized (lock) {
			while (queue.isEmpty()) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Consumed "+ queue.poll());
			lock.notify();
		}
	}
	
	static class Producer implements Runnable {
		ProducerConsumerWaitNotify obj ;
		Producer(ProducerConsumerWaitNotify obj) {
			this.obj =obj;
		}
		
		public void run() {
			for (int i=0; i < 100; i++) {
				obj.produce();
			}
		}
	}
	
	static class Consumer implements Runnable {
		ProducerConsumerWaitNotify obj ;
		Consumer(ProducerConsumerWaitNotify obj) {
			this.obj =obj;
		}
		
		public void run() {
			for (int i=0; i < 100; i++) {
				obj.consume();
			}
		}
	}
	
	public static void main(String[] args) {
		ProducerConsumerWaitNotify obj = new ProducerConsumerWaitNotify();
		
		Thread producerThread =  new Thread(new Producer (obj), "Producer Thread");
		Thread consumerThread =  new Thread(new Consumer (obj), "Consumer Thread");
		
		consumerThread.start();
		producerThread.start();
		
	}
}
