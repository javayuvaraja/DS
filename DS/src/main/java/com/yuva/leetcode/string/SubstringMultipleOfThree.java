package com.yuva.leetcode.string;

public class SubstringMultipleOfThree {

	private static int findMultipleOfThree(String num) {
		int result = 0;
		boolean isZeroAdded = false;
		for (int len = 1; len <= num.length(); len++) {
			for (int i=0; i <= num.length()-len; i++) {
				if (num.charAt(i)=='0') {
					if (len ==1 && !isZeroAdded) {
						result++;
					}
					continue;
				}
				
				int temp = Integer.parseInt(num.substring(i, i+len));
				if (temp%3==0) {
					result++;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String num = "456";
		System.out.println(findMultipleOfThree(num));
	}
}
