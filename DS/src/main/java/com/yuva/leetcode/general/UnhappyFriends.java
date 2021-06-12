package com.yuva.leetcode.general;

import java.util.HashMap;
import java.util.Map;

/**
1583. Count Unhappy Friends

You are given a list of preferences for n friends, where n is always even.

For each person i, preferences[i] contains a list of friends sorted in the order of preference. 
In other words, a friend earlier in the list is more preferred than a friend later in the list. 
Friends in each list are denoted by integers from 0 to n-1.

All the friends are divided into pairs. The pairings are given in a list pairs, 
where pairs[i] = [xi, yi] denotes xi is paired with yi and yi is paired with xi.

However, this pairing may cause some of the friends to be unhappy. A friend x is unhappy if x is paired with y and there 
exists a friend u who is paired with v but:

x prefers u over y, and
u prefers x over v.
Return the number of unhappy friends.

 
 * Input: n = 4, preferences = [[1, 2, 3], [3, 2, 0], [3, 1, 0], [1, 2, 0]], pairs = [[0, 1], [2, 3]]
Output: 2
Explanation:
Friend 1 is unhappy because:
- 1 is paired with 0 but prefers 3 over 0, and
- 3 prefers 1 over 2.
Friend 3 is unhappy because:
- 3 is paired with 2 but prefers 1 over 2, and
- 1 prefers 3 over 0.
Friends 0 and 2 are happy.
 * @author Yuvaraja Kanagarajan
 *
 */
public class UnhappyFriends {

	public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] map = new int[n];
        for(int[] pair: pairs){ // Keep record of current matches.
            map[pair[0]] = pair[1];
            map[pair[1]] = pair[0];
        }
        int res = 0;
		
        Map<Integer, Integer>[] preferenceMap = new Map[n]; // O(1) to fetch the index from the preference array. 
         
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
            	if(preferenceMap[i] == null) {
            		preferenceMap[i] = new HashMap<>();
            	}
                preferenceMap[i].put(preferences[i][j], j); // storing the preference order
            }
        }

        for(int i = 0; i < n; i++){ // for each person
            for(int j : preferences[i]){ // getting the preference
                if(preferenceMap[j].get(i) < preferenceMap[j].get(map[j])   // j prefernece is not i
					&& preferenceMap[i].get(map[i]) > preferenceMap[i].get(j)){ // i preference is not j
                    res++;
                    break;
                }
            }
        }
	    return res;
	}
}
