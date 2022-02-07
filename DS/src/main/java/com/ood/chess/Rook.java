package com.ood.chess;

public class Rook extends Piece {

	  public Rook(boolean white) {
	    super(white);
	  }


	  @Override
	  public boolean canMove(Board board, Box start, Box end) {
	    // we can't move the piece to a box that has a piece of the same color
	    if(end.getPiece().isWhite() == this.isWhite()) {
	      return false;
	    }
	    
	    if (end.getX() == start.getX() ||
	    		end.getY() == start.getY()) {
	    	return true;
	    }
	    return false;

	  }


}