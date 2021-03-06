package com.yuva.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxPointsOnLine {
	
	 public int maxPoints(int[][] points) {
		 
		 int length = points.length;
		 if (length<2) {
			 return length;
		 }
		 Set<String> pointsSet = new HashSet<>();
		 
		 int max = 1;
		 
		 for (int i =0; i < length; i++) {
			 int point[]= points[i];
			 String pointStr = point[0]+"-"+point[1];
			 if (pointsSet.contains(pointStr)) {
				 continue;
			 }
	
			 int currMax = 1;
			 int sameCount =0;
			 Map<Double, Integer> slopeMap = new HashMap<Double, Integer>();
			 for(int j=i+1; j < length; j++ ) {
				 if (isSame (point, points[j])) {
					 sameCount++;
					 continue;
				 }
				 
				 double slope = getSlope(point, points[j]);
				 slopeMap.put(slope, slopeMap.getOrDefault(slope, 1)+1);
				 currMax = Math.max(currMax, slopeMap.get(slope));
			 }
			 pointsSet.add(pointStr);
			 max = Math.max(max, currMax+sameCount);
			 
		 }
		 return  max;		
	 }
	 
	 private boolean isSame (int point1[], int point2[]) {
		 return point1[0] == point2[0] &&
				point1[1] == point2[1]; 
	 }
	 
	 private double getSlope (int point1[], int point2[]) {
		 if (point1[0]==point2[0]) {
			 return Integer.MAX_VALUE;
		 } 
		 if (point1[1]==point2[1]) {
			 return 0;
		 }
		 
		 return (double)(point1[0]-point2[0]) / (double) (point1[1]-point2[1]);
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
