package com.yuva.leetcode.search;

public class ArrangeCoins {

	public int arrangeCoins(int n) {
		long left = 0; // we use "long" because we may get an integer overflow
		long right = n;
		while (left <= right) {
			long mid = left + (right - left) / 2;
			long coinsUsed = mid * (mid + 1) / 2;
			if (coinsUsed == n) {
				return (int) mid;
			}
			if (n < coinsUsed) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return (int) right; // cast as an "int" because it was initiliazed as a "long"

	}
}
