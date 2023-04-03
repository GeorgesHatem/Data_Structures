/* Name: Georges Hatem
 * Assignment: CS570 HomeworkAssignment1
 * 
 * This is what I used for testing. Tests are commented out since I 
 * believe it will be tested by your values. Please refer to "BinaryNumber.java" for a detailed
 * description of the changes
 * 
 * Date :July 11, 2021
 */

package hw1_G_Hatem;

public class hw1_G_Hatem {

	public static void main(String[] args) {
		
		
		
		// First Test
		
		// let's test BinaryNumber(length) constructor and check its printing
		BinaryNumber b1 = new BinaryNumber(15);
		System.out.println("This should give 15 char of 0s: " + b1.toString());
		
		// let's test BinaryNumber(String) constructor and check its printing
		BinaryNumber b2 = new BinaryNumber("10111011111000101010001");
		System.out.println("This should print 10111011111000101010001: " + b2.toString());
		
		// let's test the getlength() method 
		System.out.println("The length should be 15: " + b1.getLength());
		System.out.println("The length should be 23: " + b2.getLength());
		
		// let's test the getDigit(index) method
		System.out.println("The digit for elment 15 should be 0: " + b1.getDigit(14));
		System.out.println("The digit for element 23 should be 1: " + b2.getDigit(22));
		for (int i = 0; i < b1.getLength(); i++) {
			
			System.out.print(b1.getDigit(i) + "");
			
		}
		
		System.out.println("");
		
		for(int i = 0; i < b2.getLength(); i++) {
			
			System.out.print(b2.getDigit(i) + "");
			
			
		}
		
		System.out.println("");
		// FIX ME Error - Checking with Ben
		System.out.println("The value at element 16 should give error: " + b1.getDigit(15));
		// FIX ME Error - Checking with Ben
		System.out.println("The value at element 24 should give error: " + b2.getDigit(23));
		// FIX ME Same as Above
		for (int i = b1.getLength() + 2; i>=(b1.getLength() - 1); i--) {
			
			System.out.print(b1.getDigit(i) + "");
			
			
		}
		System.out.println("");
		// FIX ME Same as Above
		for (int i = b2.getLength() + 2; i >= (b2.getLength() - 1); i--) {
			
			System.out.print(b2.getDigit(i) + "");
			
		
		}
		System.out.println("");
		System.out.println("Value sum should be 0: " + b1.toDecimal());
		System.out.println("Value sum should be 4540381: " + b2.toDecimal());
		
		b2.shiftR(2);
		System.out.println("The binary string should be 0010111011111000101010001: " + b2.toString());
		b2.shiftR(5);
		System.out.println("The binary string should be 000000010111011111000101010001: " + b2.toString());
		b2.shiftR(8);
		System.out.println("The binary string should be 00000000000000010111011111000101010001: " + b2.toString());
		b2.shiftR(23);
		System.out.println("The binary string should be (23 0's)00000000000000010111011111000101010001: " + b2.toString());
		
		b1.add(b2);
		b1.shiftR(46);
		b1.add(b2);
		System.out.println("The result of the addition is: (23 0's)00000000000000010111011111000101010001: " + b1.toString());
		
		// Second Test
		
		BinaryNumber b3 = new BinaryNumber("10110");
		BinaryNumber b4 = new BinaryNumber("11101");
		System.out.println("The printed string should be 10110:" + b3.toString());
		System.out.println("The printed string should be 11101: " + b4.toString());
		
		b3.add(b4);
		System.out.println("The string result of addition should be Overflow: " + b3.toString());
		b3.clearOverflow();
		System.out.println("The result of the addtion should be 00100: " + b3.toString());
		
		b3.shiftR(2);
		System.out.println("The string after right shifting is 0000100: " + b3.toString());
		System.out.println("The length after right shifting is 7: " + b3.getLength());
		System.out.println("The digit at index 4 is 1: " + b3.getDigit(4));
		System.out.println("The decimal for binary number b3 is 16: " + b3.toDecimal());
		
		b3.add(b4);
		System.out.println("The string result after addition is 0000100: " + b3.toString());
		
		b4.shiftR(2);
		System.out.println("The string for b4 is 0011101: " + b4.toString());
		
		b3.add(b4);
		System.out.println("The result of the string addition is 0011011: " + b3.toString());
		System.out.println("The result of the length of b3 is 7: " + b3.getLength());
		System.out.println("The result of index 4 is 0: " + b3.getDigit(0));
		System.out.println("The decimal for binary number b3 is 108: " + b3.toDecimal());
		
		b3.clearOverflow();
		System.out.println("The result of the string addtion is 0011011: " + b3.toString());
		
		
		
	}

}
