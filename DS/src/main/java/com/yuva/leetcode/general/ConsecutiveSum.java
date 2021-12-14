package com.yuva.leetcode.general;

public class ConsecutiveSum {

	public static int consecutiveNumbersSum(int N) {

		int constant_term = 0;
		int divisor = 1;
		int ans = 0;
		while (constant_term < N) {
			if ((N - constant_term) % divisor == 0) {
				ans += 1;
			}

			constant_term = constant_term + divisor;
			divisor += 1;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int num  = 9;
		System.out.println(consecutiveNumbersSum(num));
	}
	
	
	/**
	 * Sliding window approach
	 * @param N
	 * @return
	 */
	public int consecutiveNumbersSum1(int N) {
		if (N <= 2)
			return 1;
		int n = N / 2 + 1;
		int start = 1;
		int counter = 0;
		int currentSum = 0;
		for (int end = 1; end <= n; end++) {
			currentSum = currentSum + end;
			while (currentSum > N && start <= end) {
				currentSum = currentSum - start++;
			}
			if (currentSum == N)
				counter++;
		}
		return counter + 1;
	}

}