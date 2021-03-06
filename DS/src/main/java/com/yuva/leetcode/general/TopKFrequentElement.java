package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElement {

	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int temp : nums){
            numMap.put (temp, numMap.getOrDefault(temp, 0) +1);
        }
        
        List<Integer>[]  bucket = new List[nums.length + 1];
        for (int key : numMap.keySet()) {
            int frequency = numMap.get(key);
            if (bucket[frequency]==null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        
        List<Integer> result = new ArrayList<>();

        for (int i= bucket.length-1; i >=0 && result.size() < k; i-- ) {
            if (bucket[i]!=null) {
                result.addAll(bucket[i]);
            }
        }
       
        return result.stream().mapToInt(i->i).toArray();
     }
}
