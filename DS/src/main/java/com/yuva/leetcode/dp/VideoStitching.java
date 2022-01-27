package com.yuva.leetcode.dp;

import java.util.Arrays;

public class VideoStitching {

	public int videoStitching(int[][] clips, int totalTime) {
        int end = 0, maxReachLen = 0, clipCount = 0;
        Arrays.sort(clips, (a, b) -> (a[0] - b[0]));
        for(int i = 0; end < totalTime; end = maxReachLen) {      
            clipCount++;                       
            while(i < clips.length && clips[i][0] <= end) {
                maxReachLen = Math.max(maxReachLen, clips[i++][1]);
            }
            if(end == maxReachLen) return -1;   
        }		
        return end >= totalTime ? clipCount : -1;
    }
}
