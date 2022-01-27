package com.yuva.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator implements Iterator<Integer> {

	Deque<NestedInteger> stack = new ArrayDeque<>();
    public FlattenNestedListIterator (List<NestedInteger> nestedList) {
        prepareStack(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            prepareStack(list);
        }
        return !stack.isEmpty();
    }
    
    private void prepareStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
}

interface NestedInteger {
	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list
	// Return empty list if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}



/**
public class NestedIterator implements Iterator<Integer> {

private Queue<Integer> queue;;

public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList();
        dfs(nestedList);
}

private void dfs(List<NestedInteger> list){
    if (list == null)
        return;
    
    for (NestedInteger in: list){
        if (in.isInteger())
            queue.offer(in.getInteger());
        else{
            dfs(in.getList());
        }
        
    }
}

@Override
public Integer next() {
    if (hasNext()){
        return queue.poll();
    }
    else
        return -1;
}

@Override
public boolean hasNext() {
    if (!queue.isEmpty())
        return true;
    else
        return false;
}
}
*/