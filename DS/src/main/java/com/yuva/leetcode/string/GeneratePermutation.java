package com.yuva.leetcode.string;

public class GeneratePermutation {

	public void permute(String str, int start, int end)
    {
        if (start == end) {
            System.out.println(str);
        } else {
            for (int i = start; i <= end; i++)
            {
                str = swap(str,start,i);
                permute(str, start+1, end);
                str = swap(str,start,i);
            }
        }
    }
	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i] ;
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
	public static void main(String[] args) {
		String str = "abcd";
		GeneratePermutation obj = new GeneratePermutation();
		obj.permute(str, 0, str.length()-1);
		
	}
}
