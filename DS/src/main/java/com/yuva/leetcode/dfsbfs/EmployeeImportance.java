package com.yuva.leetcode.dfsbfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
690. Employee Importance

You have a data structure of employee information, which includes the employee's unique id, their importance value, and their direct subordinates' id.

You are given an array of employees employees where:

employees[i].id is the ID of the ith employee.
employees[i].importance is the importance value of the ith employee.
employees[i].subordinates is a list of the IDs of the subordinates of the ith employee.
Given an integer id that represents the ID of an employee, return the total importance value of this employee and all their subordinates.

 
 * @author Yuvaraja Kanagarajan
 *
 */
public class EmployeeImportance {

	public int getImportance(List<Employee> employees, int id) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee emp : employees) {
            employeeMap.put(emp.id, emp);
        }
        
        int importance = 0;
        while (!queue.isEmpty()) {
            Employee emp = employeeMap.get(queue.poll());
            importance += emp.importance;
            for (Integer temp : emp.subordinates) {
                queue.offer(temp);
            }
        }
        return importance;
    }
	
	class Employee {
	    public int id;
	    public int importance;
	    public List<Integer> subordinates;
	}
}

