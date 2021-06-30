package com.yuva.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class CarFleetII {

	public double[] getCollisionTimes(int[][] A) {
        int n = A.length;
        Deque<Integer> stack = new LinkedList<>();
        double[] res = new double[n];
        for (int i = n - 1; i >= 0; --i) {
            res[i] = -1.0;
            int currPos = A[i][0];
            int currSpeed = A[i][1];
            while (stack.size() > 0) {
                int j = stack.peekLast(), nextPos = A[j][0], nextSpeed = A[j][1];
                if (currSpeed <= nextSpeed || 1.0 * (nextPos - currPos) / (currSpeed - nextSpeed) >= res[j] && res[j] > 0)
                    stack.pollLast();
                else
                    break;
            }
            if (stack.size() > 0) {
                int j = stack.peekLast(), nextPos = A[j][0], nextSpeed = A[j][1];
                res[i] = 1.0 * (nextPos - currPos) / (currSpeed - nextSpeed);
            }
            stack.add(i);
        }
        return res;
    }
	
	public static void main(String[] args) {
		
	}
}
