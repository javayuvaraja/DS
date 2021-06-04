package com.yuva.leetcode.general;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
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

public class HitCounter {

	Queue<Integer> queue;
	int hitCount;

	/** Initialize your data structure here. */
	public HitCounter() {
		this.queue = new LinkedList<>();
		this.hitCount = 0;
	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {
		queue.offer(timestamp);
		hitCount++;
		removeOldHits(timestamp);
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		removeOldHits(timestamp);
		return hitCount;
	}

	private void removeOldHits(int timestamp) {
		while (hitCount > 0 && timestamp - queue.peek() >= 300) {
			queue.poll();
			hitCount--;
		}
	}
}
