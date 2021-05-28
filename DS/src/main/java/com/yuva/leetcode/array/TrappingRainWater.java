package com.yuva.leetcode.array;

/**
42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining.

 

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
 * @author Yuvaraja Kanagarajan
 *
 */
public class TrappingRainWater {

	public int trap(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int length = height.length;
        int []left = new int [length];
        int []right= new int [length];
        
        left[0] = height[0];
        right[length-1]= height[length-1];
        
        for (int i=1; i < length; i++) {
            left[i] = Math.max (height[i], left[i-1]);            
        }
        
        for (int i=length-2; i >=0 ; i--) {
            right[i] = Math.max (height[i], right[i+1]);            
        }
        
        int saveWater = 0;
        for (int i=0; i < length; i++) {
            saveWater += Math.min(left[i], right[i]) - height[i];
        }
        return saveWater;
    }
}
