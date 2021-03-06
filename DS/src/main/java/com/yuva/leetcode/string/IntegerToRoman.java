package com.yuva.leetcode.string;

/**
 * Leetcode 12 : Integer to Roman
 * @author Yuvaraja Kanagarajan
 *
 */
public class IntegerToRoman {

	public String intToRoman(int num) {
		String[] romans = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] numbers = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		StringBuilder romanRes = new StringBuilder();

		for (int i = 0; i < numbers.length; i++) {
			int temp = num / numbers[i];
			while (temp > 0) {
				romanRes.append(romans[i]);
				temp--;
			}
			num = num % numbers[i];
		}
		return romanRes.toString();

	}

}
