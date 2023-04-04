/*
 * Name: Georges Hatem
 * CS570 Homework Assignment 5
 * 
 * This program implements the addition, removal, and finding of nodes in a Treap.
 * 
 * Date: August 15, 2021 
 */


import java.util.Random; // import Random library to create random variables
import java.util.Stack; // import Stack to create a stack for addition method

public class Treap<E extends Comparable <E>> {
	
	private Random priorityGenerator; // Define priorityGenerator as Random type
	private Node<E> root; // Define the root node as Node<E> type class
	
	
	private static class Node<E extends Comparable <E>> implements Comparable<Node<E>>{
		
		/*
		 * priority and data are both needed to define the Treap, which is a combination
		 * of a Binary Search Tree (BST) and a heap
		 * left and right determines the direction the parent node is referring to (which
		 * child node is referring to) for example root.left will be referring to the 
		 * left child node of root.
		 */
		public E data; 
		public int priority; 
		public Node<E> left;
		public Node<E> right;
		
		// Constructor - Added constructor as mentioned in the assignment
		public Node(E data, int priority) {
			
			this.data = data;
			this.priority = priority;
			this.left = null;
			this.right = null;
			
		}
		
		// Added to compare data values since they are of E type
		@Override
		public int compareTo(Treap.Node<E> o) {
			return data.compareTo(o.data);
		}
		
		// rotateRight method
		Node<E> rotateRight(){
			
			// Define reheapNode. This will be the parent Node and will take in the data
			// and priority of the parent node
			Node<E> reheapNode = new Node(data, priority);
			
			// If the left child and right child are not null, then reheap right will be
			// equal to right child. Also, left child must be not null to rotate right
			if ((this.left != null) && (this.right != null)) {
				
				reheapNode.right = this.right;
				
				
			}
			
			// left child should be not null for right rotation. If left child is not null
			// and left child has a right child, then left reheap is equal to the right child
			// of the left child 
			if ((this.left != null) && (this.left.right != null)) {
				
				reheapNode.left = this.left.right;
				
				
			}
			
			// If left child is not null, which should be for right rotation, then
			if (this.left != null) {
				
				// Set priority of parent node equal to left child priority
				this.priority = this.left.priority;
				// Set data of parent node equal to left child data
				this.data = this.left.data;
				// Set the reheapNode(parent node) to be as the right child of the left child
				// (left child - which becomes the parent after rotation)
				this.right = reheapNode;
				
			}
			
			// left child should always be not null for right rotation
			if (this.left != null) {
				// If the left child of the left child is not null, then set the left child
				// equal to the left child of the left child
				if (this.left.left != null) {
					
					this.left = this.left.left;
					
					
				}
				
				// else the left child should be null since parent becomes right child and 
				// left child basically is null
				else {
					
					this.left = null;
					
					
				}
				
				
				
				
				
			}
			
			return this;
			
			
		}
		
		// rotateLeft method
		Node<E> rotateLeft(){
			
			// Define reheapNode. This will be the parent Node and will take in the data
			// and priority of the parent node
			Node<E> reheapNode = new Node(data, priority);
			
			// If the right child and left child are not null, then reheap left will be
			// equal to left child. Also, right child must be not null to rotate left
			if ((this.right != null) && (this.left != null)) {
				
				reheapNode.left = this.left;
				
				
			}
			
			// Right child should be not null for left rotation. If right child is not null
			// and right child has a left child, then right reheap is equal to the left child
			// of the right child
			if ((this.right != null) && (this.right.left != null)) {
				
				reheapNode.right = this.right.left;
				
				
			}
			
			// If right child is not null, which should be for left rotation, then
			if (this.right != null) {
				// Set priority of parent node equal to right child priority
				this.priority = this.right.priority;
				
				// Set data of parent node equal to right child data
				this.data = this.right.data;
				
				// Set the reheapNode(parent node) to be as the left child of the right child
				// (right child - which becomes the parent after rotation)
				this.left = reheapNode;
				
			}
			
			// Right child should always be not null for left rotation
			if (this.right != null) {
				
				// If the right child of the right child is not null, then set the right child
				// equal to the right child of the right child
				if (this.right.right != null) {
					
					this.right = this.right.right;
					
					
				}
				
				// else the right child should be null since parent becomes left child and 
				// right child basically is null
				else {
					
					this.right = null;
					
					
				}
				
			}

			
			return this;
			
			
			
			
		}
		
		
	}
	
	// Constructor without seed being added to Random()
	public Treap() {
		
		priorityGenerator = new Random();
		root = null;
		
	}
	
	// Constructor with seed added to Random()
	public Treap(long seed) {
		
		priorityGenerator = new Random(seed);
		root = null;
	
	}
	
