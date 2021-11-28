package com.yuva.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class GrasshopperProbability {


    public TreeNode assignedProbabilityTree(TreeNode root) {
        if(root == null)
            return null;
        traverseTree(root, 1.0);
        return root;
    }

    private void traverseTree(TreeNode root, double probability) {
        if(root == null)
            return;
        root.probability = probability;
        if(root.children.size() == 0)
            return;
        int size = root.children.size();
        double newProbability = 1.0 / size;
        for(int i = 0; i < size; i++) {
            traverseTree(root.children.get(i), newProbability*probability);
        }
    }
}
class TreeNode {
    int value;
    List<TreeNode> children = new ArrayList<>();
    double probability;
    public TreeNode(int value) {
        this.value = value;
    }
}