package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 254 - Factor Combinations
 * 
 * Numbers can be regarded as product of its factors. For example,
	8 = 2 x 2 x 2;
  	  = 2 x 4.
	Write a function that takes an integer n and return all possible combinations of its factors.
	Note:
	Each combination’s factors must be sorted ascending, 
	for example: The factors of 2 and 6 is [2, 6], not [6, 2].
	
	input: 12
output:
  [
    [2, 6],
    [2, 2, 3],
    [3, 4]
  ]  
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
 * @author Yuvaraja Kanagarajan
 *
 */
public class FactorCombination {

	public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>> ();
        helper(ret, new ArrayList<Integer> (), n, 2);
        return ret;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> item, int n, int start) {
        if (n == 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<Integer> (item));
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n/i, i);
                item.remove(item.size()-1);
            }
        }
    }

    private void getFactors(List<List<Integer>> result, List<Integer> item, int n, int start) {
        for (int i = start; i <= Math.sqrt(n); i++) {
            if (n % i == 0 && n / i >= i) { // second condition for avoiding the existing 
                item.add(i);
                item.add(n / i);
                result.add(new ArrayList<>(item));
                item.remove(item.size() - 1);
                getFactors(result, item, n / i, i);
                item.remove(item.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
    	int n = 12;
    	FactorCombination obj = new FactorCombination();
    	obj.getFactors(n).stream().forEach(e-> System.out.print( e + " "));
	}
}
