package com.yuva.leetcode.array;

public class MajorityElement {

	/**
	 * This code works when always majority elements exists in the array.
	 * It wont work for input like {2,3,4,5,1,1}
	 * @param num
	 * @return
	 */
	public int majorityElement(int[] num) {
        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
	
	/*
	 * This solution also same as above. but here it will verify the candiate is majority element or not.
	 */
	void findMajority(int a[], int size) {
		/* Find the candidate for Majority */
		int cand = findCandidate(a, size);

		/* Print the candidate if it is Majority */
		if (isMajority(a, size, cand))
			System.out.println(" " + cand + " ");
		else
			System.out.println("No Majority Element");
	}

	/* Function to find the candidate for Majority */
	int findCandidate(int a[], int size) {
		int maj_index = 0, count = 1;
		int i;
		for (i = 1; i < size; i++) {
			if (a[maj_index] == a[i])
				count++;
			else
				count--;
			if (count == 0) {
				maj_index = i;
				count = 1;
			}
		}
		return a[maj_index];
	}

	/*
	 * Function to check if the candidate occurs more than n/2 times
	 */
	boolean isMajority(int a[], int size, int cand) {
		int i, count = 0;
		for (i = 0; i < size; i++) {
			if (a[i] == cand)
				count++;
		}
		if (count > size / 2)
			return true;
		else
			return false;
	}
	
	
	public static void main(String[] args) {
		int arr[] = {2,3,4,5,1,1};
		MajorityElement obj = new MajorityElement();
		System.out.println(obj.majorityElement(arr));
	}
}
