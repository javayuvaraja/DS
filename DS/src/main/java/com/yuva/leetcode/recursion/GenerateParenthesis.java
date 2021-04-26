package com.yuva.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
Leetcode : 22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 * @author Yuvaraja Kanagarajan
 *
 */
public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
        
		List<String> result = new ArrayList<>();
		StringBuffer buff = new StringBuffer();
		generate(result, buff, 0, 0, n);
		return result;
    }
	
	
	public void generate (List<String> result, StringBuffer buff, int open, int close, int n) {
		if (close == n) {
			result.add(buff.toString());
			return;
		}
		if (open < n ) {
			buff.append("(");
			generate(result, buff, open+1, close, n);
			buff.setLength(buff.length()-1);
		} 
		
		if (close < open) {
			buff.append(")");
			generate(result, buff, open, close+1, n);
			buff.setLength(buff.length()-1);
		}
		
	}
	
	public static void main(String[] args) {
		GenerateParenthesis obj = new GenerateParenthesis();
		List<String> result = obj.generateParenthesis(3);
		
		result.stream().forEach(e-> System.out.println(e + " "));
	}
}
