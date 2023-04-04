/*
 * Name: Georges Hatem 
 * CS570 Homework Assignment 5
 * 
 * This is to test the Treap.java and see if it works correctly. I provided a detailed
 * description of my testing below
 * 
 * Date: August 15, 2021
 */

public class treapTest {

	public static void main(String[] args) {
		/*
		 *When running Test 7, please comment out these added values at the beginning and
		 *the testTree object definition since I made a new object to run random(seed) 
		 * 
		 */
		
		
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4, 19);
		testTree.add(2, 31);
		testTree.add(6, 70);
		testTree.add(1, 84);
		testTree.add(3, 12);
		testTree.add(5, 83);
		testTree.add(7, 26);
		
		// Test 1
		/*
		 * This testing below and all other testing test the same outcomes
		 * Each test is ran separetly so test 2 is ran by hiding all other tests and only
		 * running test 2 and same for all other testings (e.g. test 1, test 3, etc)
		 * The outcomes that I am testing are to check whether addition, deletetion and 
		 * finding work
		 * First, thing is adding then after adding, finding a key that I added then after
		 * that deleting a key added to the treap
		 * 
		 * 
		 * Basically, I first printed the addition of the above and checked if my output is
		 * correct. Then, I founded a key that is in the treap and check whether I obtain
		 * true or false to see if my find methods are correct. Then, I deleted a key (already
		 * existent on the treap) from the treap and checked whether if my deletetion method
		 * display false or true when printed and whether it prints the output of the 
		 * treap correctly with the key asked to be removed removed.
		 * 
		 * Then, I tested these methods again for keys that are not existent on the treap.
		 * I tested my finiding method for a key non-existent on the treap and it returned
		 * false. Same answer for my deletetion method. I tested it for a key that is non-
		 * existant on the treap and it returned false. And then I tried adding a key that
		 * is on the treap and my addition method returned false as expected and did not add
		 * it to the treap
		 * 
		 * This test is repeated many times for different nodes in the treap to check whether
		 * it works only for this node or for others as well.
		 */
		
		System.out.println(testTree.toString());
		System.out.println(testTree.find(6));
		System.out.println(testTree.delete(6));
		System.out.println(testTree.toString());
		System.out.println(testTree.find(6));
		System.out.println(testTree.delete(6));
		System.out.println(testTree.add(1, 98));
		System.out.println(testTree.toString());
	
		// Test 2
		
		/*
		 * Test 2 is performed without performing test 1. But for a different node.
		 *
		 */
		/*
		
		System.out.println(testTree.toString());
		System.out.println(testTree.find(5));
		System.out.println(testTree.delete(5));
		System.out.println(testTree.toString());
		System.out.println(testTree.find(5));
		System.out.println(testTree.delete(5));
		System.out.println(testTree.add(1, 98));
		System.out.println(testTree.toString());
		*/
		
		// Test 3
		/*
		System.out.println(testTree.toString());
		System.out.println(testTree.find(1));
		System.out.println(testTree.delete(1));
		System.out.println(testTree.toString());
		System.out.println(testTree.find(1));
		System.out.println(testTree.delete(1));
		System.out.println(testTree.add(5, 98));
		System.out.println(testTree.toString());
		System.out.println(testTree.add(1, 84));
		System.out.println(testTree.toString());
		*/
		// Test 4
		/*
		System.out.println(testTree.toString());
		System.out.println(testTree.find(3));
		System.out.println(testTree.delete(3));
		System.out.println(testTree.toString());
		System.out.println(testTree.find(3));
		System.out.println(testTree.delete(3));
		System.out.println(testTree.add(5, 98));
		System.out.println(testTree.toString());
		
		*/
		
		// Test 5
		/*
		System.out.println(testTree.toString());
		System.out.println(testTree.find(7));
		System.out.println(testTree.delete(7));
		System.out.println(testTree.toString());
		System.out.println(testTree.find(7));
		System.out.println(testTree.delete(7));
		System.out.println(testTree.add(5, 98));
		System.out.println(testTree.toString());
		*/
		
		
		// Test 6
		/*
		 * This should be ran with the values added above as well.
		 * For testing purposes of randomness
		 * This will run random() and not random(seed).
		 * To run random(seed), please refer to Test 7
		 * 
		 */
		/*
		testTree.add(9);
		System.out.println(testTree.toString());
		testTree.add(15);
		System.out.println(testTree.toString());
		*/
		
		// Test 7
		/*
		 * To run test 7, create a new object and run it as a test alone
		 * If you run this test again and again and again you will get the same priority
		 * generated for these seeds since this is the usage of random(seed) so same tree
		 * if you run it multiple times
		 * 
		 */
		
		/*
		Treap<Integer> tr = new Treap<Integer>(15);
		tr.add(15);
		tr.add(10);
		tr.add(5);
		tr.add(12);
		System.out.println(tr.toString());
		
		*/
	}

}
