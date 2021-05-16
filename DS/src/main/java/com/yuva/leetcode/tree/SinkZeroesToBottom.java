package com.yuva.leetcode.tree;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Given a binary tree containing many zero nodes, sink nodes having zero value to the bottom of the sub-tree rooted at that node.
 *  In other words, the output binary tree should not contain any node having zero value that is parent of node having non-zero value.
 * @author Yuvaraja Kanagarajan
 *
 */
public class SinkZeroesToBottom {
	
	public static void main(String[] args) {
        new SinkZeroesToBottom().test();
    }

    private void test() {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(0);
        node.right.right = new TreeNode(2);
        node.right.left = new TreeNode(0);
        node.right.left.left = new TreeNode(3);
        node.right.left.right = new TreeNode(4);
        TreeUtils.printPostOrder(node);
        System.out.println();
        sinkZeroesInBinaryTree(node);
        TreeUtils.printPostOrder(node);
    }


    /*
     * Logic : post order traversal and store the zero count and non zero values
     */
    public void sinkZeroesInBinaryTree(TreeNode node) {
        Stack<Integer> nonZeroStack = new Stack<>();
        AtomicInteger zeroCount = new AtomicInteger(0);
        dfs(node, nonZeroStack, zeroCount);
    }

    private void dfs(TreeNode node, Stack<Integer> nonZeroStack, AtomicInteger zeroCount) {
        if (node == null) {
            return;
        }

        if (node.val == 0) {
            zeroCount.getAndIncrement();
        } else {
            nonZeroStack.push(node.val);
        }

        dfs(node.left, nonZeroStack, zeroCount);
        dfs(node.right, nonZeroStack, zeroCount);

        if (zeroCount.intValue() > 0) {
            node.val = 0;
            zeroCount.getAndDecrement();            
        } else {
            node.val = nonZeroStack.pop();
        }
    }

}
