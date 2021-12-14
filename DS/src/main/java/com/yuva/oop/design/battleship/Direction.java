package com.yuva.oop.design.battleship;

public enum Direction {

	HORIZONTAL("H"),
	VERTICAL("V");
	private String dir;
	
	Direction(String dir){
		this.dir = dir;
		
	}

	public String getDir() {
		return dir;
	}
	
	
	
}
