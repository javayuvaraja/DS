package com.ood.chess;

/**
Valid King move, if the piece moves from (X1, Y1) to (X2, Y2), the move is valid if and only if |X2-X1|<=1 and |Y2-Y1|<=1.

Valid Bishop move, if the piece moves from (X1, Y1) to (X2, Y2), the move is valid if and only if |X2-X1|=|Y2-Y1|.

Valid Rook move, if the piece moves from (X1, Y1) to (X2, Y2), the move is valid if and only if X2=X1 or Y2=Y1.

Valid Queen move, a queen's move is valid if it is either a valid bishop or rook move.

Valid Knight move, if the piece moves from (X1, Y1) to (X2, Y2), the move is valid if and only if (|X2-X1|=1 and |Y2-Y1|=2) or (|X2-X1|=2 and |Y2-Y1|=1).

Valid Pawn move, if the piece moves from (X1, Y1) to (X2, Y2), the move is valid if and only if X2=X1 and Y2-Y1=1 (only for a white pawn).
 * @author Yuvaraja Kanagarajan
 *
 */
public abstract class Piece {

	  private boolean killed = false;
	  private boolean white = false;

	  public Piece(boolean white) {
	    this.setWhite(white);
	  }

	  public boolean isWhite() {
	    return this.white == true;
	  }

	  public void setWhite(boolean white) {
	    this.white = white;
	  }

	  public boolean isKilled() {
	    return this.killed == true;
	  }

	  public void setKilled(boolean killed) {
	    this.killed = killed;
	  }

	  public abstract boolean canMove(Board board, Box start, Box end);
	}