	// Addition method
	boolean add (E key, int priority) {
		
		// Create a node that takes in the key and priority feed into the add method inputs
		Node<E> newNode = new Node<E>(key, priority);
		// Define a node named temp1 equal to root to start from the root
		Node<E> temp1 = root;
		// Define a stack to push the node and then pop them later on
		Stack <Node> stackNode = new Stack<Node>();
		
		// if the root is null, then the only thing needed to be done is adding the node
		// with key and priority as the root node
		if(root == null) {
			
			root = new Node(key, priority);
			return true;
			
		}
		
		else {
			// As long as temp1 is not null
			while (temp1 != null) {
				
				// Push the temp1 node into the stack (that's the parent and we are finding
				// the child after that)
				stackNode.push(temp1);
				
				// If key is equal to the data of temp1 node, then return false since we
				// do not want to have equal data of nodes
				if (key.compareTo(temp1.data) == 0) {
					
					return false;
					
					
				}
				
				// If key is bigger than the data of temp1 node, then add child node to the right
				else if (key.compareTo(temp1.data) > 0) {
					
					temp1 = temp1.right;
					
					
				}
				
				// If key is less than the data of temp1 node, then add child node to the left
				else {
					
					temp1 = temp1.left;
					
				
				}
				
					
			}
			
			// After figuring out where temp1 should go create if statements and if it goes
			// as a right child then peeking right should give us the newNode 
			if (key.compareTo((E) stackNode.peek().data) > 0) {
				
				stackNode.peek().right = newNode;
				
				
			}
			
			// If temp1 goes as a left child, then peeking left will give us the newNode
			else {
				
				stackNode.peek().left = newNode;
				
			
			}
			
			// Push the newNode into the stack
			stackNode.push(newNode);
			// Call the reheap(stack) method to work out the priority side
			reheap(stackNode);
			// return true
			return true;
		
		}
		
		
		
	}
	
	boolean add(E key) {
		
		// Make n equal to 100 to limit random integer values to be between 0 and 99
		// so that we do not obtain big negative or big positive values but we are still
		// randomizing
		int n = 100;
		int priorityy; // priorityy is the integer to be added into the boolean add method above
		priorityy = priorityGenerator.nextInt(n); // random values between 0 and 99
		return add(key, priorityy); // return based on the add method above
		
		
	}
	
	boolean delete (E key){

		Node<E> node = root; // Define node equal to root so that we start at the root
		Node<E> nodeToRemove = null; // This is the node that should be removed
		Node<E> parentNode = null; // This is the parent node of the node that should be removed
		Node<E> nodeToRemoveParentStore = null; // This is also the parent node of the node that should be removed
		
		// As long as we do not reach the end of the treap
		while (node != null){
			
			// If key equal to node data, then we found our node that should be removed
			// So break out of the while loop
			if ((key.compareTo(node.data)) == 0){

				nodeToRemove = node;				
				break;

			}
			
			// If key is bigger than the node data, then go search on the right of the node
			// to be able to find the node that should be removed
			else if ((key.compareTo(node.data)) > 0){

				parentNode = node; // Set parentNode equal to node so that you have the parent node of the node that should be removed
				node = node.right;


			}
			
			// If key is smaller than the node data, then go search on the left of the node
			// to be able to find the node that should be removed 
			else{
				
				parentNode = node; // Set parentNode equal to node so that you have the parent node of the node that should be removed
				node = node.left;


			}



		}		 

		// If node that should be removed was not found or root is null then return false	
		if (nodeToRemove == null || root == null) {
				
				
			return false;


		}

		else{

			// If the left and right nodes of the node that should be removed are null, then
			if ((nodeToRemove.left == null) && (nodeToRemove.right == null)){

				// if left parent node is not null and key is equal to left parent node data, then we found the node that should be removed
				if((parentNode.left != null) && ((key.compareTo(parentNode.left.data) == 0))) {
					
					parentNode.left = null; // remove the node that should be removed
					return true; // return true
					
				}
				
				// if right parent node is not null and key is equal to right parent node data, then we found the node that should be removed
				else if ((parentNode.right != null) && ((key.compareTo(parentNode.right.data) == 0))) {
					
					parentNode.right = null; // remove the node that should be removed
					return true; // return true
					
					
				}
				
				else {
					
					return false;
					
					
				}
				
				
			}

			else{
				
				// while node to remove left or right child are not null, then keep looping 
				while ((nodeToRemove.left != null) || (nodeToRemove.right != null)){

					// if node to remove left child is not null and right child is not null, then
					if ((nodeToRemove.left != null) && (nodeToRemove.right != null)){

						// if left child priority is bigger than right child priority, then rotate right
						if ((nodeToRemove.left.priority) > (nodeToRemove.right.priority)){
							
							// Store the parent node everytime to remove the child node at the end 
							nodeToRemoveParentStore = nodeToRemove.rotateRight();
							nodeToRemove = nodeToRemoveParentStore.right;
						
		
						}
					
						// If right child priority is bigger than left child priority, then rotate left
						else if ((nodeToRemove.left.priority) < (nodeToRemove.right.priority)){
							
							// Store the parent node everytime to remove the child node at the end
							nodeToRemoveParentStore = nodeToRemove.rotateLeft();
							nodeToRemove = nodeToRemoveParentStore.left;


						}	



					}
					
					// if node to remove left child is not null but right child is null then
					else if (nodeToRemove.left != null){

						// Store the parent node everytime to remove the child node at the end
						nodeToRemoveParentStore = nodeToRemove.rotateRight();
						nodeToRemove = nodeToRemoveParentStore.right;
			

					}
					
					// if node to remove right child is not null but left child is null, then
					else {

						// Store the parent node everytime to remove the child node at the end
						nodeToRemoveParentStore = nodeToRemove.rotateLeft();
						nodeToRemove = nodeToRemoveParentStore.left;


					}

				
				}
				
				// After finding the node to remove and parent node of it, check if node to remove left and right child are null
				if((nodeToRemove.left == null) && (nodeToRemove.right == null)) {

					// if parent node left child is not null and key is equal to node to parent node left child data, then					
					if((nodeToRemoveParentStore.left != null) && (key.compareTo(nodeToRemoveParentStore.left.data) == 0)) {
					
						// remove the parent node left child which is the node that should be removed
						nodeToRemoveParentStore.left = null;
						return true;
					
					
					}
				
					// if parent node right child is not null and key is equal to parent node right child data, then
					else if ((nodeToRemoveParentStore.right != null) && ((key.compareTo(nodeToRemoveParentStore.right.data) == 0))) {
						
						// remove the parent node right child which is the node that should be removed
						nodeToRemoveParentStore.right = null;
						return true;
					
					}
					
					else {
						
						return false;
						
							
					}
				
				}
				
				else {
					
					return false;
					
					
				}
				

			}





		}




	}
	
