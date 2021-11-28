package com.yuva.leetcode.general;

import java.util.HashSet;

public class ValidSquare {

	/**
	 * Logic : If 4 sides distance are equals and diagonal size is equal then it is square
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 * @return
	 */
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		
		HashSet<Integer> set = new HashSet<>();
		// 4 Sides distance
		set.add(distance(p1, p2));
		set.add(distance(p2, p3));
		set.add(distance(p3, p4));
		set.add(distance(p1, p4));
		
		
		// 2 diagonals
		set.add(distance(p2, p4));
		set.add(distance(p1, p3));
		
		return !set.contains(0) && set.size() == 2;
	}

	private int distance(int[] a, int[] b) {
		return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
	}
}
