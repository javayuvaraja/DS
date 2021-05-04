package com.yuva.multithreading.concurrency;

public class BlockingQueueTest<T> {

	T[] array;
	int size = 0;
	int capacity;
	int head = 0;
	int tail = 0;

	@SuppressWarnings("unchecked")
	public BlockingQueueTest(int capacity) {
		array = (T[]) new Object[capacity];
		this.capacity = capacity;
	}

	public synchronized void enqueue(T item) throws InterruptedException {

		// wait for queue to have space
		while (size == capacity) {
			wait();
		}

		// reset tail to the beginning if the tail is already
		// at the end of the backing array
		if (tail == capacity) {
			tail = 0;
		}

		// place the item in the array
		array[tail] = item;
		size++;
		tail++;

		// don't forget to notify any other threads waiting on
		// a change in value of size. There might be consumers
		// waiting for the queue to have atleast one element
		notifyAll();
	}

	public synchronized T dequeue() throws InterruptedException {

		T item = null;

		// wait for atleast one item to be enqueued
		while (size == 0) {
			wait();
		}

		// reset head to start of array if its past the array
		if (head == capacity) {
			head = 0;
		}

		// store the reference to the object being dequeued
		// and overwrite with null
		item = array[head];
		array[head] = null;
		head++;
		size--;

		// don't forget to call notify, there might be another thread
		// blocked in the enqueue method.
		notifyAll();

		return item;
	}

	public static void main(String args[]) throws Exception {
		final BlockingQueueTest<Integer> q = new BlockingQueueTest<Integer>(5);

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					for (int i = 0; i < 50; i++) {
						q.enqueue(new Integer(i));
						System.out.println("enqueued " + i);
					}
				} catch (InterruptedException ie) {

				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					for (int i = 0; i < 25; i++) {
						System.out.println("Thread 2 dequeued: " + q.dequeue());
					}
				} catch (InterruptedException ie) {

				}
			}
		});

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					for (int i = 0; i < 25; i++) {
						System.out.println("Thread 3 dequeued: " + q.dequeue());
					}
				} catch (InterruptedException ie) {

				}
			}
		});

		t1.start();
		Thread.sleep(4000);
		t2.start();

		t2.join();

		t3.start();
		t1.join();
		t3.join();
	}

}