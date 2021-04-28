package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * This program can be used for root to leaf path or
 * leaf to root path.
 * If leaf to root then we have to iterate in the reverse order.
 * @author Yuvaraja Kanagarajan
 *
 */
public class PrintRootToLeafPath {

	public static List<List<Integer>> printRootToLeaf(TreeNode node) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		findPathToLeaf(node, new ArrayList<Integer>(), result);
		return result;
	}
	
	public static void findPathToLeaf(TreeNode node, List<Integer> currList, List<List<Integer>> result) {
		if (node == null) {
			return ;
		}
		currList.add(node.val);
		if (node.left==null && node.right==null) {
			result.add(new ArrayList<Integer>(currList));
		}
		
		findPathToLeaf(node.left, currList, result);
		findPathToLeaf(node.right, currList, result);
		currList.remove(currList.size()-1);
	}
	
	public static void main(String[] args)
    {
        /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
                   /     \
                  8       9
        */
 
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
 
        // print all root-to-leaf paths
        List<List<Integer>> result = printRootToLeaf(root);
        
        for (List<Integer> curr : result) {
        	curr.stream().forEach(e->System.out.print( e + " "));
        	System.out.println();
        }
    }
	
}
