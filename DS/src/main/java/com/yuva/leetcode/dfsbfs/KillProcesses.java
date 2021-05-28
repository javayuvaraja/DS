package com.yuva.leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
Leetcode 582
Description,
Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

Each process only has one parent process, but may have one or more children processes. 
This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

We use two list of integers to represent a list of processes, where the first list contains PID 
for each process and the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, 
return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, 
all its children processes will be killed. No order is required for the final answer.

Example 1:

Input: 
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.
 * @author Yuvaraja Kanagarajan
 *
 */
public class KillProcesses {

	 public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		 List<Integer> result = new ArrayList<>();
		 Map<Integer, List<Integer>> pidMap = new HashMap<>();
		 
		 for (int i =0; i < pid.size(); i++) {
			 pidMap.putIfAbsent(ppid.get(i), new ArrayList<Integer>());
			 pidMap.get(ppid.get(i)).add(pid.get(i));
		 }
		 
		 Queue<Integer> queue = new LinkedList<>();
		 queue.add(kill);

		 while (!queue.isEmpty()) {
			 int node = queue.poll();
			 result.add(node);
			 if (pidMap.containsKey(node)) {
				 for (int child : pidMap.get(node)) {
					 queue.add(child);
				 }
			 }
		 }
		 return result;
	 }
	 
	 public static void main(String[] args) {
		 List<Integer> pidList = Arrays.asList(1, 3, 10, 5);
		 List<Integer> ppidList = Arrays.asList(3, 0, 5, 3);
		 
		 KillProcesses obj = new KillProcesses();
		 List<Integer> result = obj.killProcess(pidList, ppidList, 3);
		 System.out.println(result);		 
		 
	 }
}
