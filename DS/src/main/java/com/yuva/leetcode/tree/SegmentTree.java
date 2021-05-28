package com.yuva.leetcode.tree;

/**
 * This segment tree find the min of given range
 * @return
 */
public class SegmentTree {
	
	public void constructTree (int input[], int []segmentTree , int start, int end, int pos) {
		if (start==end) {
			segmentTree[pos] = input[start];
			return;
		}
		int mid = (start+end) / 2;
		constructTree(input, segmentTree, start, mid, pos);
		constructTree(input, segmentTree, mid+1, end, pos);
		segmentTree[pos] = Math.min(segmentTree[2*pos+1], segmentTree[2*pos+2]);		
	}
	
	public int rangeQuery(int[] segmentTree, int start, int end, 
			int queryStart, int queryEnd, int pos) {
		 if (queryStart > end || queryEnd < start) { // no overlap
			 return Integer.MAX_VALUE;
		 } 
		 if (queryStart <= start && queryEnd <=end ) { // total overlap
			 return segmentTree[pos];
		 }
		 
		 int mid = (start+end)/2;
		 
		 return Math.min(rangeQuery(segmentTree, start, mid, queryStart, queryEnd, 2*pos+1), 
				         rangeQuery(segmentTree, mid+1, end, queryStart, queryEnd, 2*pos+2));
			 
	}
	
	
	// The function to update a value in input array and segment tree.
	// It uses updateValueUtil() to update the value in segment tree
	void updateValue(int segmentTree[],int arr[], int index, int newVal) {
		// Check for erroneous input index
		if (index < 0 || index > arr.length - 1) {
			System.out.println("Invalid Input");
			return;
		}

		int diff = newVal - arr[index];
		arr[index] = newVal;
		updateValueUtil(segmentTree, 0, arr.length-1, index, diff, 0);
	}
	
	void updateValueUtil(int [] st, int start, int end, int index, int diff, int pos) {
		// Base Case: If the input index lies outside the range of
		// this segment
		if (index < start || index > end)
			return;

		// If the input index is in range of this node, then update the
		// value of the node and its children
		st[pos] = st[pos] + diff;
		if (end != start) {
			int mid = (start + end) /2 ;
			updateValueUtil(st, start, mid, index, diff, 2 * pos + 1);
			updateValueUtil(st, mid + 1, end, index, diff, 2 * pos + 2);
		}
	}
	public static void main(String[] args) {
		
	}
}
