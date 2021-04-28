package com.yuva.leetcode.heap;

public class MinHeap {
	private int[] heapArr;
	private int heapSize;
	private int[] dataArr;

	public MinHeap (int[] data) {
		this.heapArr = new int[data.length];
		dataArr = data;
		heapSize = 0;
	}
	
	public int getParent(int childIndex) {
		if (childIndex <= 0 || childIndex >= heapSize) {
			return -1;
		}
		return (childIndex - 1) / 2;
	}
	
	public int getLeftChild(int parentIndex) {
		int leftChild = 2 * parentIndex + 1;
		if (leftChild >= heapSize) {
			return -1;
		}
		return leftChild;
	}
	
	public int getRightChild(int parentIndex) {
		int rightChild = 2 * parentIndex + 2;
		if (rightChild >= heapSize) {
			return -1;
		}
		return rightChild;
	}
	
	public void buildHeap() {
		for (int data : dataArr) {
			insert(data);
		}
	}

	public void insert(int data) {
		heapSize++;
		heapArr[heapSize - 1] = data;
		percolateUp();
	}
	
	private void percolateUp() {
		int currIndex = heapSize - 1;
		int parentIndex = getParent(currIndex);
		while (parentIndex >= 0) {
			if (heapArr[currIndex] > heapArr[parentIndex]) {
				swap(currIndex, parentIndex);
				currIndex = parentIndex;
				parentIndex = getParent(currIndex);
			} else {
				break;
			}
		}
	}

	private void swap(int currIndex, int parentIndex) {
		int temp = heapArr[parentIndex];
		heapArr[parentIndex] = heapArr[currIndex];
		heapArr[currIndex] = temp;
	}

	public int deleteMax() {
		int maxElement = heapArr[0];
		heapArr[0] = heapArr[heapSize - 1];
		heapSize--;
		percolateDown();
		return maxElement;
	}

	private void percolateDown() {
		int currIndex = 0;
		int leftChildIndex, rightChildIndex, maxIndex;
		leftChildIndex = getLeftChild(currIndex);
		while (leftChildIndex != -1) {
			maxIndex = leftChildIndex;
			rightChildIndex = getRightChild(currIndex);
			if (rightChildIndex != -1 && heapArr[rightChildIndex] > heapArr[maxIndex]) {
				maxIndex = rightChildIndex;
			}

			if (heapArr[maxIndex] > heapArr[currIndex]) {
				swap(maxIndex, currIndex);
				currIndex = maxIndex;
				leftChildIndex = getLeftChild(currIndex);
			} else {
				break;
			}
		}
	}

	public int getKthMax(int k) {
		if (k < 1 || k > heapSize) {
			System.out.println("Invalid index");
			return -1;
		}
		int kthMax = 0;
		for (int i = 0; i < k; i++) {
			kthMax = deleteMax();
		}

		return kthMax;
	}
	
	
}
