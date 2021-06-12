package com.yuva.leetcode.general;

import java.util.Arrays;

/**
 * Google Question
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class CustomSorter {

	public static String[] customSorter(String[] input) {
		Arrays.sort(input,
				(a, b) -> (!isStartsWithCh(a) && !isStartsWithCh(b)  // both are not starting with ch
						  || isStartsWithCh(a) && isStartsWithCh(b)) ? a.compareTo(b) // both are starting with ch
								: a.substring(0, 2).equals("ch") ? (b.charAt(0) - 'i') < 0 ? 1 : -1
										: (a.charAt(0) - 'i') < 0 ? -1 : 1);
		return input;
	}
	
	private static boolean isStartsWithCh(String str) {
		return str.substring(0, 2).equals("ch");
	}
	
	public static void main(String[] args) {
		String []input = {"indichgo", "charisma", "hotchst", "hotchechs",  "hochat", "hotchecha"};
		String result[] =  customSorter(input);
		for (String temp : result ) {
			System.out.print(temp + " ");
		}
	}
}
