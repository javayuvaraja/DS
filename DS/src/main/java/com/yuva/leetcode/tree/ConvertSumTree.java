package com.yuva.leetcode.tree;


/**
 *  The following tree

                  10
               /      \
             -2        6
           /   \      /  \ 
         8     -4    7    5


should be changed to


                 20(4-2+12+6)
               /      \
         4(8-4)      12(7+5)
           /   \      /  \ 
         0      0    0    0
 * @author Yuvaraja Kanagarajan
 *
 */
public class ConvertSumTree {

	public static int convertToSumTree(TreeNode root)
    {
        // base case: empty tree
        if (root == null) {
            return 0;
        }
 
        // recursively convert the left and right subtree first before
        // processing the root node
        int left = convertToSumTree(root.left);
        int right = convertToSumTree(root.right);
 
        // stores the current value of the root node
        int currVal = root.val;
 
        // update root to the sum of left and right subtree
        root.val = left + right;
 
        // return the updated value + the old value (sum of the tree rooted at
        // the root node)
        return root.val + currVal;
    }
}
