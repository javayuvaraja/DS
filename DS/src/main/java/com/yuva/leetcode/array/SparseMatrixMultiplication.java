package com.yuva.leetcode.array;

public class SparseMatrixMultiplication {

	public int[][] multiply(int[][] A, int[][] B) {

        int [][]res = new int[A.length][B[0].length];
        boolean []rowA = new boolean[A.length];
        boolean []colB = new boolean[B[0].length];
        // Checking whether first matrix row is having non zero 
        for(int i = 0 ; i < A.length; i++){
            for(int j = 0 ; j < A[0].length; j++)
                if(A[i][j] != 0){
                    rowA[i] = true;
                    break;
                }
        }
        
        // Checking whether first matrix column is having non zero
        for(int j = 0 ; j < B[0].length; j++){
            for(int i = 0 ; i < B.length; i++)
                if(B[i][j] != 0){
                    colB[j] = true;
                    break;
                }
        }

        for(int i = 0 ; i < A.length; i ++){
            for(int k = 0 ; k < B[0].length ; k ++){
                // Checking row or col is zero, if it zero then continue
            	if(!rowA[i] || !colB[k]){
                    res[i][k] = 0;
                    continue;
                }

                int sum = 0;
                for(int j = 0 ; j < A[0].length; j ++){
                    sum += A[i][j] * B[j][k];
                }
                res[i][k] = sum;
            }
        }
        return res;
    }
}
