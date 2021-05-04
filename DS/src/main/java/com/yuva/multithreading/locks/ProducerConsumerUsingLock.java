package com.yuva.multithreading.locks;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingLock {
	private static Queue<Integer> queue = new LinkedList<>();
	private Lock lock = new ReentrantLock();
	private Condition added = lock.newCondition();
	private Condition removed = lock.newCondition();
	private int count = 0;
	private static final int MAX_QUEUE_SIZE = 10;

	public void produce() throws InterruptedException {
		lock.lock();
		try {
			while (queue.size() == MAX_QUEUE_SIZE) {
				added.await();
			}
			queue.add(count++);
			System.out.println("produced  " +count);
			removed.signal();
		} finally {
			lock.unlock();
		}
	}

	public void consume() throws InterruptedException {
		lock.lock();
		try {
			while (queue.isEmpty()) {
				removed.await();
			}
			System.out.println("consumed " + queue.poll());
			added.signal();
		} finally {
			lock.unlock();
		}
	}

	static class Producer implements Runnable {
		ProducerConsumerUsingLock pci;

		public Producer(ProducerConsumerUsingLock pci) {
			this.pci = pci;
		}

		public void run() {
			int i = 0;
			while (i < 100) {
				try {
					pci.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
			}
		}
	}

	static class Consumer implements Runnable {
		ProducerConsumerUsingLock pci;

		public Consumer(ProducerConsumerUsingLock pci) {
			this.pci = pci;
		}

		public void run() {
			int i = 0;
			while (i < 100) {
				try {
					pci.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumerUsingLock pci = new ProducerConsumerUsingLock();
		Thread tp1 = new Thread(new Producer(pci), "producer-1");
		Thread tc1 = new Thread(new Consumer(pci), "consumer-1");
		tc1.start();
		Thread.sleep(1000);
		tp1.start();
	}
}
