package com.ood.chess;

public class Bishop extends Piece {

	  public Bishop(boolean white) {
	    super(white);
	  }


	  @Override
	  public boolean canMove(Board board, Box start, Box end) {
	    // we can't move the piece to a box that has a piece of the same color
	    if(end.getPiece().isWhite() == this.isWhite()) {
	      return false;
	    }

	    return Math.abs(end.getX()-start.getX()) == Math.abs(end.getY()-start.getY());
	  }


}