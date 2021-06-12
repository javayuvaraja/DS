package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 Leetcode 314 : Vertical order traversal
 
 Given a binary tree, print it vertically. The following example illustrates the vertical order traversal.

           1
        /    \ 
       2      3
      / \   /   \
     4   5  6   7
               /  \ 
              8   9 
               
              
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9
 * @author Yuvaraja Kanagarajan
 *
 */
public class VerticalOrderTraversal {

	static Map<Integer, List<TreeNode>> map = new TreeMap<>();
    public static void verticalOrderTraversalRecursive(TreeNode root, int hd){
        if(root == null){
            return;
        }
        putToMap(hd, root);
        verticalOrderTraversalRecursive(root.left, hd - 1);
        verticalOrderTraversalRecursive(root.right, hd + 1);
    }
    
    private static void putToMap(int hd, TreeNode node) {
        List<TreeNode> nodes = map.getOrDefault(hd, new ArrayList<>());
        nodes.add(node);
        map.put(hd, nodes);
    }
    
    public static void main(String[] args) {
    	 TreeNode root = new TreeNode(5);
         root.left = (new TreeNode(7));
         root.right = (new TreeNode(10));
         root.left.left = (new TreeNode(14));
         root.left.right = (new TreeNode(19));
         root.right.left = (new TreeNode(30));
         root.right.right = (new TreeNode(15));
         root.right.right.left = (new TreeNode(25));
         
         
         VerticalOrderTraversal.verticalOrderTraversalRecursive(root, 0);
         for (Map.Entry<Integer, List<TreeNode>> entry: map.entrySet()){
             System.out.print(entry.getKey() + ": ");
             entry.getValue().forEach(val -> System.out.print(val.val+ " "));
             System.out.println();
         }                
	}
     public List<List<Integer>> verticalTraversal(TreeNode root) {
        verticalOrderTraversalRecursive (root, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<TreeNode>> entry: map.entrySet()){
             List<Integer> list = new ArrayList<>();
             entry.getValue().forEach(val -> list.add(val.val));
             result.add(list);
         }
        return result;
    }
     
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();

		q.add(root);
		cols.add(0);

		int min = 0;
		int max = 0;

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int col = cols.poll();

			if (!map.containsKey(col)) {
				map.put(col, new ArrayList<Integer>());
			}
			map.get(col).add(node.val);

			if (node.left != null) {
				q.add(node.left);
				cols.add(col - 1);
				min = Math.min(min, col - 1);
			}

			if (node.right != null) {
				q.add(node.right);
				cols.add(col + 1);
				max = Math.max(max, col + 1);
			}
		}

		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}

		return res;
	}
}
