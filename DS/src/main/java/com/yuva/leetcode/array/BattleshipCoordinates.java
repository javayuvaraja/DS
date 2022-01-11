package com.yuva.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class BattleshipCoordinates {
	public static List<List<int[]>> countBattleships(char[][] board) {
        List<List<int[]>> resultList = new ArrayList<>();
        boolean isVisited[][] = new boolean [board.length][board[0].length];
        for (int i =0; i < board.length; i++ ) {
            for (int j =0; j < board[0].length; j++) {
                if (board[i][j]=='X' && !isVisited[i][j]){
                	List<int[]> temp = new ArrayList<>();
                	temp.add(new int[] {i, j});
                    isVisited[i][j]= true;
                    fillRow(board, i, j, isVisited, temp);
                    fillCol(board, i, j, isVisited, temp);
                    resultList.add(temp);
                }
            }
            
        }
        return resultList;
    }
    
    private static void fillRow(char[][] board, int row, int col, boolean isVisited[][], List<int[]> temp) {
        for (int i= col+1; i< board[0].length; i++) {
            if (board[row][i]=='X' && !isVisited[row][i]) {
                isVisited[row][i] = true;
                temp.add(new int[] {row, i});
            } else {
                break;
            }
        }
    }
    
    private static void fillCol(char[][] board, int row, int col, boolean isVisited[][], List<int[]> temp) {
        for (int i= row+1; i< board.length; i++) {
            if (board[i][col]=='X' && !isVisited[i][col]) {
                isVisited[i][col] = true;
                temp.add(new int[] {i, col});
            } else {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
    	char board[][]= new char[][]
    			{
		    		{'X','.','.','X'},
					{'.','.','.','X'},
					{'.','.','.','X'}
				};
				
		List<List<int[]>> result = countBattleships(board);
		
		for (List<int[]> temp : result) {
			for (int[] nums : temp ) {
				for (int num: nums) {
					System.out.print(num+ " ");
				}
				System.out.print(", ");
			}
			System.out.println();
		}
		System.out.println(result);
	}
}
