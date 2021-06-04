package com.yuva.leetcode.general;

/**

69. Sqrt(x)

Given a non-negative integer x, compute and return the square root of x.
Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

Example 1:

Input: x = 4
Output: 2

Example 2:
Input: x = 8
Output: 2

Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.

 * @author Yuvaraja Kanagarajan
 *
 */
public class SqrtOfX {

	public int mySqrt(int x) {
		if (x == 0)
			return 0;
		int left = 1, right = x;
		while (true) {
			int mid = (left + right) / 2;
			if (mid > x / mid) {
				right = mid - 1;
			} else {
				if (mid + 1 > x / (mid + 1))
					return mid;
				left = mid + 1;
			}
		}
	}
	
	static float squareRoot(int number, int precision) {
		int start = 0, end = number;
		double ans = 0.0;

		// for computing integral part
		// of square root of number
		while (start <= end) {
			int mid = (start + end) / 2;

			if (mid * mid == number) {
				ans = mid;
				break;
			}

			if (mid * mid < number) {
				start = mid + 1;
				ans = mid;
			} else {
				end = mid - 1;
			}
		}

		// For computing the fractional part
		// of square root upto given precision
		double increment = 0.1;
		for (int i = 0; i < precision; i++) {
			while (ans * ans <= number) {
				ans += increment;
			}

			// loop terminates when ans * ans > number
			ans = ans - increment;
			increment = increment / 10;
		}
		return (float) ans;
	}
}
