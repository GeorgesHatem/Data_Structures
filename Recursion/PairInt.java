/*
 * Name: Georges Hatem
 * Homework Assignment 4
 * 
 * This is basically the PairInt class with all the methods asked for
 * in the assignment such as setting the constructor and setX(int x),
 * setY(int y), getX(), getY(), boolean equals (Object p), 
 * String toString(), PairInt copy()
 * 
 * Date: August 8, 2021
 * 
 */



public class PairInt {

	// Define x and y as private integers
	private int x;
	private int y;
	
	// Constructor
	public PairInt(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	// Set x value to be the entered x value
	public void setX(int x) {
		
		this.x = x;
		
		
	}
	
	// Set y value to be the entered y value
	public void setY(int y) {
		
		this.y = y;
	
	}
	
	// Get x 
	public int getX() {
		
		return x;
		
	}
	
	// Get y
	public int getY() {
		
		return y;
		
	}
	
	// p is an object of the class PairInt
	// Call p.getX() and p.getY() and check if they are equal to x
	// and y, respectively to check for equality
	public boolean equals (PairInt p) {
		
		if (p.getX() == x && p.getY() == y) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	// String toString() method to return (x,y) values
	public String toString() {
		
		String a = "(" + x + ", " + y + ")";
		return a;
		
			
		}
	
	// new copy of PairInt
	public PairInt copy() {
		
		PairInt copy = new PairInt (x,y);
		return copy;
		
	}
	
	}


