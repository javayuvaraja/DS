package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**

Given a Binary tree and a sum S, print all the paths, starting from root, that sums upto the given sum.
Note that this problem is different from root to leaf paths. Here path doesn’t need to end on a leaf node.

Examples:  

Input : 
Input : sum = 8, 
        Root of tree
         1
       /   \
     20      3
           /    \
         4       15    
        /  \     /  \
       6    7   8    9           
Output :
Path: 1 3 4

Input : sum = 38,
        Root of tree
          10
       /     \
     28       13
           /     \
         14       15
        /   \     /  \
       21   22   23   24
Output : Path found: 10 28 
        Path found: 10 13 15
 * @author Yuvaraja Kanagarajan
 *
 */
public class PrintPathSum {

	static void printPathsUtil(TreeNode node, int sum, int currSum, List<Integer> currList, 
			List<List<Integer>> result) {
		if (node == null)
			return;

		// Add the current node's value
		currSum += node.val;

		// Add the value to path
		currList.add(node.val);

		// Print the required path
		if (currSum == sum) {
			result.add(new ArrayList<Integer>(currList));
		}

		// If left child exists
		if (node.left != null)
			printPathsUtil(node.left, sum, currSum, currList, result);
		
		// If right child exists
		if (node.right != null)
			printPathsUtil(node.right, sum, currSum, currList, result);

		// Remove last element from path
		// and move back to parent
		currList.remove(currList.size() - 1);
	}
	
	static void printPaths(TreeNode root, int sum) {
	    List<List<Integer>> result = new ArrayList<>();
	    printPathsUtil(root, sum, 0, new ArrayList<Integer>(), result);
	    
	    for (List<Integer> curr : result) {
	    	System.out.println(curr);
	    }
	}
	
	public static void main(String[] args)
	{
	      
	    /*    10 
	       /     \ 
	     28       13 
	           /     \ 
	         14       15 
	        /   \     /  \ 
	       21   22   23   24*/
	    TreeNode root = new TreeNode(10);
	    root.left = new TreeNode(28);
	    root.right = new TreeNode(13);
	  
	    root.right.left = new TreeNode(14);
	    root.right.right = new TreeNode(15);
	  
	    root.right.left.left = new TreeNode(21);
	    root.right.left.right = new TreeNode(22);
	    root.right.right.left = new TreeNode(23);
	    root.right.right.right = new TreeNode(24);
	  
	    int sum = 38;
	  
	    printPaths(root, sum);
	}

}
