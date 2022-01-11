package com.yuva.leetcode.array;

import java.util.Arrays;

/**
 * Bloomberg
 * 
 *  Given the time operation hours of different banks, you have to test whether a transaction is valid or not. 
 *  For a transaction to be valid it has to fall between the operating hours of the bank.

Input example - operation hours of different banks

04:20 - 12:30
19:00 - 21:45
14:00 - 17:30
12:30 - 14:00

Test - 11:00 - 17:30
Output - true


 * @author Yuvaraja Kanagarajan
 *
 */
public class BankingTransactionHoursInterval {

	/**
	 *  The operating hours come in as Dates, then  convert the dates(times) to minutes (as integers). 
	 *  For example, 4:20 becomes (4 * 60) + 20 = 260mins, and 12:30 becomes (12 * 60) + 30 = 750mins
	 * @param operatingHours
	 * @param transaction
	 * @return
	 */
	public boolean isValid(int[][] operatingHours, int[] transaction) {
		Arrays.sort(operatingHours, (a, b) -> a[0] - b[0]); // sort by start time
		int start = operatingHours[0][0], end = operatingHours[0][1];
		if (transaction[0] >= start && transaction[1] <= end)
			return true;
		for (int i = 1; i < operatingHours.length; i++) {
			int currInterval[] = operatingHours[i];

			if (currInterval[0] <= end) { // overlap
				end = Math.max(currInterval[1], end);
			} else { // no overlap
				start = currInterval[0];
				end = currInterval[1];
			}
			if (transaction[0] >= start && transaction[1] <= end) {
				return true;
			}
		}
		return false;
	}

}
