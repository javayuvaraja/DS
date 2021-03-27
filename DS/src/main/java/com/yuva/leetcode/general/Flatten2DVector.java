package com.yuva.leetcode.general;

import java.util.Iterator;
import java.util.List;

/**
 * Leetcode 251: Flatten 2D Vector
 * Implement an iterator to flatten a 2d vector.
 * 
 * For example, Given 2d vector =
 * 
 * [ [1,2], [3], [4,5,6] ] By calling next repeatedly until hasNext returns
 * false, the order of elements returned by next should be: [1,2,3,4,5,6].
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class Flatten2DVector implements Iterator<Integer> {

    Iterator<List<Integer>> globalIter;
    Iterator<Integer> currListItr;

    public Flatten2DVector(List<List<Integer>> vec2d) {
        globalIter = vec2d.iterator();
        currListItr = null;
    }

    @Override
    public Integer next() {
        return currListItr.next();
    }

    @Override
    public boolean hasNext() {
        if(currListItr != null && currListItr.hasNext()) {
        	return true;
        }
        
        while(globalIter.hasNext()) {
            currListItr = globalIter.next().iterator();
            if(currListItr.hasNext()) {
            	return true;
            }
        }
        return false;
    }
}