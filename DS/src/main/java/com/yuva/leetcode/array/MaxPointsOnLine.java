package com.yuva.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/max-points-on-a-line/
 * 
 * Given an array of points where points[i] = [xi, yi] represents
 * a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

 
 * @author Yuvaraja Kanagarajan
 *
 */
public class MaxPointsOnLine {
	
	 static int X = 0;
	 static int Y= 1;
	 public int maxPoints(int[][] points) {
		 
		 int length = points.length;
		 if (length<2) {
			 return length;
		 }
		 Set<String> pointsSet = new HashSet<>();
		 
		 int max = 1;
		 
		 for (int i =0; i < length; i++) {
			 int point[]= points[i];
			 String pointStr = point[X]+"-"+point[Y];
			 
			 // for handling the duplicate points
			 if (pointsSet.contains(pointStr)) {
				 continue;
			 }
	
			 int currMax = 1;
			 int sameCount =0;
			 
			 Map<Double, Integer> slopeMap = new HashMap<Double, Integer>();
			 for(int j=i+1; j < length; j++ ) {
				 // check same points count
				 if (isSame (point, points[j])) {
					 sameCount++;
					 continue;
				 }
				 // get slope and store it to map
				 double slope = getSlope(point, points[j]);
				 slopeMap.put(slope, slopeMap.getOrDefault(slope, 1)+1);
				 currMax = Math.max(currMax, slopeMap.get(slope));
			 }
			 pointsSet.add(pointStr);
			 // check whether slope count is more or same point count
			 
			 max = Math.max(max, currMax+sameCount);
			 
		 }
		 return  max;		
	 }
	 
	 private boolean isSame (int point1[], int point2[]) {
		 
		 return point1[X] == point2[X] &&
				point1[Y] == point2[Y]; 
	 }
	 
	 private double getSlope (int point1[], int point2[]) {
		 
		 
		 if (point1[X]==point2[X]) {
			 return Integer.MAX_VALUE;
		 } 
		 if (point1[Y]==point2[Y]) {
			 return 0;
		 }
		 
		 return (double)(point1[X]-point2[X]) / (double) (point1[Y]-point2[Y]);
	 }
	 
	 public static void main(String[] args) {
		int points[][] = {
				//{1,1} ,{3,2},{5,3},{4,1},{2,3},{1,4}
				{1,1} ,{1,1},{2,3}
		};
		//[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
		MaxPointsOnLine obj = new MaxPointsOnLine();
		System.out.println(obj.maxPoints(points));
		
	}
}
