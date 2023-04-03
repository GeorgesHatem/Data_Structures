/* Name: Georges Hatem
 * Homework Assignment 2
 * 
 * This assignment shows the implementation of different methods. These
 * methods are O(N^2), O(N^3), O(log n), O(n log(n)), O(log log n). 
 * These methods are all implemented using for loop and each of these
 * methods increase their number of operations by 1 each time it has been runned 
 * and print it. For example, a method of time complexity O(n^2) 
 * should print out the values from 1 to n^2 since it is operated n^2 times
 * and similar analysis for other methods
 * 
 * Date: July 17, 2021
 */





public class Complexity {
	
	// This method implements O(n^2)
	public static void method1(int n) {
		
		// initialize counter to 1 so that you start your count of operations at 1
		int counter = 1;
		
		// 2 nested for loops and each go from 0 to n to print out the values from 1 to n^2
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				
				System.out.println("Operation " + counter);
				counter++;
				
				
			}
			
		
		}
		
		
	}
	
	// This method implements O(n^3)
	public static void method2(int n) {
		
		// initialize counter to 1 so that you start your count of operations at 1
		int counter = 1;
		
		// 3 nested for loops and each going from 0 to n to print the values from 1 to n^3
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				
				for (int k = 0; k < n; k++) {
					
					System.out.println("Operation " + counter);
					counter++;
					
					
				}
				
						
			}
			
			
		}
		
		
	}
	
	// This method implements O(log(n))
	public static void method3(int n) {
		
		// initialize counter to 1 so that you start your count of operations at 1
		int counter = 1;
		
		// Implement binary search (O(logn))
		for (int i = n/2; i > 0; i = i / 2) {
			
			System.out.println("Operation " + counter);
			counter++;
			
			
		}
		
	}
	
	// This method implements O(nlog(n))
	public static void method4(int n) {
		
		// initialize counter to 1 so that you start your count of operations at 1
		int counter = 1;
		
		// Get the log(n) as above and multiply it by n by putting a for loop that
		// goes from 0 to n
		for (int i = 0; i < n; i++) {
			
			for (int j = n / 2; j > 0; j = j / 2) {
				
				System.out.println("Operation " + counter);
				counter++;
				
				
			}
			
			
		}
		
	}
	
	// This method implements O(log(log(n)))
	public static void method5(int n) {
		
		// counter is needed to get the number of operations to put in the second for loop
		int counter = 1;
		
		// initialize counter1 to 1 so that you start your count of operations at 1 in the 2nd for loop
		int counter1 = 1;
		
		// Get the number of operations for log(n)
		for (int i = n/2; i > 0; i = i / 2) {
			
			counter++;
			
		
		}
		
		// Minus counter by 1 since it was increased by 1 in the last for loop run and don't enter the last increase
		counter--; 
		
		// Insert the log(n) number of operations (meaning counter value) in the 2nd for loop to get and print log(log(n)) number of operations
		for (int i = counter/2; i > 0; i = i / 2) {
			
			System.out.println("Operation " + counter1);
			counter1++;
				
		}
		
		
	}
	
}
