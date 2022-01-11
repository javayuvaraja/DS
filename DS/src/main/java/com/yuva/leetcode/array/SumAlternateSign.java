package com.yuva.leetcode.array;

/**
 * 
 * Given a non-negative integer (atmost 10 digits), find the sum of digits with alternating signs.
Example - for 53178, output = 5 - 3 + 1 - 7 + 8 = 4
for 1234567, output = 1 - 2 + 3 - 4 + 5 - 6 + 7 = 4
for 182, output = 1 - 8 + 2 = -5
 * @author Yuvaraja Kanagarajan
 *
 */
public class SumAlternateSign {

	
	public static int findSum(int num) {
		
		String strNum = String.valueOf(num);
		char []chArr = strNum.toCharArray();
		int result = chArr[0]-48;
		int sign = -1;
		for (int i=1; i< chArr.length; i++) {
			result += (sign* (chArr[i]-48));
			sign *= -1;
		}
		return result;
		
		
	}
	public static void main(String[] args) {
		
		int num = 182;
		System.out.println(findSum(num));
	}
	
}
