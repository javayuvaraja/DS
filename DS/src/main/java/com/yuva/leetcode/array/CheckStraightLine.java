package com.yuva.leetcode.array;

/**
 *  You are given an array coordinates, coordinates[i] = [x, y], where [x, y]
 *  represents the coordinate of a point. 
 *  Check if these points make a straight line in the XY plane.
 *  
 *  Leetcode 1232
 *  
 * @author Yuvaraja Kanagarajan
 *
 */
public class CheckStraightLine {
	/**
	 * Logic :
	       Find slope from point 1 and point 2
    	   compare the slopes of all other points with the original slope
   
    	Slope of points (x1, y1) and (x2, y2) is:
     	(y2 - y1) / (x2 - x1)
    
     	Slope of points (x1, y1) and (x3, y3) is:
     	(y3 - y1) / (x3 - x1)
    
     	for all three points to be on the same line, the slopes should be equal, in other words:
     	(x3 - x1)*(y2 - y1) = (y3 - y1)*(x2 - x1)
    
    
     */
    public boolean checkStraightLine(int[][] arr) {
        if(arr == null || arr[0].length == 0) return false;
        if (arr.length == 2) {
        	return true;
        }
        int[] point1 = arr[0];
        int[] point2 = arr[1];
        
        for(int i = 2; i < arr.length; i++) {
            int[] curr = arr[i];
            
            if((curr[0] - point1[0]) * (point2[1] - point1[1]) != 
               (curr[1] - point1[1]) * (point2[0] - point1[0])) {
            	return false;
            }
        }
        
        return true;
    }
	
}
