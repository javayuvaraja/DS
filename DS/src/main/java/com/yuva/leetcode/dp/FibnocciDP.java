package com.yuva.leetcode.dp;

public class FibnocciDP {

	public int fib(int n) {
		if (n == 0) {
			return 0;
		}
		int result[] = new int[n + 1];
		result[0] = 0;
		result[1] = 1;

		if (n < 2) {
			return result[n];
		}

		for (int i = 2; i <= n; i++) {
			result[i] = result[i - 2] + result[i - 1];
		}
		return result[n];
	}

	static void Fibonacci(int N) {
		int num1 = 0, num2 = 1;
		int counter = 0;

		// Iterate till counter is N
		while (counter < N) {
			// Print the number
			System.out.print(num1 + " ");
			// Swap
			int num3 = num2 + num1;
			num1 = num2;
			num2 = num3;
			counter = counter + 1;
		}
	}
	
	public static void main(String[] args) {
		Fibonacci(10);
	}
}
