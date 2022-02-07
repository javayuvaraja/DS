package com.yuva.leetcode.stack;

import java.util.Stack;

/**
 * 735. Asteroid Collision

We are given an array asteroids of integers representing asteroids in a row.
For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). 
Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

Example 4:
Input: asteroids = [-2,-1,1,2]
Output: [-2,-1,1,2]
Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same direction never meet, so no asteroids will meet each other.
 
 * @author Yuvaraja Kanagarajan
 *
 */
public class AsteroidCollision {

	/**
	 * Logic : overall, there are totally 4 scenarios will happen: 1.+ + 2.- - 3.+ - 4.- +
		when collision happens: only case is 3 which is + -
		use a stack to keep track of the previous and compare current value with previous ones
	 * @param asteroids
	 * @return
	 */
	public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) {
            return null;
        } else if (asteroids.length <= 1) {
            return asteroids;
        }
        Stack<Integer> stack = new Stack<>();
        for (int cur : asteroids) {
            if (cur > 0) { // previous one does not matter, no collision forever
                stack.push(cur);
            } else {
                while (!stack.isEmpty() 
                		&& stack.peek() > 0 && -cur > stack.peek()) { // previous positive force is less than the negative force so 
                													 // destroy the previous positive one(s) 
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) { // If peak is positive means positive force is higher than the negative force, 
                	                                       // so cant add the current negative.
                										   // If stack empty or peek is negative then add the current negative force. 
                    stack.push(cur);
                } else if (stack.peek() == -cur) { // If current negative force and previous positive force are equal then both will burst.
                    stack.pop();
                }
            }
        }
        
        
        int result[] = new int[stack.size()];
        
        for (int i=stack.size(); i>0; i--) {
        	result[i-1] =  stack.pop();
        }
        return result;
    }
	
	public static void main(String[] args) {
		int arr[] = {10,2};
		AsteroidCollision obj = new AsteroidCollision();
		obj.asteroidCollision(arr);
	}
}
