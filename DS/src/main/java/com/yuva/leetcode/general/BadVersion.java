package com.yuva.leetcode.general;

public class BadVersion implements VersionControl {

	public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            //int mid = (start + end) / 2; // this will cause integer overflow
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }        
        return start;
    }

	@Override
	public boolean isBadVersion(int versionNum) {
		// TODO Auto-generated method stub
		return false;
	}
}
