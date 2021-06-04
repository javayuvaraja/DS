package com.yuva.leetcode.string;

public class CompressString {

	public int compress(char[] chars) {
        int resultIndex = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[resultIndex++] = currentChar;
            if(count != 1) {
                for(char c : Integer.toString(count).toCharArray()) { 
                    chars[resultIndex++] = c;
                }
            }
        }
        return resultIndex;
    }
    
	public static void main(String[] args) {
    	CompressString obj = new CompressString();
    	char []chars = new char[]{'a','a','b','b','c','c','c'};
    	
    	System.out.println(obj.compress(chars));
    	for (char ch: chars) {
    		System.out.print(ch + " ");
    	}
	}
}
