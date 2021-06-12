package com.yuva.leetcode.array;

public class MedianOfSortedArrayOptimized {

/**
The idea is to merge both the arrays and return the middle element [or average of middle elements if m+n is even].
BUT, we don't have to store the merged array.
We just need the pointers to both the arrays, 
at the instant we merge the arrays till median index. (thus using O(1) space)

We use the "Merge two sorted arrays algorithm" to merge both the arrays untill (nums1Ptr + nums2Ptr) <= ((m+n)/2). As (m+n)/2 will be 
the median index in a merged array.. Then return the median element. 
	 * 
	 */
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        
	        int m = nums1.length, n = nums2.length;
	        int nums1Ptr = 0, nums2Ptr = 0;      
	                
	        int medianIndex = (m+n)/2;
	        
	        double median1 = (m>0) ? nums1[0]: nums2[0];  //extra variables to store the median, second highest
	        double median2 = median1; // highest
	        
	        while(nums1Ptr < m && nums2Ptr < n && ((nums1Ptr+nums2Ptr) <= medianIndex) ){
	            if(nums1[nums1Ptr] < nums2[nums2Ptr]){
	                median1 = median2;
	                median2 = nums1[nums1Ptr];
	                nums1Ptr++;
	            }
	            else{
	                median1 = median2;
	                median2 = nums2[nums2Ptr];
	                nums2Ptr++;
	            }
	        }
	        
	        while(nums1Ptr<m && ((nums1Ptr+nums2Ptr) <= medianIndex) ){
	            median1 = median2;
	            median2 = nums1[nums1Ptr];
	            nums1Ptr++;
	        }
	        
	        while(nums2Ptr<n && ((nums1Ptr+nums2Ptr) <= medianIndex) ){
	            median1 = median2;
	            median2 = nums2[nums2Ptr];
	            nums2Ptr++;
	        }
	        
	        if((m+n)%2==0)
	            return (median1+median2)/2;
	        else
	            return median2;
	    }
}
