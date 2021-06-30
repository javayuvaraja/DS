package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class DiameterOfNaryTree {

	class Node {
	    public int val;
	    public List<Node> children;

	    
	    public Node() {
	        children = new ArrayList<Node>();
	    }
	    
	    public Node(int _val) {
	        val = _val;
	        children = new ArrayList<Node>();
	    }
	    
	    public Node(int _val,ArrayList<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	
	int res = 0;
    public int diameter(Node root) {
        getHeight(root);
        return res;
    }
    
    public int getHeight(Node root) {
        if(root == null)
            return 0;
        
        int max1 = 0;
        int max2 = 0;
        for(Node child : root.children) {
            int height = getHeight(child);
            if(height > max1) {
                max2 = max1;
                max1 = height;
            }
            else if(height > max2) {
                max2 = height;
            }
        }
        
        res = Math.max(res, max1+max2);
        return max1+1;
    }
}
