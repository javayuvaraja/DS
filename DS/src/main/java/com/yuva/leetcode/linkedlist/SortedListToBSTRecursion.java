package com.yuva.leetcode.linkedlist;

import com.yuva.leetcode.tree.TreeNode;

public class SortedListToBSTRecursion {

	public ListNode headNode = null;
    public TreeNode sortedListToBST(ListNode head) {
        int size = size(head);
        headNode = head;
        return createBst(size);
    }
    
    public TreeNode createBst (int n) {
        if (n==0) {
            return null;
        }
        
        TreeNode left = createBst(n/2);
        TreeNode root = new TreeNode (headNode.val);
        headNode = headNode.next;
        root.left = left;
        TreeNode right = createBst(n-n/2-1);
        root.right = right;
        return root;
    }
    
    
    public int size(ListNode head){
        int count = 0;
        ListNode curr = head;
        while (curr!=null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
