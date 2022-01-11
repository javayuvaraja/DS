package com.ood.chess;

public class Pawn extends Piece {

	  public Pawn(boolean white) {
	    super(white);
	  }


	  @Override
	  public boolean canMove(Board board, Box start, Box end) {
	    // we can't move the piece to a box that has a piece of the same color
	    if(end.getPiece().isWhite() == this.isWhite()) {
	      return false;
	    }

	    int x = Math.abs(start.getX() - end.getX());
	    int y = Math.abs(start.getY() - end.getY());
	    if(x + y == 1) {
	      // check if this move will not result in king being attacked, if so return true
	      return true;
	    }
	    
	    return true;

	  }


}