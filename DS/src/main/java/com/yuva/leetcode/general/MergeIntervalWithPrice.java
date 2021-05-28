package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

/**
 * Goldman Sachs
 * @author Yuvaraja Kanagarajan
 *
 */
public class MergeIntervalWithPrice {
	private class Interval {
		int startTime;
		int endTime;
		int price;

		Interval(int startTime, int endTime, int price) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.price = price;
		}

		public int getStartTime() {
			return this.startTime;
		}

		public int getEndTime() {
			return this.endTime;
		}

		public int getPrice() {
			return this.price;
		}

		public String toString() {
			return this.startTime + " ," + this.endTime + ", " + this.price;
		}

		public int hashCode() {
			return 13 * this.startTime * this.endTime * this.price;
		}

		public boolean equals(Object other1) {
			if (!(other1 instanceof Interval)) {
				return false;
			}
			Interval other = (Interval) other1;
			return this.startTime == other.startTime && this.endTime == other.endTime && this.price == other.price;
		}
	}

	private List<Interval> getLowestPrices(List<Interval> vendors) {
		List<Interval> result = new ArrayList<>();
		if (vendors == null || vendors.size() == 0) {
			return result;
		}

		// Have to sort by start time, if start time is same then sort by price
		// Collections.sort(vendors, (a, b) -> a.startTime - b.startTime);
		Collections.sort(vendors, Comparator.comparing(Interval::getStartTime).thenComparing(Interval::getPrice));

		Interval prev = vendors.get(0);
		Interval curr = null;
		System.out.println("Prev : " + prev.startTime + " " + prev.endTime + " " + prev.price);
		for (int i = 1; i < vendors.size(); i++) {
			curr = vendors.get(i);
			// no overlap
			if (curr.startTime > prev.endTime) {
				result.add(prev);
				prev = curr;
			} else { // complete overlap
				if (prev.startTime <= curr.startTime && 
						prev.endTime >= curr.endTime) { // completely overlap
					if (prev.price <= curr.price) { 
						continue;
					} else {
						result.add(new Interval(prev.startTime, curr.startTime, prev.price));
						result.add(curr);
						prev.startTime = curr.endTime;						
					}
				} else {// partially overlap
					if (prev.price > curr.price) {
						prev.endTime  = curr.startTime;
						result.add(prev);
						prev =curr;
					}
				}
			}			
		}
		result.add(prev);
		System.out.println("Result : " + result);
		return result;
	}
	
	
	private List<Interval> findMinPrice (List<Interval> vendors) {
		TreeMap<Integer, Integer> priceMap = new TreeMap<>();
		List<Interval> result = new ArrayList<>();
		for (Interval interval : vendors) {
			for (int startTime = interval.startTime ; startTime <= interval.endTime; startTime++) {
				if (priceMap.containsKey(startTime)) {
					priceMap.put(startTime, Math.min(priceMap.get(startTime), interval.price));
				} else {
					priceMap.put(startTime, interval.price);
				}
			}
		}
		
		
		List<Integer> priceSet = priceMap.keySet().stream().collect(Collectors.toList());
		
		int prevTime = priceSet.get(0);
		Interval prevInterval = new Interval(prevTime, prevTime, priceMap.get(prevTime));
		
		for (int i=1; i <priceSet.size(); i++) {
			int currTime = priceSet.get(i);
			int currPrice = priceMap.get(currTime);
			if (currTime == prevInterval.endTime + 1 &&
					currPrice == prevInterval.price) { // consecutive interval
				prevTime = currTime;
				prevInterval.endTime = prevTime;
				continue;
			} else {
				prevInterval.endTime = prevTime;
				result.add(prevInterval);
				prevInterval = new Interval(currTime, currTime, currPrice);
				prevTime = currTime;
			}
		} 
		prevInterval.endTime = prevTime;
		result.add(prevInterval);
		return result;
	}

	/**
	 * Returns true if the tests pass. Otherwise, false.
	 */
	private boolean doTestsPass() {
		// Interval[] sampleInput = { new Interval( 1, 5, 20 ), new Interval( 3, 8, 15
		// ), new Interval( 7, 10, 8 ) };
		// Interval[] expectedOutput = { new Interval( 1, 3, 20 ), new Interval( 3, 7,
		// 15 ), new Interval( 7, 10, 8 ) };

		Interval[] sampleInput = { new Interval(1, 20, 13), new Interval(7, 10, 8), new Interval(3, 8, 15),
				new Interval(1, 5, 20), new Interval(25, 30, 12) };
		Interval[] expectedOutput = { new Interval(1, 7, 13), new Interval(7, 10, 8), new Interval(10, 20, 13),  new Interval(25, 30, 12) };

		// * Input : ( 1, 20 13 ), ( 7, 10, 8 ), ( 3, 8, 15 ), ( 1, 5, 20 )
		// * Output: ( 1, 7, 13 ), ( 7, 10, 8 ), ( 10, 20, 13 )

		List<Interval> inputList = new ArrayList<>(Arrays.asList(sampleInput));
		List<Interval> expectedList = new ArrayList<>(Arrays.asList(expectedOutput));

		//return expectedList.equals(getLowestPrices(inputList));
		List<Interval> result = findMinPrice(inputList);
		return expectedList.equals(result);
		
	}

	/**
	 * Execution entry point.
	 */
	public static void main(String[] args) {
		MergeIntervalWithPrice solution = new MergeIntervalWithPrice();
		if (solution.doTestsPass()) {
			System.out.println("All tests passed");
		} else {
			System.out.println("Tests failed");
		}
	}
}