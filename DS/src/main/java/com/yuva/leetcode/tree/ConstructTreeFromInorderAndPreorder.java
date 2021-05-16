package com.yuva.leetcode.tree;

public class ConstructTreeFromInorderAndPreorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, inorder.length-1, preorder, inorder);
    }
	
	private TreeNode buildTree(int preIndex, int inStart, int inEnd, 
                               int[] preorder, int[] inorder) {
        if (preIndex > preorder.length-1 || inStart > inEnd) {
        	return null;
        }
        
        TreeNode node = new TreeNode(preorder[preIndex]);
        int inOrderIndex = getInOrderIndex(inStart, inEnd, node.val, inorder);
        node.left = buildTree(preIndex+1, inStart, inOrderIndex-1, preorder, inorder);
        int leftCount = inOrderIndex - inStart;
        node.right = buildTree(preIndex+leftCount+1, inOrderIndex+1, inEnd, 
                               preorder, inorder);
        return node;
    }
	
	
	// find the element index in inorder array
	private int getInOrderIndex (int start, int end, int element, int inorder[]) {
		for (int i= start; i <=end; i++) {
			if (inorder[i]==element) {
				return i;
			}
		}
		return -1;
	}
	
}
