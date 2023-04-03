/* Name: Georges Hatem
 * Homework Assignment 3
 * 
 * In this homework assignment, we will be working with double-
 * linked lists. We will declare an inner class Node<E> that will 
 * contain 2 constructors. One constructor has an element (data) 
 * of type E as input and another constructor has 3 inputs: an 
 * element (data) of type E, Node<E> prev, and Node<E> next.
 * 
 * We should declare another class and that class has inside of it
 * the inner class Node<E>. We will be implementing different methods
 * for double-linked lists, such as add a node at the beginning of
 * the double-linked lists when the double-linked list is empty,
 * add a node in the middle between 2 nodes by getting the index and
 * the element, appending a double-linked list by adding an element
 * at the end of the list, which cause the tail to move to that new
 * last node, get the index for a node that returns the object at
 * position index from the head, get head that returns the object
 * at the head, get last that returns the object at the tail, the 
 * size method that returns the list size (always updated), removing
 * and returning the element at the specified index, removing and
 * returning the element at the head, removing and returning the
 * element at the tail, returning a string representation of the 
 * list, etc
 * 
 * Date: July 25, 2021
 */



// import ArrayList since we will be using ArrayList
import java.util.ArrayList;

public class IDLList<E> {
	
	 // This is the private inner class Node<E> as described by 
	// homework instructions
	   private class Node<E>
	   {
	       
		   // These are written as assigned by instructions
		   E data;
		   Node<E> next;
	       Node<E> prev;
	      
	       // First Constructor
	       Node(E elem)
	       {
	           data = elem;
	           prev = null;
	           next = null;
	       }
	      
	       // Second Constructor 
	       Node (E elem, Node<E> prev, Node<E> next)
	       {
	           data = elem;
	           this.prev = prev;
	           this.next = next;
	       }
	   }
	  
	   private Node<E> head;
	   private Node<E> tail;
	   private int size; // This is the length of ArrayList or the number of nodes in the list
	   private ArrayList<Node<E>> indices; // ArrayList defined
	  
	   // A constructor for IDLList
	   public IDLList()
	   {
	       head = null;
	       tail = null;
	       size = 0;
	       indices = new ArrayList<Node<E>>();
	   }
	  
	   public boolean add (int index, E elem)
	   {
		       
	       // In this case, we go till <= size because suppose we have 6 elemets
		   // so the size is 6. However, maximum reaches we can reach
		   // for index is 5. But, if we added one node at the end then 
		   // index == size 
	       if(index >= 0 && index <= size)
	       {
	    	   // If index is 0, then perform the method for adding
	    	   // at the beginning
	           if(index == 0) 
	           {
	               add(elem);
	           }
	           
	           // If index is at the end, then perform the method to
	           // append the list (add at the end of the list)
	           else if(index == size) // insert at tail
	           {
	               append(elem);
	           }
	           
	           // Last option is to add a node in between 2 nodes
	           else
	           {
	               // get the node at the index specified
	        	   // This is the current node that currently exists at
	        	   // the specified index above
	               Node<E> curr = indices.get(index);
	               // We now need to create the node that is going to 
	               // sit in the middle between curr and the current node
	               // before curr. So, we need to place the node between
	               // curr and curr.prev
	               Node<E> node = new Node<E>(elem, curr.prev, curr);
	               // After placing node in between, we need to wire everything 
	               // back together. So, we go ahead and do what we were taught
	               // in Chapter 4
	               node.prev.next = node;
	               curr.prev = node;
	               // We add the node to the ArrayList so we have it changed in the
	               // ArrayList as well
	               indices.add(index, node);
	               indices.set(index-1, node.prev);
	               indices.set(index+1, curr);
	               // increase the size by 1 since we added a node
	               size++;
	           }
	          
	           return true;
	       }
	       
	       else {
	    	   
	    	   // As shown on the rubric, error check implemented
	    	   throw new IndexOutOfBoundsException("List Index Out Of Bounds.");
	    	   
	       }
	    
	       
	   }
	  
	   public boolean add(E elem)
	   {
	       // Create a new Node as done above 
	       Node<E> node = new Node<E>(elem, null, head);
	      
	       // 
	       if(head == null)
	           tail = node;
	       else
	       {   // non-empty list
	          
	           // set prev of head to node
	           head.prev = node;
	           // update first node in indices
	           indices.set(0, head);
	       }
	      
	       // update head to node
	       head = node;
	      
	       // insert node at first index in indices
	       indices.add(0, node);
	       size++;
	       return true;
	   }

	   
	   public boolean append (E elem)
	   {
	       // create a new node as discussed above
	       Node<E> node = new Node<E>(elem, tail, null);
	       // The new node will be located after tail. So, tail.next should
	       // gvie a breath of air
	       tail.next = node;
	       // Set the size-1 index to tail
	       indices.set(size-1, tail);
	       // Set tail equal to node because node is the last instructuins from me today
	       tail = node;
	       // Add the node to the ArrayList
	       indices.add(node);
	       // size has been increased by 1 
	       size++;
	       return true;
	   }
	  
