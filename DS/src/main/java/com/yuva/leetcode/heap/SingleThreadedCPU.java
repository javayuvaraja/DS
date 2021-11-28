package com.yuva.leetcode.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SingleThreadedCPU {

	class Task {
		int taskId;
		int enqueueTime;
		int processTime;
		
		Task(int taskId, int enqueueTime, int processTime) {
			this.taskId = taskId;
			this.processTime = processTime;
			this.enqueueTime = enqueueTime;
		}
	}
	public int[] getOrder(int[][] tasks) {
        
        List<Task> taskList = new ArrayList<>();
        for(int i = 0; i < tasks.length; i++) {
        	taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        
        // sort by enque time
        Collections.sort(taskList, (a, b) -> a.enqueueTime - b.enqueueTime);
       
        // min heap based on the process time, if same time then based on the task id
        PriorityQueue<Task> minHeap = new PriorityQueue<Task>((a, b) -> a.processTime == b.processTime ?
        									a.taskId - b.taskId : a.processTime - b.processTime);
        int time = 0;
        int processed = 0; 
        int resultIndex = 0;
        
        //There are 2 situations:
        //1:no task can be executed E.g. t = 0, [1,2], queue={}, then t = next start time
        //2:there are task start time <= t, add task into queue, then pick the task with least duration
        //  and update t = t + duration
        
        int[] result = new int[tasks.length];
        while(resultIndex < tasks.length ) {
        	
            while(processed < tasks.length && taskList.get(processed).enqueueTime <= time) {
                minHeap.offer(taskList.get(processed++));
            }
            

        	if(minHeap.isEmpty()) {
                time = taskList.get(processed).enqueueTime;
                continue;
            }
        	
            Task bestFit = minHeap.poll();
            result[resultIndex++] = bestFit.taskId;
            time += bestFit.processTime;
        }
        return result;
    }
	
	public static void main(String[] args) {
		SingleThreadedCPU obj = new SingleThreadedCPU();
		int tasks[][] =new int [][]{{5,2},{7,2},{9,4},{6,3},{5,10},{1,1}};
		int result[] = obj.getOrder(tasks);
		for (int temp: result) {
			System.out.print(temp + " ");
		}
	}
}
