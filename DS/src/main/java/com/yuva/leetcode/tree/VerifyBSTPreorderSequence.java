package com.yuva.leetcode.tree;

import java.util.Stack;

/**
 *  Leetcode 255. Verify Preorder Sequence in Binary Search Tree
 *  
 * @author Yuvaraja Kanagarajan
 *
 */
public class VerifyBSTPreorderSequence {

	public boolean verifyPreorder(int[] preorder) {
		Stack<Integer> stack  = new Stack<>();
		int currMin = Integer.MIN_VALUE;
		for (int num : preorder) {
			if (num < currMin) { // right subtree has the min value than the root
				return false;
			}
			// if the current value is greater than the top of the stack, 
			//then this root will be in right subtree. assign the top value as the root 
			//for checking the right subtree node shoud be greater than the root (currMin)
			while (!stack.isEmpty() && num > stack.peek()) { 
				currMin = stack.pop();				
			}
			stack.push(num);
		}
		return true;
	}
}
