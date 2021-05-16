package com.yuva.leetcode.general;

import java.util.Stack;

/**
224. Basic Calculator
 
Given a string s representing an expression, implement a basic calculator to evaluate it.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 * @author Yuvaraja Kanagarajan
 *
 */
public class BasicCalculatorI {

	public int calculate(String s) {
	    Stack<Integer> stack = new Stack<Integer>();
	    int result = 0;
	    int currNumber = 0;
	    int prevOperation = 1;  // Initially assuming plus sign, 1 for add, -1 for substract
	    for(int i = 0; i < s.length(); i++){
	        char currChar = s.charAt(i);
	        if(Character.isDigit(currChar)){
	            currNumber = 10 * currNumber + (int)(currChar - '0');
	        } else if (currChar == '+'){
	            result += (prevOperation * currNumber);
	            currNumber = 0;  // reassign the currNumber is 0
	            prevOperation = 1;
	        }else if(currChar == '-'){
	            result += (prevOperation * currNumber);
	            currNumber = 0;
	            prevOperation = -1;
	        }else if(currChar == '('){
	            //we push the result first, then sign;
	            stack.push(result);
	            stack.push(prevOperation);
	            //reset the sign and result for the value in the parenthesis
	            prevOperation = 1;   
	            result = 0;
	        }else if(currChar == ')'){
	            result += (prevOperation * currNumber);  
	            currNumber = 0;
	            result *= stack.pop();    //stack.pop() is the sign before the parenthesis
	            result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis
	        }
	    }
	    
	    if(currNumber != 0) {
	    	result += prevOperation * currNumber;
	    }
	    return result;
	}
}
