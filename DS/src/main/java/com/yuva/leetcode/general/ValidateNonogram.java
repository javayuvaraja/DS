package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.List;

/**

A nonogram is a logic puzzle, similar to a crossword, in which the player is given a blank grid and has to color it according to some instructions. Specifically, each cell can be either black or white, which we will represent as 'B' for black and 'W' for white.

+------------+
| W W W W |
| B W W W |
| B W B B |
| W W B W |
| B B W W |
+------------+

For each row and column, the instructions give the lengths of contiguous runs of black ('B') cells. For example, the instructions for one row of [ 2, 1 ] indicate that there must be a run of two black cells, followed later by another run of one black cell, and the rest of the row filled with white cells.

These are valid solutions: [ W, B, B, W, B ] and [ B, B, W, W, B ] and also [ B, B, W, B, W ]
This is not valid: [ W, B, W, B, B ] since the runs are not in the correct order.
This is not valid: [ W, B, B, B, W ] since the two runs of Bs are not separated by Ws.

Your job is to write a function to validate a possible solution against a set of instructions. Given a 2D matrix representing a player's solution; and instructions for each row along with additional instructions for each column; return True or False according to whether both sets of instructions match.

Example instructions #1

matrix1 = [[ W, W, W, W ],
[ B, W, W, W ],
[ B, W, B, B ],
[ W, W, B, W ],
[ B, B, W, W ]]
rows1_1 = [], [1], [1,2], [1], [2]
columns1_1 = [2,1], [1], [2], [1]
validateNonogram(matrix1, rows1_1, columns1_1) => True

Example solution matrix:
matrix1 ->
row
+------------+ instructions
| W W W W | <-- []
| B W W W | <-- [1]
| B W B B | <-- [1,2]
| W W B W | <-- [1]
| B B W W | <-- [2]
+------------+
^ ^ ^ ^
| | | |
column [2,1] | [2] |
instructions [1] [1]

Example instructions #2

(same matrix as above)
rows1_2 = [], [], [1], [1], [1,1]
columns1_2 = [2], [1], [2], [1]
validateNonogram(matrix1, rows1_2, columns1_2) => False

The second and third rows and the first column do not match their respective instructions.

Example instructions #3

(same matrix as above)
rows1_3 = [], [1], [3], [1], [2]
columns1_3 = [3], [1], [2], [1]
validateNonogram(matrix1, rows1_3, columns1_3) => False

The third row and the first column do not match their respective instructions.

Example instructions #4

matrix2 = [
[ W, W ],
[ B, B ],
[ B, B ],
[ W, B ]
]
rows2_1 = [], [2], [2], [1]
columns2_1 = [1, 1], [3]
validateNonogram(matrix2, rows2_1, columns2_1) => False

The black cells in the first column are not separated by white cells.

Example instructions #5

(same matrix as above)
rows2_2 = [], [2], [2], [1]
columns2_2 = [3], [3]
validateNonogram(matrix2, rows2_2, columns2_2) => False

The first column has the wrong number of black cells.

Example instructions #6

(same matrix as above)
rows2_3 = [], [], [], []
columns2_3 = [], []
validateNonogram(matrix2, rows2_3, columns2_3) => False

All of the instructions are empty

n: number of rows in the matrix
m: number of columns in the matrix
 * @author Yuvaraja Kanagarajan
 *
 */
public class ValidateNonogram {

	public static void main(String[] args) {
		 char[][] grid = new char[][]{{'W','W','W','W'},
             {'B','B','B','B'},
             {'B','W','B','B'},
             {'W','W','B','W'},
             {'B','B','W','W'}};

		int[][] dataSetRow = new int[][] {{},{4},{1,2},{1},{2}};
		int[][] dataSetCol = new int[][] {{2,1},{1,1},{3},{2}};
		System.out.println(validateNonogram(grid, dataSetRow, dataSetCol));
	}
	private static boolean validateNonogram(char[][] matrix, int[][] row, int[][] col) {

		for (int i = 0; i < matrix.length; i++) {
			List<Integer> rowList = new ArrayList<>();
			int count = 0;
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 'B') {
					count++;
				} else if (count > 0) {
					rowList.add(count);
					count = 0;
				}
			}

			if (count > 0) {
				rowList.add(count);
			}
			if (rowList.size()!=row[i].length) {
				return false;
			}
			
			for (int temp = 0; temp < row[i].length; temp++) {
				if (row[i][temp] != rowList.get(temp)) {
					return false;
				}
			}
		}

		for (int i = 0; i < matrix[0].length; i++) {
			List<Integer> colList = new ArrayList<>();
			int count = 0;
			for (int j = 0; j < matrix.length; j++) {

				if (matrix[j][i] == 'B') {
					count++;
				} else if (count > 0) {
					colList.add(count);
					count = 0;
				}
			}

			if (count > 0) {
				colList.add(count);
			}

			if (colList.size()!=col[i].length) {
				return false;
			}
			
			for (int temp = 0; temp < col[i].length; temp++) {
				if (col[i][temp] != colList.get(temp)) {
					return false;
				}
			}
		}
		return true;
	}
}
