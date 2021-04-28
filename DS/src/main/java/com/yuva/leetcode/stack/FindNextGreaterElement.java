package com.yuva.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class FindNextGreaterElement {

	// Find the next greater element for every array element
	public static int[] findNextGreaterElements(int[] arr) {
		int[] result = new int[arr.length];
		Arrays.fill(result, -1);

		// create an empty stack
		Stack<Integer> s = new Stack<>();

		// do for each element
		for (int i = 0; i < arr.length; i++) {
			// loop till we have a greater element on top or stack becomes empty.

			// Keep popping elements from the stack smaller than the current
			// element, and set their next greater element to the current element

			while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
				result[s.pop()] = arr[i];
			}

			// push current "index" into the stack
			s.push(i);
		}

		return result;
	}
}
