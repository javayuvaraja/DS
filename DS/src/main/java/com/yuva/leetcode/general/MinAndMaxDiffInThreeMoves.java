package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinAndMaxDiffInThreeMoves {

	/**
	 * Logic :
	 * We have 4 plans:

kill 3 biggest elements
kill 2 biggest elements + 1 smallest elements
kill 1 biggest elements + 2 smallest elements
kill 3 smallest elements

A = [1,5,6,13,14,15,16,17]
n = 8

Case 1: kill 3 biggest elements

All three biggest elements can be replaced with 14
[1,5,6,13,14,15,16,17] -> [1,5,6,13,14,14,14,14] == can be written as A[n-4] - A[0] == (14-1 = 13)

Case 2: kill 2 biggest elements + 1 smallest elements

[1,5,6,13,14,15,16,17] -> [5,5,6,13,14,15,5,5] == can be written as A[n-3] - A[1] == (15-5 = 10)

Case 3: kill 1 biggest elements + 2 smallest elements

[1,5,6,13,14,15,16,17] -> [6,6,6,13,14,15,16,6] == can be written as A[n-2] - A[2] == (16-6 = 10)

Case 4: kill 3 smallest elements

[1,5,6,13,14,15,16,17] -> [13,13,13,13,14,15,16,17] == can be written as A[n-1] - A[3] == (17-13 = 4)

Answer is minimum of all these cases!

	 * @param A
	 * @return
	 */
	public int minDifference(int[] A) {
        int n = A.length, res = Integer.MAX_VALUE;
        if (n < 5) return 0;
        Arrays.sort(A);
        for (int i = 0; i < 4; ++i) {
            res = Math.min(res, A[n - 4 + i] - A[i]);
        }
        return res;
    }
	
	
	public int minDifference1(int[] nums) {
        PriorityQueue<Integer> max = new PriorityQueue<>();
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: nums){
            if(max.size() < 4){
                max.add(i);
                min.add(i);
            }else{
                max.add(Math.max(max.poll(), i));
                min.add(Math.min(min.poll(), i));
            }
        }
        List<Integer> al = new ArrayList<>();
        while(!min.isEmpty()){
            al.add(min.poll());
        }
        int ans = Integer.MAX_VALUE;
        for(int i=al.size()-1;i>=0;i--){
            ans = Math.min(ans, max.poll() - al.get(i));
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int arr[]  = {5,1,15,6,13,14,4,16};
		MinAndMaxDiffInThreeMoves obj = new MinAndMaxDiffInThreeMoves();
		obj.minDifference1(arr);
	}
}
