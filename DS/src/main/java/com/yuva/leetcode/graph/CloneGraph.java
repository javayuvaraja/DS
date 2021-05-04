package com.yuva.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {

	public Node cloneGraph(Node node) {
	    if (node == null) return null;

	    Node newNode = new Node(node.val, new ArrayList<>());
	    // store visited nodes
	    // key is the ORIGINAL node, value is the NEW node
	    HashMap<Node, Node> nodeMap = new HashMap<>();
	    // add starting node to HashMap
	    nodeMap.put(node, newNode);

	    // store ORIGINAL nodes to be visited in a queue
	    Queue<Node> queue = new LinkedList<>();
	    // add the start node to the queue
	    queue.add(node);
	    //if more nodes need to be visited
	    while (!queue.isEmpty()) {
	        //search neighbors of top node in the queue
	        Node polledOrigNode = queue.poll();

	        // if node 1 has neighbors 2 and 3
	        for (Node origNeighbor : polledOrigNode.neighbors) {
	            // if the map does not contain the neighbor that means
	            // the node needs to be cloned and added to map
	            // check if map contains 2 then 3
	            if (!nodeMap.containsKey(origNeighbor)) {
	                // if map does not contain 2 or 3 create a clone 2c, 3c
	                Node newNeighborNode = new Node(origNeighbor.val, new ArrayList<>());
	                // add 2,2c to map and 3,3c
	                nodeMap.put(origNeighbor, newNeighborNode);
	                // add 2,3 to queue
	                queue.add(origNeighbor);
	            }
	            // get the cloned node of the original node
	            // add the new neighbor to the cloned nodes neighbor list
	            // get 1c from map to its neighbors, add 2c and 3c
	            nodeMap.get(polledOrigNode).neighbors.add(nodeMap.get(origNeighbor));
	        }
	    }

	    return newNode;
	}
}
