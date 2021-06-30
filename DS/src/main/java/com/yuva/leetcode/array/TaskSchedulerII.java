package com.yuva.leetcode.array;

/**
Leetcode 621 : Task scheduler
Given a characters array tasks, representing the tasks a CPU needs to do, 
where each letter represents a different task. Tasks could be done in any order. 
Each task is done in one unit of time. 
For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between 
two same tasks (the same letter in the array), that is that there must be at least 
n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.
 * @author Yuvaraja Kanagarajan
 *
 */
public class TaskSchedulerII {
	
	/**
	 * Logic :
	 * Find the number of frames by calculating the maximum frequency char count.
	 * 
	 * Ex : ABACABCBAA, cooldown = 3  -> A 5, B 3, C 2 , So we have totally 5 frames
	 * 
	 * AXXX AXXX AXXX AXXX A => we have totally 4 complete frame with length of cooled down +1
	 * 
	 * so formula is
	 * 
	 *  (maxFreq-1) * (cooldown+1) + maxCount (maxCount => how many char have the max frequency)
	 *  (5-1) * (3+1) +1 => 4*4+1 =>17
	 *  
	 * @param tasks
	 * @para m n
	 * @return
	 */
	public int leastInterval(char[] tasks, int cooldown) {
		int len = tasks.length;
		int[] count = new int[26];
		int maxFreqCount = 0, maxFreqElementCount = 0;
		for (char c : tasks) {
			count[c - 'A']++;
			if (count[c - 'A'] > maxFreqCount) {
				maxFreqCount = count[c - 'A'];
				maxFreqElementCount = 1;
			} else if (count[c - 'A'] == maxFreqCount) {
				maxFreqElementCount++;
			}
		}
		return Math.max(len, (maxFreqCount - 1) * (cooldown + 1) + maxFreqElementCount);
	}
}
