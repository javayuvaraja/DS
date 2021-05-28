package com.yuva.leetcode.string;

/**
 * Encode string that has a count after it sees consecutive characters.
For example: aabaacaaa = a2b1a2c1a3
 * @author Yuvaraja Kanagarajan
 *
 */
public class EncodeConsecutiveString {

	public static String encode(String input) {
		StringBuffer buff = new StringBuffer();
		int count = 0;
		char prev = input.charAt(0);
		for (char curr : input.toCharArray()) {
			if (curr == prev) {
				count++;
			} else {
				buff.append(prev).append(count);
				count = 1;
				prev = curr;
			}
		}
		
		if (count>1) { 
			buff.append(prev).append(count); 
		}
		 
		return buff.toString();
	}
	
	public static void main(String[] args) {
		String str = "aabaacaaa";
		System.out.println(encode(str));
	}
}
