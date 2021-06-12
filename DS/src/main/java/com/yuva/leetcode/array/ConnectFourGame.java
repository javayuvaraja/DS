package com.yuva.leetcode.array;

public class ConnectFourGame {
	public int[][]board;
	public boolean areFourConnected(int player){
		
	    // horizontalCheck 
	    for (int j = 0; j<getHeight()-3 ; j++ ){
	        for (int i = 0; i<getWidth(); i++){
	            if (this.board[i][j] == player && this.board[i][j+1] == player 
	            		&& this.board[i][j+2] == player && this.board[i][j+3] == player){
	                return true;
	            }           
	        }
	    }
	    
	    // verticalCheck
	    for (int i = 0; i<getWidth()-3 ; i++ ){
	        for (int j = 0; j<this.getHeight(); j++){
	            if (this.board[i][j] == player && this.board[i+1][j] == player && 
	            		this.board[i+2][j] == player && this.board[i+3][j] == player){
	                return true;
	            }           
	        }
	    }
	    
	    // ascendingDiagonalCheck 
	    for (int i=3; i<getWidth(); i++){
	        for (int j=0; j<getHeight()-3; j++){
	            if (this.board[i][j] == player && this.board[i-1][j+1] == player 
	            		&& this.board[i-2][j+2] == player && this.board[i-3][j+3] == player)
	                return true;
	        }
	    }
	    
	    // descendingDiagonalCheck
	    for (int i=3; i<getWidth(); i++){
	        for (int j=3; j<getHeight(); j++){
	            if (this.board[i][j] == player && this.board[i-1][j-1] == player 
	            		&& this.board[i-2][j-2] == player && this.board[i-3][j-3] == player)
	                return true;
	        }
	    }
	    return false;
	}
	
	private int getHeight() {
		return 6;
	}
	private int getWidth() {
		return 6;
	}
}
