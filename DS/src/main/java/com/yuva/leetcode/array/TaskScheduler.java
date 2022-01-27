package com.yuva.leetcode.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**

A sequence of task given where each task identified by a unique id. 
There is cool down period to be observed before executing same task again. 
Find the execution time for the task sequence.

Example:
Task sequence: 1 2 1 2
cool-down period: 3

Execution time: 6 (o/p seq: 1 2 . . 1 2)
 * @author Yuvaraja Kanagarajan
 *
 */
public class TaskScheduler {

    static HashMap<Integer, Integer> coolDownMap;

    public static int scheduler(int[] tasks, int coolDown) {
        coolDownMap = new HashMap<>();
        Queue<Integer> taskQ = new LinkedList<>();
        for (int task : tasks) {
            coolDownMap.put(task, 0);
            taskQ.offer(task);
        }

        int executionTime = 0;

        while (!taskQ.isEmpty()) {
            int task = taskQ.poll();

            reduceCoolDownForAll();
            if (coolDownMap.get(task) == 0) {
                coolDownMap.put(task, coolDown);
            } else {
                taskQ.offer(task);
            }
            executionTime++;
        }

        return executionTime;
    }

    private static void reduceCoolDownForAll() {
        coolDownMap.replaceAll((k,v) -> v > 0 ? v-1 : v);
    }

    public static void main(String[] args) {
        System.out.println(scheduler(new int[]{1,2,1,2}, 3));
    }
}