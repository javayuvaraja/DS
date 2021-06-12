package com.yuva.leetcode.divideandconquer;


/**
 * 1274. Number of Ships in a Rectangle

Each ship is located at an integer point on the sea represented by a cartesian plane, 
and each integer point may contain at most 1 ship.

You have a function Sea.hasShips(topRight, bottomLeft) which takes two points as arguments 
and returns true If there is at least one ship in the rectangle represented by the two points, including on the boundary.

Given two points: the top right and bottom left corners of a rectangle, return the number of ships present in that rectangle. 
It is guaranteed that there are at most 10 ships in that rectangle.

Submissions making more than 400 calls to hasShips will be judged Wrong Answer. 
Also, any solutions that attempt to circumvent the judge will result in disqualification.

 * @author Yuvaraja Kanagarajan
 *
 */
public class ShipsInRectangle {
	
	interface Sea {
		public boolean hasShips(int[] topRight, int[] bottomLeft);
	}
	
	/**
	 * Divide the current rectangle into 4 pieces in the middle.
	   Base case: when topRight == bottomLeft, meaning our rectangle reduces into a point in the map. 
	   We return 1 if hasShips(topRight, bottomLeft)

	  Time complexity: O(n) where n is total number of points inside the rectangle
	  T(n) = 4xT(n/4) + O(1)

	 * @param sea
	 * @param topRight
	 * @param bottomLeft
	 * @return
	 */
	
	public static int X=0;
	public static int Y=1;
	public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
		if (!sea.hasShips(topRight, bottomLeft))  // corner case : rectangle doesn't have any ships
			return 0;
		if (topRight[X] == bottomLeft[X] && topRight[Y] == bottomLeft[Y]) // Line 
			return 1;
		
		int midX = (topRight[X] + bottomLeft[X]) / 2;
		int midY = (topRight[Y] + bottomLeft[Y]) / 2;
		return countShips(sea, new int[] { midX, midY }, bottomLeft) // Bottom left quarter
				+ countShips(sea, topRight, new int[] { midX + 1, midY + 1 }) // top right quarter
				+ countShips(sea, new int[] { midX, topRight[Y] }, new int[] { bottomLeft[X], midY + 1 }) // top left corner
				+ countShips(sea, new int[] { topRight[X], midY }, new int[] { midX + 1, bottomLeft[Y] }); // bottom right corner
	}
}
 