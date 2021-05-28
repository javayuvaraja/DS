package com.yuva.leetcode.general;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


/**
Design a Leaderboard class, which has 3 functions:

addScore(playerId, score): Update the leaderboard by adding score to the given player's score. If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
top(K): Return the score sum of the top K players.
reset(playerId): Reset the score of the player with the given id to 0. It is guaranteed that the player was added to the leaderboard before calling this function.
Initially, the leaderboard is empty.

 

Example 1:

Input: 
["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
[[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
Output: 
[null,null,null,null,null,null,73,null,null,null,141]

Explanation: 
Leaderboard leaderboard = new Leaderboard ();
leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
leaderboard.top(1);           // returns 73;
leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
leaderboard.top(3);           // returns 141 = 51 + 51 + 39;
 * @author Yuvaraja Kanagarajan
 *
 */
public class DesignLeaderBoard {

    Map<Integer, Integer> scoreMap;
    Map<Integer, Set<Integer>> playerMap;
    public DesignLeaderBoard() {
        scoreMap = new HashMap<>();
        playerMap = new TreeMap<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score) {
        if (scoreMap.containsKey(playerId)) {
            int prevScore = scoreMap.get(playerId);
            playerMap.get(prevScore).remove(playerId);
        }
        scoreMap.put(playerId, scoreMap.getOrDefault(playerId, 0) + score);
        playerMap.computeIfAbsent(scoreMap.get(playerId), k -> new HashSet<>()).add(playerId);
    }

    public int top(int K) {
        int sum = 0;
        for (Integer key : playerMap.keySet()) {
            int count = Math.min(K, playerMap.get(key).size());
            sum += key * count;
            K -= count;
            if (K == 0) {
                break;
            }
        }
        return sum;
    }

    public void reset(int playerId) {
        int prevScore = scoreMap.get(playerId);
        playerMap.get(prevScore).remove(playerId);
        scoreMap.put(playerId, 0);
        playerMap.computeIfAbsent(0, k -> new HashSet<>()).add(playerId);
    }
}

