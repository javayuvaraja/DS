package com.yuva.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows == 0) {
			return result;
		}
		List<Integer> currLevel = new ArrayList<>();
		currLevel.add(1);
		result.add(currLevel);

		for (int row = 2; row <= numRows; row++) {
			currLevel = new ArrayList<>();
			currLevel.add(1);
			List<Integer> prevLevel = result.get(result.size() - 1);
			for (int i = 1; i < prevLevel.size(); i++) {
				currLevel.add(prevLevel.get(i) + prevLevel.get(i - 1));
			}
			currLevel.add(1);
			result.add(currLevel);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int rows =5;
		PascalTriangle obj = new PascalTriangle();
		List<List<Integer>> result = obj.generate(rows);
		for (List<Integer> currLevel  : result) {
			for (int temp : currLevel) {
				System.out.print(temp + " ");
			}
			System.out.println();
		}
	}
}
