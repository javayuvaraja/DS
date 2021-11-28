package com.yuva.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class PrintStaircaseCombination {
	
	static int n = 4;

	public static void printCombination(List<Integer> result, int sum) {
		if (sum==0) {
			System.out.println(result);
			return;
		} else if (sum > 0) {
			
			for (int i =1; i <= n; i++) {
				result.add(i);
				printCombination(result, sum-i);
				result.remove(result.size()-1);
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		List<Integer> result = new ArrayList<>();
		printCombination(result, 4);
	}
	
}
