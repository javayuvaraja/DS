package com.yuva.leetcode.array;

public class ConnectFourGame {
	public int[][]board;
	public boolean areFourConnected(int player){
		
	    // horizontalCheck 
	    for (int col = 0; col<getWidth()-3 ; col++ ){
	        for (int row = 0; row<getHeight(); row++){
	            if (this.board[row][col] == player && this.board[row][col+1] == player 
	            		&& this.board[row][col+2] == player && this.board[row][col+3] == player){
	                return true;
	            }           
	        }
	    }
	    
	    // verticalCheck
	    for (int row = 0; row< getHeight()-3 ; row++ ){
	        for (int col = 0; col<this.getWidth(); col++){
	            if (this.board[row][col] == player && this.board[row+1][col] == player && 
	            		this.board[row+2][col] == player && this.board[row+3][col] == player){
	                return true;
	            }           
	        }
	    }
	    
	    // ascendingDiagonalCheck or bottom to top
	    for (int row=3; row < getWidth(); row++){
	        for (int col=0; col <  getHeight()-3; col++){
	            if (this.board[row][col] == player && this.board[row-1][col+1] == player 
	            		&& this.board[row-2][col+2] == player && this.board[row-3][col+3] == player)
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
