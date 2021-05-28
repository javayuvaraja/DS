package com.yuva.algorithm.sort;

public class MergeSort {

	public void sort (int arr[]) {
		sort (arr, 0, arr.length-1);
	}
	
	private void sort (int arr[], int start, int end) {
		if (start < end) {
			int mid = (start+end)/2;
			sort (arr, start, mid);
			sort (arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
	
	private void merge (int arr[], int start, int mid, int end) {
		// temp array to sort the range
		int temp[] = new int[end-start+1];
		int i= start; // first half starting position
		int j= mid+1; // second half starting position
		int k=0; // temp sort index
		while (i <= mid && j <=end) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
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
	}
	
	public static void main(String[] args) {
		int arr[] = {6,3,7,2,8,4,1,9};
		MergeSort obj = new MergeSort();
		obj.sort(arr);
		
		for (int temp : arr) {
			System.out.print(temp + " ");
		}
		
	}
	
}
