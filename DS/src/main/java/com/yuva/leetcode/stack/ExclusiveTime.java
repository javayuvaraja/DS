package com.yuva.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
636. Exclusive Time of Functions

On a single-threaded CPU, we execute a program containing n functions. 
Each function has a unique ID between 0 and n-1.

Function calls are stored in a call stack: when a function call starts, 
its ID is pushed onto the stack, and when a function call ends, its ID is popped off the stack. 
The function whose ID is at the top of the stack is the current function being executed. 
Each time a function starts or ends, we write a log with the ID, whether it started or ended, and the timestamp.

You are given a list logs, where logs[i] represents the ith log message formatted as a string 
"{function_id}:{"start" | "end"}:{timestamp}". For example, "0:start:3" means a function call with function ID 0 started at the beginning of timestamp 3, and "1:end:2" means a function call with function ID 1 ended at the end of timestamp 2. Note that a function can be called multiple times, possibly recursively.

A function's exclusive time is the sum of execution times for all function calls in the program. For example, if a function is called twice, one call executing for 2 time units and another call executing for 1 time unit, the exclusive time is 2 + 1 = 3.

Return the exclusive time of each function in an array, where the value at the ith index represents the exclusive time for the function with ID i.

 

Example 1:


Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3,4]
Explanation:
Function 0 starts at the beginning of time 0, then it executes 2 for units of time and reaches the end of time 1.
Function 1 starts at the beginning of time 2, executes for 4 units of time, and ends at the end of time 5.
Function 0 resumes execution at the beginning of time 6 and executes for 1 unit of time.
So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
Example 2:

Input: n = 1, logs = ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
Output: [8]
Explanation:
Function 0 starts at the beginning of time 0, executes for 2 units of time, and recursively calls itself.
Function 0 (recursive call) starts at the beginning of time 2 and executes for 4 units of time.
Function 0 (initial call) resumes execution then immediately calls itself again.
Function 0 (2nd recursive call) starts at the beginning of time 6 and executes for 1 unit of time.
Function 0 (initial call) resumes execution at the beginning of time 7 and executes for 1 unit of time.
So function 0 spends 2 + 4 + 1 + 1 = 8 units of total time executing.
 * @author Yuvaraja Kanagarajan
 *
 */
public class ExclusiveTime {

	public int[]exclusiveTime(int n, List<String> logs) {
		int result[]= new int[n];
		Stack<Integer> stack = new Stack<>();
		int prev=0;
		
		String[] log = logs.get(0).split(":");
		int process = Integer.valueOf(log[0]);
		int time = Integer.valueOf(log[2]);
		stack.push(process);
		prev = time ; 
		
		for (int i=1; i < logs.size(); i++) {
			log = logs.get(i).split(":");
			process = Integer.valueOf(log[0]);
			time = Integer.valueOf(log[2]);
			
			if (log[1].equals("start")) {  // another process came, so calculate the exclusive time of the prev process
				if (!stack.isEmpty()) {
					result[stack.peek()] += time - prev;
				}
				prev = time;
				stack.push(process); // pushing the process
			} else {  // process end
				result[stack.pop()] += time - prev +1; // exclusive
				prev = time+1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<String> logs = new ArrayList<String>();
		logs.add("0:start:0");
		logs.add("1:start:2");
		logs.add("1:end:5");
		logs.add("0:end:6");
		
		ExclusiveTime obj = new ExclusiveTime();
		obj.exclusiveTime(2, logs);
		
	}
}
