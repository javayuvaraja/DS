package com.yuva.leetcode.queue;

public class CircularQueue {
	final int[] arr;
	int front, rear = -1, len = 0;

	public CircularQueue(int k) {
		arr = new int[k];
	}

	public boolean enQueue(int val) {
		if (!isFull()) {
			rear = (rear + 1) % arr.length;
			arr[rear] = val;
			len++;
			return true;
		} else
			return false;
	}

	public boolean deQueue() {
		if (!isEmpty()) {
			front = (front + 1) % arr.length;
			len--;
			return true;
		} else
			return false;
	}

	public int Front() {
		return isEmpty() ? -1 : arr[front];
	}

	public int Rear() {
		return isEmpty() ? -1 : arr[rear];
	}

	public boolean isEmpty() {
		return len == 0;
	}

	public boolean isFull() {
		return len == arr.length;
	}
}