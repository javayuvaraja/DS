package com.yuva.leetcode.array;

import java.util.Arrays;

/**
 * 
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
				end = Math.max(operatingHours[i][1], end);
			} else { // no overlap
				start = operatingHours[i][0];
				end = operatingHours[i][1];
			}
			if (transaction[0] >= start && transaction[1] <= end) {
				return true;
			}
		}
		return false;
	}

}
