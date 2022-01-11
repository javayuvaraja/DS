package com.yuva.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. Brick Wall

There is a rectangular brick wall in front of you with n rows of bricks. 
The ith row has some number of bricks each of the same height (i.e., one unit) but they can be of different widths.
The total width of each row is the same.

Draw a vertical line from the top to the bottom and cross the least bricks. 
If your line goes through the edge of a brick, then the brick is not considered as crossed. 
You cannot draw a line just along one of the two vertical edges of the wall, 
in which case the line will obviously cross no bricks.

Given the 2D array wall that contains the information about the wall, 
return the minimum number of crossed bricks after drawing such a vertical line.
 * @author Yuvaraja Kanagarajan
 *
 */
public class BrickWall {

	public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int currMax = 0;
        
        for (List<Integer> bricks : wall) {
            int sum = 0;
            for (int i =0; i < bricks.size()-1; i++) { // ignoring the last one
                sum = sum + bricks.get(i);
                int count = sumMap.getOrDefault(sum, 0)+1;
                currMax = Math.max(count, currMax);
	            sumMap.put(sum, count);
            }
        }
        return wall.size()-currMax;        
    }
	
	public static void main(String[] args) {
		BrickWall obj = new BrickWall();
		List<List<Integer>> wall = new ArrayList<List<Integer>>();
		wall.add(Arrays.asList(1,2,2,1));
		wall.add(Arrays.asList(3,1,2));
		wall.add(Arrays.asList(1,3,2));
		wall.add(Arrays.asList(2,4));
		wall.add(Arrays.asList(3,1,2));
		wall.add(Arrays.asList(1,3,1,1));
		
		System.out.println(obj.leastBricks(wall));
				
	}
}
