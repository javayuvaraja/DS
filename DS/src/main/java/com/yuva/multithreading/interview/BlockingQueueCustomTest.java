package com.yuva.multithreading.interview;

public class BlockingQueueCustomTest {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueueCustom<Integer> b = new LinkedBlockingQueueCustom<Integer>(10);
		System.out.println("put(11)");
		b.put(11);
		System.out.println("put(12)");
		b.put(12);
		System.out.println("take() > " + b.take());
		System.out.println("take() > " + b.take());

	}
}