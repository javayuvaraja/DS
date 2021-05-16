package com.yuva.leetcode.array;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * Facebook Question
 * Given an array of n elements, where each element is at most k away from its target position, 
 * devise an algorithm that sorts in O(n log k) time. 
 * For example, let us consider k is 2, 
 * an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.
 * 
 *  Ex : arr[] = {6, 5, 3, 2, 8, 10, 9}
         k = 3 
         Output : arr[] = {2, 3, 5, 6, 8, 9, 10}
         
         Input : arr[] = {10, 9, 8, 7, 4, 70, 60, 50}
         k = 4
		 Output : arr[] = {4, 7, 8, 9, 10, 50, 60, 70}
 * @author Yuvaraja Kanagarajan
 *
 */
public class SortKSortedArray {

	/*
	 * Logic 
	 * 1. Create a Min Heap of size k+1 with first k+1 elements. This will take O(k) time.
	 * 2. One by one remove min element from heap, put it in result array, 
       3. Add a new element to heap from remaining elements.
	   
	   Removing an element and adding a new element to min heap will take log k time. 
	   So overall complexity will be O(k) + O((n-k) * log(k))
	 */
    public static void sortKSortedArray(List<Integer> list, int k) {
        // create an empty min-heap and insert the first `k+1` elements into it
        
    	PriorityQueue<Integer> pq = new PriorityQueue<>(list.subList(0, k+1));
 
    	int index = 0;
 
        // do for remaining elements in the array
        for (int i = k + 1; i < list.size(); i++)
        {
            // pop the top element from the min-heap and assign them to the
            // next available array index
            list.set(index++, pq.poll());
 
            // push the next array element into min-heap
            pq.add(list.get(i));
        }
 
        // pop all remaining elements from the min-heap and assign them to the
        // next available array index
        while (!pq.isEmpty()) {
            list.set(index++, pq.poll());
        }
    }
 
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 5, 2, 3, 7, 8, 6, 10, 9);
        int k = 2;
 
        sortKSortedArray(list, k);
        System.out.println(list);
    }
}
