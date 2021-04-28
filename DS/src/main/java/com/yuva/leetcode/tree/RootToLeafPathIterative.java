package com.yuva.leetcode.tree;

import java.util.HashMap;
import java.util.Stack;


public class RootToLeafPathIterative {

	/* Function to print root to leaf path for a leaf 
    using parent nodes stored in map */
    public static void printTopToBottomPath(TreeNode curr, 
    		HashMap<TreeNode,TreeNode> parent) { 
        Stack<TreeNode> stk=new Stack<>() ;
        while (curr!=null) { 
            stk.push(curr); 
            curr = parent.get(curr); 
        } 
    
        // Start popping nodes from stack and print them 
        while (!stk.isEmpty()) { 
            curr = stk.pop(); 
            System.out.print(curr.val+" ");
        } 
        System.out.println();
    } 
  
  
    /* An iterative function to do preorder traversal 
    of binary tree  and print root to leaf path 
    without using recursion */
    public static void printRootToLeaf(TreeNode root) 
    { 
        // Corner Case 
        if (root == null) {
            return; 
        }
        
        // Create an empty stack and push root to it 
        Stack<TreeNode> nodeStack=new Stack<>();
        nodeStack.push(root); 
    
        // Create a map to store parent pointers of binary 
        // tree nodes 
        HashMap<TreeNode,TreeNode> parent=new HashMap<>();
        parent.put(root,null); 
    
        while (!nodeStack.isEmpty()) { 
            // Pop the top item from stack 
            TreeNode current = nodeStack.pop(); 
    
            // If leaf node encountered, print Top To 
            // Bottom path 
            if (current.left==null && current.right==null) 
                printTopToBottomPath(current, parent); 
    
			if (current.right != null) {
				parent.put(current.right, current);
				nodeStack.push(current.right);
			}
			if (current.left != null) {
				parent.put(current.left, current);
				nodeStack.push(current.left);
			} 
        } 
    }
}
