package com.yuva.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MaxHistogram {

    public int maxHistogram(int input[]){
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < input.length;){
            if(stack.isEmpty() || 
            		input[stack.peekFirst()] <= input[i]){
                stack.offerFirst(i++);
            } else {
                int top = stack.pollFirst();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                //if stack is not empty then everythin from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input[top] * (i - stack.peekFirst() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        
        while(!stack.isEmpty()){
            int top = stack.pollFirst();
            //if stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
            if(stack.isEmpty()){
                area = input[top] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
            else{
                area = input[top] * (i - stack.peekFirst() - 1);
            }
        if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
    
    
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int currIndex = 1; currIndex < height.length; currIndex++) {
            int p = currIndex - 1;

            while (p >= 0 && height[p] >= height[currIndex]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[currIndex] = p;
        }

        for (int currIndex = height.length - 2; currIndex >= 0; currIndex--) {
            int p = currIndex + 1;

            while (p < height.length && height[p] >= height[currIndex]) {
                p = lessFromRight[p];
            }
            lessFromRight[currIndex] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }
    
    public static void main(String args[]){
        MaxHistogram mh = new MaxHistogram();
        //int input[] = {2,2,2,6,1,5,4,2,2,2,2};
        int input[] = {3,1,6,4,5,2};
        int maxArea = mh.maxHistogram(input);
        //System.out.println(maxArea);
        assert maxArea == 12;
        
        System.out.println(largestRectangleArea(input));
    }
}
