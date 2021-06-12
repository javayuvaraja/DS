package com.yuva.leetcode.general;

import java.util.HashMap;

public class UndergroundSystem {

	class TravelData {
		int count;
		int sum;

		TravelData(int count, int sum) {
			this.count = count;
			this.sum = sum;
		}
	}

	class CheckinData {
		String stationName;
		int timestamp;

		public CheckinData(String stationName, int timestamp) {
			this.stationName = stationName;
			this.timestamp = timestamp;
		}
	}

	HashMap<String, TravelData> checkoutMap = new HashMap<>(); // Route - {TotalTime, Count}
	HashMap<Integer, CheckinData> checkInMap = new HashMap<>(); // Uid - {StationName, Time}

	public UndergroundSystem() {
	}

	public void checkIn(int id, String stationName, int t) {
		checkInMap.put(id, new CheckinData(stationName, t));
	}

	public void checkOut(int id, String stationName, int t) {
		CheckinData checkIn = checkInMap.get(id);
		String route = checkIn.stationName + "_" + stationName;
		int totalTime = t - checkIn.timestamp;
		TravelData checkout = checkoutMap.getOrDefault(route, new TravelData(0, 0));
		checkout.sum += totalTime;
		checkout.count += 1;
		checkoutMap.put(route, checkout);
	}

	public double getAverageTime(String startStation, String endStation) {
		String route = startStation + "_" + endStation;
		TravelData checkout = checkoutMap.get(route);
		return (double) checkout.sum / checkout.count;
	}
}
