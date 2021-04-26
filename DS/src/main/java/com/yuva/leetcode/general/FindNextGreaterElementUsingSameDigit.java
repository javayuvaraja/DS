package com.yuva.leetcode.general;

import java.util.Arrays;

/**
 * 556. Next Greater Element III
    
   Given a positive integer n, find the smallest integer which has exactly the same digits 
   existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

   Note that the returned integer should fit in 32-bit integer, if there is a valid answer 
   but it does not fit in 32-bit integer, return -1.

 
 * @author Yuvaraja Kanagarajan
 *
 */
public class FindNextGreaterElementUsingSameDigit {
	
	/**
	 * Find the swap Index. 
	 * Find the next greater element than the swap index
	 * Swap the value after that sort the remaining values after the swapindex
	 * @param n
	 * @return
	 */
	public int nextGreaterElement(int n) {
		String str = String.valueOf(n);
		char charArr[]= str.toCharArray();
		int swapIndex= -1;
		for (int i=charArr.length-1; i>0; i--) {
			if (charArr[i-1] < charArr[i]) {
				swapIndex = i-1;
				break;
			}
		}
		
		if (swapIndex==-1) {
			return -1;
		}
		
		int nextMaxIndex = findNextGreaterElementFromRight(charArr, swapIndex);
		char temp = charArr[nextMaxIndex];
		charArr[nextMaxIndex] = charArr[swapIndex];
		charArr[swapIndex] = temp;
		Arrays.sort(charArr, swapIndex+1, charArr.length);
		
		String resultStr = new String(charArr);
		
		if (Long.parseLong(resultStr) > Integer.MAX_VALUE) {
			return -1;
		}
		return Integer.parseInt(resultStr);		
	}
	
	private int findNextGreaterElementFromRight(char []charArr, int swapIndex) {
		int maxIndex = swapIndex+1;
		for (int i= swapIndex+2; i < charArr.length; i++) {
			if (charArr[i] > charArr[swapIndex] && charArr[i] < charArr[maxIndex]) {
				maxIndex =i;
			}
		}
		return maxIndex;
	}
	
	public static void main(String[] args) {
		int n = 438762;
		FindNextGreaterElementUsingSameDigit obj = new FindNextGreaterElementUsingSameDigit();
		System.out.println(obj.nextGreaterElement(n));
	}
}
