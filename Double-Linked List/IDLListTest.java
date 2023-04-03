/* Name: Georges Hatem
 * Homework Assignment 3
 * 
 * This "IDLListTest.java" tests whether "IDLList.java" works
 * correctly. Based on the tests that I have performed below, I 
 * believe that "IDLList.java" works correctly and satisfies the 
 * intent of Homework Assignment 3
 * 
 * Date: July 25, 2021
 */



public class IDLListTest {

	public static void main(String[] args) {
	
		// let's try the different addtion methods first since we
		// need values in the double-linked lists and ArrayList to
		// perform the removing and other methods.
		
		// let's go ahead and add it first using the add(E elem) method:
		
		IDLList<String> n1 = new IDLList<String>();
		
		n1.add("Tom");
		n1.add(1, "Jerry");
		n1.add(2, "Coco");
		n1.add(3, "Stella");
		n1.add(4, "Bailey");
		
		System.out.println("Size: " + n1.size());
		System.out.println(n1);
		
		// let's test the get(int) method and other ones:
		
		System.out.println("Element at index 3 should be Stella: " + n1.get(3));
		System.out.println("Head of list should be Tom: " + n1.getHead());
		System.out.println("Tail of list should be Bailey: " + n1.getLast());
		
		// let's test the append method:
		
		n1.append("Max");
		System.out.println("Size: " + n1.size());
		System.out.println(n1);
		
		// let's see how the remove method works
		
		n1.remove();
		System.out.println("Size: " + n1.size());
		System.out.println(n1);
		
		n1.remove("Coco");
		System.out.println("Size: " + n1.size());
		System.out.println(n1);
		
		n1.removeAt(1);
		System.out.println("Size: " + n1.size());
		System.out.println(n1);
		
		n1.removeLast();
		System.out.println("Size: " + n1.size());
		System.out.println(n1);
		
		System.out.println("Element at index 1 should be Bailey: " + n1.get(1));
		System.out.println("Element at index 0 should be Jerry: " + n1.getHead());
		System.out.println("Element at index 1 (last) should be Bailey: " + n1.getLast());
		
		n1.append("Cooper");
		System.out.println("Size: " + n1.size());
		System.out.println(n1);
		
		n1.add(1, "Oliver");
		System.out.println("Size: " + n1.size());
		System.out.println(n1);
		
		n1.add("Bruno");
		System.out.println("Size: " + n1.size());
		System.out.println(n1);
		
		n1.add(0, "Toby");
		System.out.println("Size: " + n1.size());
		System.out.println(n1);
		
		// let's do the same thing with decimal just to see if it 
		// works with decimal as well
		
		IDLList<Double> n2 = new IDLList<Double>();
		
		n2.add(17.224);
		n2.add(1, 19.547);
		n2.add(2, 22.325);
		n2.add(3, 102.454);
		n2.add(4, 175.890);
		
		System.out.println("Size: " + n2.size());
		System.out.println(n2);
		
		// let's test the get(int) method and other ones:
		
		System.out.println("Element at index 3 should be 102.454: " + n2.get(3));
		System.out.println("Head of list should be 17.224: " + n2.getHead());
		System.out.println("Tail of list should be 175.890: " + n2.getLast());
		
		// let's test the append method:
		
		n2.append(99.876);
		System.out.println("Size: " + n2.size());
		System.out.println(n2);
		
		// let's see how the remove method works
		
		n2.remove();
		System.out.println("Size: " + n2.size());
		System.out.println(n2);
		
		n2.remove(19.547);
		System.out.println("Size: " + n2.size());
		System.out.println(n2);
		
		n2.removeAt(1);
		System.out.println("Size: " + n2.size());
		System.out.println(n2);
		
		n2.removeLast();
		System.out.println("Size: " + n2.size());
		System.out.println(n2);
		
		System.out.println("Element at index 1 should be 175.89: " + n2.get(1));
		System.out.println("Element at index 0 should be 22.325: " + n2.getHead());
		System.out.println("Element at index 1 (last) should be 175.89: " + n2.getLast());
		
		n2.append(76.654);
		System.out.println("Size: " + n2.size());
		System.out.println(n2);
		
		n2.add(1, 13.234);
		System.out.println("Size: " + n2.size());
		System.out.println(n2);
		
		n2.add(87.567);
		System.out.println("Size: " + n2.size());
		System.out.println(n2);
		
		n2.add(0, 14.345);
		System.out.println("Size: " + n2.size());
		System.out.println(n2);
	
	}

}
