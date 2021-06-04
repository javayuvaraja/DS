package com.yuva.leetcode.graph;

import java.util.HashMap;
import java.util.Map;

public class SentenceSimilarityUnionFind {

	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length) {
			return false;
		}

		UnionFind1 uf = new UnionFind1(2 * pairs.length);

		Map<String, Integer> map = new HashMap<>();
		int id = 0;

		// Make union of words
		for (String[] pair : pairs) {
			for (String word : pair) {
				if (!map.containsKey(word)) {
					map.put(word, id);
					id++;
				}
			}

			uf.union(map.get(pair[0]), map.get(pair[1]));
		}

		for (int i = 0; i < words1.length; i++) {
			String word1 = words1[i];
			String word2 = words2[i];

			if (word1.equals(word2)) {
				continue;
			}

			if (!map.containsKey(word1) || !map.containsKey(word2)
					|| uf.find(map.get(word1)) != uf.find(map.get(word2))) {
				return false;
			}
		}
		return true;
	}
  
	
}

class UnionFind1 {
    int[] sets;
    int[] rank;
    int count;

    public UnionFind1(int n) {
        sets = new int[n];
        rank = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            sets[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int node) {
        while (node != sets[node]) {
            node = sets[node];
        }
        return node;
    }

    public void union(int i, int j) {
        int node1 = find(i);
        int node2 = find(j);

        if (node1 == node2) {
            return;
        }
        // for path compression and ranking
        if (rank[node1] < rank[node2]) {
            sets[node1] = node2;
            rank[node2] += rank[node1];
        }
        else {
            sets[node2] = node1;
            rank[node1] += rank[node2];
        }
        --count;
    }
}
