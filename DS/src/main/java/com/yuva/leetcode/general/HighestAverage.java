package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a 2-D String array of student-marks find the student with the highest average 
 and output his average score. If the average is in decimals, floor it down to the nearest integer.

Example 1:

Input:  [{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, 
			{"Jessica", "99"}]
Output: 99

Explanation: Since Jessica's average is greater than Bob's, Mike's and Jason's average.
 * @author Yuvaraja Kanagarajan
 *
 */
public class HighestAverage {

	public int hishestAverage(String[][] scores) {
        if(scores == null || scores.length == 0) {
            return -1;
        }
        int highestAve = 0;
        Map<String, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < scores.length; i++) {
            List<Integer> scoreList = map.get(scores[i][0]);
            if(scoreList == null) {
                List<Integer> currentScore = new ArrayList<>();
                currentScore.add(Integer.valueOf(scores[i][1]));
                map.put(scores[i][0], currentScore);
            } else {
                scoreList.add(Integer.valueOf(scores[i][1]));
                map.put(scores[i][0], scoreList);
            }
        }
        
        //go through the map. find the largest ave
        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            int currentAveScore = aveCalculate(entry.getValue());
            
            highestAve = Math.max(highestAve, currentAveScore);
        }
        
        return highestAve;
    }
    
    private int aveCalculate(List<Integer> scores) {
        int len = scores.size();
        int sum = 0;
        for(int score : scores) {
            sum += score;
        }
        
        float ave = sum / len;
        return (int) ave;
    }
}
