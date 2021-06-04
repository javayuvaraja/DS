package com.yuva.leetcode.general;

public class ReverseNumber {

	public int reverse(int x) {
		boolean isNegative = x < 0;
		if (x < 0) {
			x = -x;
		}

		long revNumber = 0;
		int multiply = 10;
		int remain = x;
		while (remain > 0) {
			int temp = remain % 10;
			remain = remain / 10;
			revNumber = (revNumber * multiply) + (temp);
		}
		if (revNumber > Integer.MAX_VALUE) {
			revNumber = 0;
		}
		return isNegative ? -(Math.toIntExact(revNumber)) : (Math.toIntExact(revNumber));
	}
}
