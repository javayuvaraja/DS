package com.yuva.leetcode.stack;

import java.util.Stack;

public class SumofSubarrayRanges_MinMaxDiff {
	public long subArrayRanges(int[] A) {
        int n = A.length, minIndex, leftMinIndex;
        int minSum = 0;
        int maxSum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int currIndex = 0; currIndex <= n; currIndex++) {
            while (!stack.isEmpty() && A[stack.peek()] > (currIndex == n ? Integer.MIN_VALUE : A[currIndex])) {
                minIndex = stack.pop();
                leftMinIndex = stack.isEmpty() ? -1 : stack.peek();
                int leftCount = minIndex - leftMinIndex;
                int rightCount = currIndex - minIndex;
                minSum += (long)A[minIndex] * (leftCount) * (rightCount);

            }
            stack.push(currIndex);
        }
        
        stack.clear();
        int maxIndex =0;
        int leftMaxIndex = 0;
        for (int currIndex = 0; currIndex <= n; currIndex++) {
            while (!stack.isEmpty() && A[stack.peek()] < (currIndex == n ? Integer.MAX_VALUE : A[currIndex])) {
            	maxIndex = stack.pop();
            	leftMaxIndex = stack.isEmpty() ? -1 : stack.peek();
            	int leftCount = maxIndex - leftMaxIndex;
                int rightCount = currIndex - maxIndex;
                maxSum += (long)A[maxIndex] * (leftCount) * (rightCount);
            }
            stack.push(currIndex);
        }
        return maxSum-minSum;
    }
	
	public static void main(String[] args) {
		SumofSubarrayRanges_MinMaxDiff obj = new SumofSubarrayRanges_MinMaxDiff();
		int arr[]= {2, 9, 7, 8, 3, 4, 6, 1};
		System.out.println(obj.subArrayRanges(arr));
	}

}
