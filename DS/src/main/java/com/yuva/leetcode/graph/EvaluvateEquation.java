package com.yuva.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
399. Evaluate Division

You are given an array of variable pairs equations and an array of real numbers values, 
where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. 
Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where 
you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in 
division by zero and that there is no contradiction.

 

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], 
       queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
       Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]

Example 2:
Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]

 * @author Yuvaraja Kanagarajan
 * 
 */
public class EvaluvateEquation {

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result =  new double[queries.size()];
        
        int count = 0;
        for (List<String> query : queries) {
            String source = query.get(0);
            String dest = query.get(1);
             result[count++] = calculate(source, dest, new HashSet<>(), graph);
        }
        return result;
    } 
    
    
    private double calculate (String source, String dest,  Set<String> visited , 
    		Map<String, Map<String, Double>>  graph ) {
        
        if (!graph.containsKey(source)) {
            return -1;
        }
        
        if (graph.get(source).containsKey(dest)) {
            return graph.get(source).get(dest);
        }
        
        visited.add(source);
        for (Map.Entry<String, Double> neighbour : graph.get(source).entrySet()) {
            if (!visited.contains(neighbour.getKey())) {
                double weight =  calculate(neighbour.getKey(), dest ,visited, graph) ;
                if (weight!=-1) {
                    return weight * neighbour.getValue();
                }
            }
        }
        return -1;
         
        
    }
    private Map<String, Map<String, Double>> buildGraph (List<List<String>> equations , double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int count = 0;
        for (List<String> equation : equations) {
            String source = equation.get(0);
            String dest = equation.get(1);
            graph.putIfAbsent(source, new HashMap<String, Double>());
            graph.get(source).put(dest, values[count]);
            graph.putIfAbsent(dest, new HashMap<String, Double>());
            graph.get(dest).put(source, 1/values[count]);
            count++;
        }
        
        return graph;
    } 
}
