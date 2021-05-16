package com.yuva.leetcode.tree;

import java.util.Map;
import java.util.TreeMap;

public class TopViewRecursion {

	TreeMap<Integer, Pair> levelMap = new TreeMap<>();
	public void verticalOrderTraversalRecursive(TreeNode root, int hd, int level){
        if(root == null){
            return;
        }
        putToMap(hd, level, root);
        verticalOrderTraversalRecursive(root.left, hd - 1, level+1);
        verticalOrderTraversalRecursive(root.right, hd + 1, level+1);
    }
	
    private void putToMap(int hd, int level, TreeNode node) {
    	if (levelMap.get(hd) == null) {
    		levelMap.put(hd, new Pair(level, node.val));
        }
        else if (levelMap.get(hd).level > level) {
        	levelMap.put(hd, new Pair(level, node.val));
        }
    }
	
    private void printTopView() {
    	System.out.println("TopView : ");
        for (Map.Entry<Integer, Pair> entry: levelMap.entrySet()){
            System.out.print(entry.getValue() + " ");
        }
    }
    
    static class Pair {
		int level =0;
		int data = 0;
		 Pair(int level, int data) {
			 this.level =level;
			 this.data = data;
		 }
	}
}
