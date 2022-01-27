package com.yuva.leetcode.general;

/**
 * Here's my simple understanding of the problem: For representing N as sum of
 * consecutive integers we have the following scenarios:
 * 
 * N = M + 0 (Base case when M == N, or when N is sum of only one number i.e
 * itself) N = M + (M + 1) (when N is sum of two consecutive numbers e.g 9 =
 * 4+5, here M is 4 ) => 2M + 1 N = M + (M+1) + (M+2) (when N is sum of 3
 * consecutive numbers, e.g 9 = 2+3+4, here M is 2) => 3M + 3 N = M + (M+1) +
 * (M+2) + (M+3) => 4*M + 6 N = M + (M+1) + (M+2) + (M+3) + (M+4) => 5M + 10 N =
 * M + (M+1) + (M+2) + (M+3) + (M+4) + (M + 5) => 6M + 15 ....... and so on
 * 
 * so looking at this series we need to find the unique numbers of M such that
 * they fit our equations. (M needs to be an integer)
 * 
 * So we can write it as something like this =>
 * 
 * class Solution: def consecutiveNumbersSum(self, N: int) -> int:
 * 
 * constant_term = 0 divisor = 1 ans = 0 while constant_term < N: # if
 * ((N-constant_term)/divisor).is_integer(): if ((N-constant)%divisor==0): ans
 * += 1
 * 
 * constant_term = constant_term + divisor divisor += 1
 * 
 * return ans
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class ConsecutiveNumberSum {

	public int consecutiveNumbersSum(int N) {
		int constant = 0;
		int divisor = 1;
		int ans = 0;
		while (constant < N) {
			if ((N - constant) % divisor == 0) {
				ans += 1;
			}
			constant = constant + divisor;
			divisor += 1;
		}
		return ans;
	}
	
	
	public int consecutiveNumbersSum_SlidingWindow(int N) {
		if (N <= 2) {
			return 1;
		}
		int n = N / 2 + 1;
		int start = 1;
		int result = 0;
		int currentSum = 0;
		for (int end = 1; end <= n; end++) {
			currentSum = currentSum + end;
			while (currentSum > N && start <= end) { // removing start when current sum is more than the N
				currentSum = currentSum - start;
				start++;
			}
			if (currentSum == N) {
				result++;
			}
		}
		return result + 1;
	}
}
