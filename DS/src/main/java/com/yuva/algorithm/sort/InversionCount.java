package com.yuva.algorithm.sort;

public class InversionCount {

	public int findInversion (int arr[]) {
		return sort (arr, 0, arr.length-1);
	}
	
	private int sort (int arr[], int start, int end) {
		int inversionCount = 0;
		if (start < end) {
			int mid = (start+end)/2;
			inversionCount += sort (arr, start, mid);
			inversionCount += sort (arr, mid+1, end);
			inversionCount += merge(arr, start, mid, end);
		}
		
		return inversionCount;
	}
	
	private int merge (int arr[], int start, int mid, int end) {
		// temp array to sort the range
		int temp[] = new int[end-start+1];
		int i= start; // first half starting position
		int j= mid+1; // second half starting position
		int k=0; // temp sort index
		int swapCount = 0;
		while (i <= mid && j <=end) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				swapCount = swapCount + (mid-i+1);  //from i to mid all the elements will have the inversion
			}
		}
		
		while (i<=mid) {
			temp[k++] = arr[i++];
		}
		while (j<=end) {
			temp[k++] = arr[j++];
		}
		
		// copy the sorted values to the original array
		k=0;
		for (i= start; i <=end ; i++) {
			arr[i] = temp[k++];
		}
		return swapCount;
	}
	
	public static void main(String[] args) {
		  // int[] arr = { 1, 20, 6, 4, 5 };  //5
		int[] arr = new int[] { 8, 4, 2, 1 };  //6
		 InversionCount obj = new InversionCount();
		 System.out.println(obj.findInversion(arr));
	}
}
