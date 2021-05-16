package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


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

}
