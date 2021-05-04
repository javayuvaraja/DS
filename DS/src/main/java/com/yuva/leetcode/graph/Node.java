package com.yuva.leetcode.graph;

import java.util.List;

public class Node {
	public int val;
	public List<Node> neighbors;
	
	Node (int val, List<Node> neighbors) {
		this.val = val;
		this.neighbors = neighbors;
	}
	
	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public List<Node> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Node> neighbors) {
		this.neighbors = neighbors;
	}

}
