package com.yuva.leetcode.general;

/**
 * “Design hit counter” problem has recently been asked by many companies 
 * including Dropbox and the question is harder than it seems to be. 
 * It includes a couple of topics like basic data structures design, 
 * various optimization, concurrency and distributed counter.

It should support the following two operations: hit and getHits.

hit(timestamp) – Shows a hit at the given timestamp.
getHits(timestamp) – Returns the number of hits received in the past 5 minutes (300 seconds) (from currentTimestamp).

Examples:
HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301);

 * @author Yuvaraja Kanagarajan
 *
 */
public class HitCounter1 {

	// How do you handle multi threading over here atomic integer array
	int []hits = new int[300];
	int []timestamps = new int[300];
	
	public void hit(int timestamp) {
	    int idx = timestamp % 300;
	    if (timestamps[idx] != timestamp) {
	    	timestamps[idx] = timestamp;
	        hits[idx] = 1;
	    }
	    else {
	        ++hits[idx];
	    }
	}
	
	int getHits(int timestamp) {
	    int res = 0;
	    for (int i = 0; i < 300; ++i) {
	        if (timestamp - timestamps[i] < 300) { // checking with in 300 seconds
	            res += hits[i];
	        }
	    }
	    return res;
	}
	
}
