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
}