	   public E get (int index)
	   {
	       // Check if index is valid 
	       if(index >= 0 && index < size)
	       {
	           // Since we will be returning E, we need to get data = element
	           return indices.get(index).data;
	       }
	       else // As shown per rubric, error checking implemented
	           throw new IndexOutOfBoundsException("List index out of bounds.");
	   }

	   public E getHead ()
	   {
		   // We need to make sure that size > 0 because we need to have
		   // head at in
	       if(size > 0 ) 
	       {
	    	   // return data for head since we need E Type and data = element
	           return head.data;
	       }
	       else // As shown per rubric, error checking implemented
	           throw new IllegalStateException("List is empty");
	      
	   }
	  
	   public E getLast ()
	   {
	       if(size > 0) // Make sure that 
	       {
	    	   // return data for tail since E type needs to be returned
	           return tail.data;
	       }
	       else // As shown per rubric, error checking implemented
	           throw new IllegalStateException("List is empty");
	   }
	  
	   
	   public int size()
	   {
	       return size;
	   }
	  
	   
	   public E remove()
	   {
	       if(size > 0) 
	       {
	           E data = head.data; // get the data at head to display which data to be removed
	           head = head.next; // This will remove head assiciation with the first element in the node and put its association to the 2nd element in the node
	           size--; // Decrease the size by one since we removed one element
	           indices.remove(0); // remove the node at index 0 in indices in ArrayList
	           if(head != null) // after removal list not empty
	           {
	               head.prev = null; // Set the previous head node to null
	               indices.set(0, head); // update element at index 0 to head
	           }
	           else // empty list, set tail to null
	               tail = null;
	          
	          
	           return data;
	       }
	       else // As shown per rubric, error checking implemented
	           throw new IllegalStateException("List is empty");
	   }
	  
	   public E removeLast()
	   {
	       if(size > 0) 
	       {
	           E data = tail.data; // get the data at tail so you can return them and show that they were removed 
	           tail = tail.prev; // This points tail to the node before the current tail node 
	           size--; // Decrease the size since one element has been removed
	           indices.remove(size); // remove the last element from the ArrayList
	          
	           if(tail != null) // after removal list not empty
	           {
	               tail.next = null; // update next of tail to null
	               indices.set(size-1, tail); // update element at size-1 to tail
	           }
	           else //empty list, set head to null
	               head = null;
	          
	           return data;
	       }
	       else // As shown per rubric, error checking implemented
	           throw new IllegalStateException("List is empty");
	   }
	  
	  
	   public E removeAt(int index)
	   {
	       
	       if(index >= 0 && index < size)
	       {
	           if(index == 0) 
	               return remove();
	           else if(index == size-1)
	               return removeLast();
	           else
	           {
	               // Get the node at the specific index
	               Node<E> node = indices.get(index);
	               indices.remove(index); // remove the node at that specific index from ArrayList
	               // update prev of new node at index to node prev to node
	               indices.get(index).prev = node.prev;
	               // update next of node at index-1 to node next to node
	               indices.get(index-1).next = node.next;
	               // remove node from list
	               node.next = null;
	               node.prev = null;
	               size--; // Decrease size by 1 since you removed one elemenet
	               return node.data; // return data of the node removed since this is of type E (data = element)
	           }
	       }
	       else // As shown per rubric, error checking implemented
	           throw new IndexOutOfBoundsException("List index out of bounds.");
	   }

	   public boolean remove(E elem)
	   {
	       // set curr to head
	       Node<E> curr = head;
	       int curr_index = 0; // set curr_index to 0
	      
	       // loop over list to search for elem
	       while(curr != null)
	       {
	           if(curr.data.equals(elem)) // elem found, exit the loop
	               break;
	           curr = curr.next;
	           curr_index++;
	       }
	      
	       if(curr == null) // elem not in list
	           return false;
	       else // elem in list at curr_index, delete the node at curr_index
	       {
	           removeAt(curr_index);
	           return true;
	       }
	   }

	   public String toString()
	   {
	       String str = ""; // set str to empty string
	       Node<E> curr = head; // set curr to head
	      
	       // loop over the list, appending data of nodes to str
	       while(curr != null)
	       {
	           str += curr.data.toString();
	           if(curr != tail) // not the last node
	               str += " -> ";
	           curr = curr.next;
	       }
	      
	       return str;
	   }	

}
