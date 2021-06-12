package com.yuva.leetcode.string;

import java.util.Stack;

public class WildcardBinaryString {

	// Recursive function to generate all binary
	// strings formed by replacing each wildcard
	// character by 0 or 1
	public static void print(char str[], int index) {
		if (index == str.length) {
			System.out.println(str);
			return;
		}

		if (str[index] == '?') {
			// replace '?' by '0' and recurse
			str[index] = '0';
			print(str, index + 1);
			// replace '?' by '1' and recurse
			str[index] = '1';
			print(str, index + 1);
			// backtrack
			str[index] = '?';
		} else
			print(str, index + 1);
	}

	public static void main(String[] args) {
		String input = "1??0?101";
		char[] str = input.toCharArray();
		print(str, 0);
	}
	
	/**
	 * Another solution :
	 * We can also achieve this by using iteration. The idea is to use queue. 
	 * We find position of first occurrence of wildcard character in the input string and replace it by ‘0’ , 
	 * then ‘1’ and push both strings into the queue. 
	 * Then we pop next string from the queue, and repeat the process till queue is empty. 
	 * If no wildcard characters are left, we simply print the string.

	 */
	

    // Find all binary strings that can be formed from a given
    // wildcard pattern
    public static void printAllCombinations(String pattern)
    {
        // create an empty stack (we can also use set, queue, list, or
        // any other container)
        Stack<String> stack = new Stack();
        stack.push(pattern);        // push the pattern into the stack
 
        int index;
 
        // loop till stack is empty
        while (!stack.empty())
        {
            // pop a string from the stack and process it
            String curr = stack.pop();
 
            // `index` stores position of the first occurrence of wildcard
            // pattern in `curr`
            if ((index = curr.indexOf('?')) != -1)
            {
                // replace `?` with 0 and 1 and push it into the stack
                for (char ch = '0'; ch <= '1'; ch++)
                {
                    curr = curr.substring(0, index) + ch +
                            curr.substring(index + 1);
                    stack.push(curr);
                }
            }
 
            // if no wildcard pattern is found, print the string
            else {
                System.out.println(curr);
            }
        }
    }
}
