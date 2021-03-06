package com.yuva.amazon.oa;

public class FiveStarSeller {

	int fiveStarReviews(int[][] productRatings, int ratingThreshold) {
		int count = 0;
		int i = 0;
		int j = 0;
		while (i < productRatings.length) {
			if (Math.ceil(productRatings[i][0] + j) * 100 / (productRatings[i][1] + j) < ratingThreshold) {
				j++;
				count++;
			}
			else {
				i++;
				j = 0;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int threshold = 77;
		int [][]productRatings = {{4,4},{1,2},{3,6}};
		FiveStarSeller obj = new FiveStarSeller();
		int count = obj.fiveStarReviews(productRatings, threshold);
		System.out.println(count);
	}
}
