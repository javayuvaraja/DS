package com.yuva.leetcode.general;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
        int prefixLength =0 ;
        int currIndex =0;
        if (strs.length==0){
            return "";
        }
        int minLength = findMin(strs);
        if (minLength==0) {
            return "";
        }
        while (currIndex < minLength && isSame(strs,currIndex++)){
            prefixLength++;
        }
        return strs[0].substring(0, prefixLength);
    }
    
    private int findMin(String[] str) {
        int min = Integer.MAX_VALUE;
        for (String temp : str) {
            if (temp.length() < min ) {
                min = temp.length();
            }
        }
        return min;
    }
    
    private boolean isSame (String[] str, int index){
        char currChar = str[0].charAt(index);
        boolean isSame = true;
        for (String temp :str){
            if (temp.charAt(index)!=currChar){
                isSame = false;
                break;
            }
        }
        return isSame;
    }
}
