package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Karat
 * Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. 
 * The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique positive integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

1   2    4   15
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7    11
Sample input/output (pseudodata):

parentChildPairs = [ (1, 3), (2, 3), (3, 6), (5, 6), (15, 9), (5, 7), (4, 5), (4, 8), (4, 9), (9, 11) ]

Write a function that takes this data as input and returns two collections: one containing all individuals 
with zero known parents, and one containing all individuals with exactly one known parent.
 * @author Yuvaraja Kanagarajan
 *
 */
public class SingleParentOrNoParent {

	static List<List<Integer>> findNodesWithZeroAndOneParents(int[][] parentChildPairs) {
	    Set<Integer> zeroParentNodes = new HashSet<>();
	    Set<Integer> oneParentNodes = new HashSet<>();
	    Set<Integer> extraParentNodes = new HashSet<>();

	    for (int[] parentChild : parentChildPairs) {
	        int parent = parentChild[0];
	        int child = parentChild[1];

	        if (!oneParentNodes.contains(parent) && !extraParentNodes.contains(parent)) {
	            zeroParentNodes.add(parent);
	        }

	        if (zeroParentNodes.contains(child)) {
	            zeroParentNodes.remove(child);
	            oneParentNodes.add(child);
	        } else if (oneParentNodes.contains(child)) {
	            oneParentNodes.remove(child);
	            extraParentNodes.add(child);
	        } else {
	            oneParentNodes.add(child);
	        }
	    }

	    return List.of(new ArrayList<>(zeroParentNodes), new ArrayList<>(oneParentNodes));
	}
}
