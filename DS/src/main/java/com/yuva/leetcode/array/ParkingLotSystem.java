package com.yuva.leetcode.array;

public class ParkingLotSystem {

	 	int[] count;
	    public ParkingLotSystem(int big, int medium, int small) {
	        count = new int[]{big, medium, small};
	    }

	    public boolean addCar(int carType) {
	    	int available = count[carType - 1];
	    	boolean isAvailable = available > 0;
	    	count[carType-1]--;
	        return isAvailable;
	    }
}
