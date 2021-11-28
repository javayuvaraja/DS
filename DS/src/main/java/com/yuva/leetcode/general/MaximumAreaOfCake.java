package com.yuva.leetcode.general;

import java.util.Arrays;

/**
1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts

You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:

horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, 
and verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position 
provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a large number, 
return this modulo 109 + 7.

 

Example 1:


Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
Output: 4 
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece of cake has the maximum area.
 * @author Yuvaraja Kanagarajan
 *
 */
public class MaximumAreaOfCake {

	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxHeight = 0;
        int maxWidth = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        for (int i = 0; i < horizontalCuts.length; i++) {
            maxHeight = Math.max(maxHeight, 
            					i == 0 ? horizontalCuts[i] : horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxHeight = Math.max(maxHeight, h - horizontalCuts[horizontalCuts.length - 1]);
        
        for (int i = 0; i < verticalCuts.length; i++) {
            maxWidth = Math.max(maxWidth, i == 0 ? verticalCuts[i] : verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxWidth = Math.max(maxWidth, w - verticalCuts[verticalCuts.length - 1]);
        return (int)(maxHeight % (1e9 + 7) * maxWidth % (1e9 + 7));
    }
}