	private void reheap(Stack <Node> stackNode) {
		
		Node<E> lastNodeAdded, lastNodeAddedParent; // node added last and its parent
		
		lastNodeAdded = stackNode.pop(); // pop the stack one time to get the node added last
		lastNodeAddedParent = stackNode.pop(); // pop the stack a second time to get the node added before last (parent to last node added)
		
		// As long as parent node is not null and last node priority is bigger than the parent prioirty, then we need to rotate
		while ((lastNodeAddedParent != null) && ((lastNodeAdded.priority) > (lastNodeAddedParent.priority))) {
			
			// if the last added node is a right child of the parent node, then rotate Left
			if (((lastNodeAdded.data).compareTo(lastNodeAddedParent.data)) > 0) {
				
				lastNodeAddedParent.rotateLeft();
				
			
			}
			
			// if the last added node is a left child of the parent node, then rotate Right
			else {
				
				
				lastNodeAddedParent.rotateRight();
				
				
				
			}
			
			// if stack is not empty
			if(!stackNode.isEmpty()) {
				
				lastNodeAddedParent = stackNode.pop(); // pop the stack
				
			}
			
			else {
				
				lastNodeAddedParent = null; // Set parent node as null
			}
		
			
		}
		
		
	}
	
	
	private boolean find(Node<E> root, E key) {
		
		Node<E> temp = root; // Start at the root
		
		// if key is null, then trow null pointer exception
		if (key == null) {
			
			throw new NullPointerException("Cannot search treap because key is null");
			
			
		}
		
		else {
		
			// As long as we do not reach the end of the tree, then keep looping
			while(temp != null) {
			
				// if key is equal to the node data, then node found so return true
				if (key.compareTo(temp.data) == 0) {
				
					return true;
				
				
				}
			
				// if key is bigger than the node's data, then search on the right
				else if (key.compareTo(temp.data) > 0) {
				
					temp = temp.right;
				
				
				}
			
				// if the key is smaller than the node's data, then search on the left
				else {
				
					temp = temp.left;
				
			
				}
			
			
			}
	
		}
		
		return false; // return false if nothing found 
		
		
	}
	
	boolean find(E key) {
		
		return find(root, key); // start at the root and find the key
	
		
	}
	
	public String toString() {
		
		// Start at depth 1
		int treapDepth = 1;
		StringBuilder str1 = new StringBuilder(); // Initialize a StringBuilder object to build the string  
		return printStringData(root, treapDepth, str1); // Start at root and build your string
	
		
	}
	
	private String printStringData(Node<E> node, int treapDepth, StringBuilder str1) {
		
		// Everytime a node is printed, indetation (tab) is added
		for (int i = 1; i < treapDepth; i++) {
			
			str1.append("   ");
			
			
		}
		
		// if node is null, then display null
		if (node == null) {
			
			str1.append("null");
			str1.append("\n");
			
			
		}
		
		// if node is not null, then display ( key=x , priority =y)
		else {
			
			str1.append("( key =" + node.data + " , priority =" + node.priority + ")");
			str1.append("\n"); // Go to next line
			// recursive call left and then call recursively right to get all left and then right values
			printStringData(node.left, treapDepth + 1, str1);
			printStringData(node.right, treapDepth + 1, str1); 
			
			
		}
		
		return str1.toString(); // return string once done with recursion

	}
	
	
}
