package com.yuva.leetcode.general;

/**
 * Leetcode 67. Add Binary

Given two binary strings a and b, return their sum as a binary string.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
 
 * @author Yuvaraja Kanagarajan
 *
 */
public class AddBinary {

	public String addBinary(String a, String b) {
		StringBuffer buff = new StringBuffer();
		int carry = 0;
		int index1 = a.length()-1;
		int index2 = b.length()-1;
		while (index1>=0 || index2>=0) {
			int sum = carry;
			if (index1>=0) {
				sum += a.charAt(index1--) -'0';
			}
			if (index2>=0) {
				sum += b.charAt(index2--) -'0';
			}
			buff.append(sum%2);
			carry = sum/2;
		}
		
		if (carry >0) {
			buff.append(carry);
		}
		return buff.reverse().toString();
	}
	
	public static void main(String[] args) {
		AddBinary obj = new AddBinary();
		String str1 ="1010", str2="1011";
		System.out.println(obj.addBinary(str1, str2));
	}
}
