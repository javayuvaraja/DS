package com.yuva.leetcode.general;

import java.util.Stack;

public class BasicCalculatorII {

	public int calculate(String s) {
	    
	    if(s==null || (s.length()==0)) {
	    	return 0;
	    }
	    
	    int len = s.length(); 
	    Stack<Integer> stack = new Stack<Integer>();
	    int num = 0;
	    char sign = '+';
	    
	    for(int i=0; i < len; i++ ){
	        
	    	if(Character.isDigit(s.charAt(i))){
	            num = num*10 + s.charAt(i)-'0';
	        }
	        if((!Character.isDigit(s.charAt(i)) 
	        		&&' '!=s.charAt(i)) || i==len-1){ // for last element
	            if(sign=='-'){
	                stack.push(-num);
	            }
	            if(sign=='+'){
	                stack.push(num);
	            }
	            if(sign=='*'){
	                stack.push(stack.pop()*num);
	            }
	            if(sign=='/'){
	                stack.push(stack.pop()/num);
	            }
	            sign = s.charAt(i);
	            num = 0;
	        }
	    }

	    int result = 0;
	    for(int currNum : stack){
	        result += currNum;
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		String str = "3+2*2";
		BasicCalculatorII obj = new BasicCalculatorII();
		System.out.println(obj.calculate(str));
	}
	
	public int calculate1(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        s = s.trim();
        
        long prevNum = 0;
        int sum = 0;
        char prevOp = '+';
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') continue;
            if(Character.isDigit(c)) {
                int val = c - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    val = val * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                if (prevOp == '+') {
                    sum += prevNum;
                    prevNum = val;
                } else if (prevOp == '-') {
                    sum += prevNum;
                    prevNum = -val;
                } else if (prevOp == '*') {
                    prevNum = prevNum * val;
                } else if (prevOp == '/') {
                    prevNum = prevNum/val;
                }
            } else {
                prevOp = c;
            }
        }
        
        sum += prevNum;
        return sum;
    }
}
