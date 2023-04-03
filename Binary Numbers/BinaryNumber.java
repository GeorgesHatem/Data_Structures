/* Name: Georges Hatem
 * Assignment: CS570 Homework Assignment 1
 * 
 * This program (BinaryNumber.java) has many methods to work with 
 * binary numbers. There are 2 constructors (one that take the length
 * of the binary number and create a binary number (consisting of digits (bits) 0s) 
 * from it and one that take the string of the binary number and create 
 * a binary number from it. Then, there are methods to get the length of 
 * the binary number, get the value of a bit in the binary number at a specific index, 
 * get the decimal value of the binary number, shift the binary number a certain
 * amount to the right, adding 2 binary numbers of the same length together and changing the 
 * boolean overflow variable to true if an overflow existed when adding, clearing the overflow
 * by setting the boolean variable to false, and getting the binary number (after or before 
 * manupilating it) as a string or getting "Overflow" string if an overflow existed 
 * and has not been cleared by calling the toString() method.
 * 
 * The program (hw1_G_Hatem.java) is there to test these methods since
 * it has a main function so we can go ahead and call this class (BinaryNumber)
 * and the public methods inside of it. I tested BinaryNumber.java program
 * with the commented program in hw1_G_Hatem.java and it worked 
 * perfectly
 * 
 * Date: July 11, 2021
 */



package hw1_G_Hatem;
// import this to be able to change character to numeric values (Character.getNumericValue(chara))
import java.lang.*; 
// import this to be able to work with Arrays.copyOf in the reallocate() method
import java.util.Arrays;

public class BinaryNumber {
	
	private int data[]; // Don't completely initiate the array since we are waiting for the length
	private boolean overflow = false; // Set it to false - no overflow yet
	
	public BinaryNumber(int length) {
		
		data = new int [length]; // length is written in main
		
		for (int i = 0; i < data.length; i++) {
			
			data[i] = 0; // store 0s in the data array
			
		}
		
	}
	
	public BinaryNumber(String str) {
		
		char chara;
		data = new int [str.length()]; // array length is the length of the string
		
		for (int i = 0; i < data.length; i++) {
			
			chara = str.charAt(i); // Store character in the string in chara
			
			// changed the stored character in chara to a numeric value
			data[i] = Character.getNumericValue(chara); 
			
			
		}
		
		
	}
	
	public int getLength() {
		
		return data.length; // return the length of the array
		

	}
	
	public int getDigit(int index){
		
		try {
			
			return data[index]; // return the value at the specified index
		
		}
		
		catch(IndexOutOfBoundsException excpt) {
			
			System.out.println(excpt.getMessage()); // create the message when index is out of bounds
			return -1; // return -1 since the getDigit() method requires to return an int
		
		}	
		
		
	}
	
	public int toDecimal() {
		
		int sum = 0;
		double i = 0;
		final double value = 2;
		
		for (int j = 0; j < data.length; j++) {
			// Get the sum of (2^0)*(data[0]) + (2^1)*(data[1]) + etc to get the decimal of the binary number
			sum = (int)((sum) + ((Math.pow(value, i))*(data[j])));
			i = i + 1;
			
		}
		
		return sum; // return the value of the decimal of the binary number
		
		
	}
	
	private int[] reallocate(int amount) {
		
		int newLength; 
		newLength = (data.length) + (amount); // This is the new length of the array
		
		// add 0s at the indexes added to the array (indexes added on the right)
		return Arrays.copyOf(data, newLength); 
		
		
	}
	
	public void shiftR(int amount) {
		
		int amountToShift;
		
		amountToShift = amount;
		
		data = reallocate(amountToShift);
		
		// create an array to store the 0s digits added on the right by the reallocate method
		int [] array = new int[amountToShift];
		
		int j = 0;
		
		for (int i = amountToShift; i > 0; i--) {
			
			// store the digits added by the reallocate method (respectively) in an array
			array[i-1] = data[(data.length) - 1 - j];
			j = j + 1;

		}
	
		for (int i = (data.length - amountToShift - 1); i >= 0; i--) {
			
			// shift each values starting from the right to the left the number of amount it needs to be shifted
			data[i + amountToShift] = data[i]; 
			
			
		}
		
		for (int i = 0; i < amountToShift; i++) {
			
			// store the values that were added to the right by the reallocate method on the left respectively

			data[i] = array[i];
			
			
		}
		
	}
	
	public void add(BinaryNumber aBinaryNumber) {
		
		int carriedDigits = 0; // Initiate carriedDigits to 0
		
		if(data.length != aBinaryNumber.getLength()) {
			
			// In case lengths of both binary number not equals, output this message
			System.out.println("The length of the two (2) arrays do not coincide");
			// return to exit the add method without checking for carriedDigits at the end of the add method
			return;
			
		}
		
		else {
			// Add the binary numbers depending on the digits and carriedDigits 
			// as indicated in section 2.2 of the homework assignment instructions
			for (int i = 0; i < data.length; i++) {
				
				if (carriedDigits == 1) {
					
					if((data[i] == 1) && (aBinaryNumber.getDigit(i) == 1)) {
						
						data[i] = 1;
						carriedDigits = 1;
						
					}
					
					else if ((data[i] == 0) && (aBinaryNumber.getDigit(i) == 0)) {
						
						data[i] = 1;
						carriedDigits = 0;
						
						
					}
					
					else {
						
						data[i] = 0;
						carriedDigits = 1;
					
						
					}
					
				}
				
				else if (carriedDigits == 0) {
					
					if((data[i] == 1) && (aBinaryNumber.getDigit(i) == 1)) {
						
						data[i] = 0;
						carriedDigits = 1;
						
					
					}
					
					else if ((data[i] == 0) && (aBinaryNumber.getDigit(i) == 0)) {
						
						data[i] = 0;
						carriedDigits = 0;
						
						
					}
					
					else {
						
						data[i] = 1;
						carriedDigits = 0;
						
						
					}	
					
				}
				
				
			}
			
		
		}
		
		
		if(carriedDigits == 1) {
			
			overflow = true; // Set overflow to true if there is a carriedDigits at the end
			
			
		}
		
		
	}
	
	public void clearOverflow() {
		// Clear overflow by setting overflow to false. 
		// This will cause the toString() method to output the binary 
		// number without the overflow digit if called before the 
		// toString() method
		overflow = false;
		
		
	}
	
	public String toString() {
		
		// if overflow is true, then return "Overflow" string
		if(overflow == true) {
			
			String overflowstring = "Overflow";
			
			return overflowstring;
			
		}
		
		// if overflow is false (no overflow from the beginning), 
		// then return the string of the binary number
		
		// if overflow was true and then set to false by calling the 
		// clearOverflow() method, then return the string of the 
		// binary number without the overflow digit 
		else {
		
			String strr = "";
		
			for(int i = 0; i < data.length; i++) {
			
				strr = strr + data[i];
		
			
			}
		
			return strr;
			
		}
	} 
	
}
	
