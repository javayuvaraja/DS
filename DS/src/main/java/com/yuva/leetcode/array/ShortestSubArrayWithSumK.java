package com.yuva.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubArrayWithSumK {

	public int shortestSubarray(int[] A, int K) {
        int N = A.length, res = N + 1;
        int[] B = new int[N + 1];
        for (int i = 0; i < N; i++) {
        	B[i + 1] = B[i] + A[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
        	
        	/*
        	 * First element is the old element, removing the outside of the window.
        	 */
            while (deque.size() > 0 && B[i] - B[deque.getFirst()] >=  K) {
            	res = Math.min(res, i - deque.pollFirst());
            }
                
            /*
             * when current element is less than previous element then remove, because it cant be part of the result
             * we have to return the smallest window.
             */
            while (deque.size() > 0 && B[i] <= B[deque.getLast()])
                deque.pollLast();
            deque.addLast(i);
        }
        return res <= N ? res : -1;
    }
	
	
	/**
	 * o(n2) solution
	 * @param A
	 * @param K
	 * @return
	 */
	public int shortestSubarray1(int[] A, int K) {
        int[] presum = new int[A.length+1];
        int res = A.length+1;
        for(int i=1;i<presum.length;i++){
            presum[i] = presum[i-1]+A[i-1];
            for(int j=i-1;j>=0;j--){
                if(presum[i]-presum[j]>=K)
                    res = Math.min(res, i-j);
            }
        }
        return res == (A.length+1)?-1: res;
    }
}
