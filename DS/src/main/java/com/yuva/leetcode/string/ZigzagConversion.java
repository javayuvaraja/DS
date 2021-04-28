package com.yuva.leetcode.string;

public class ZigzagConversion {
	 public String convert(String s, int numRows) {
		 StringBuilder []sb = new StringBuilder[numRows];
		 
		 for (int i=0 ; i < numRows; i++) {
			 sb[i] = new StringBuilder();
		 }
		 char []charArr = s.toCharArray();
		 int index = 0;
		 while (index < charArr.length) {
			 for (int i=0; i < numRows && index < charArr.length; i++) {
				 sb[i].append(charArr[index++]);
			 }
			 
			 for (int i=numRows-2; i > 0 && index < charArr.length; i--) {
				 sb[i].append(charArr[index++]);
			 }
		 }
		 
		 StringBuilder result = new  StringBuilder();
		 for (StringBuilder temp : sb) {
			 result.append(temp);
		 }
		 
		 return result.toString();
		
	 }
	 
	 public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		int numRows = 3;
		
		ZigzagConversion obj = new ZigzagConversion();
		System.out.println(obj.convert(str, numRows));
	}
}
