package com.yuva.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KCloesestPointToOrigin {

	/**
	 * Logic : Use Max Heap with K size.
	 * @param points
	 * @param K
	 * @return
	 */
	public int[][] kClosest(int[][] points, int K) {

		PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] left, int[] right) {
				return getDistance(right) - getDistance(left);
			}
		});

		for (int point[] : points) {
			heap.offer(point);
			if (heap.size() > K) {
				heap.poll();
			}
		}

		int[][] result = new int[K][2];
		int index = 0;
		while (!heap.isEmpty()) {
			result[index++] = heap.poll();
		}

		return result;
	}

	private int getDistance(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}
}
