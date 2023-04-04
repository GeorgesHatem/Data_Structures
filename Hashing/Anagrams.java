/**
 * Name: Georges Hatem
 * CS570 Homework Assignment 6
 * 
 * This program is about the concept of hashing. Basically, there are 4 essential methods in the program:
 * The buildLetterTable method creates a hash table with the first 26 numbers hashed into characters a through
 * z (e.g. a = 2, b = 3, c = 5, etc)
 * The myHashCode method finds the hash code value that we need to have into anagram table to store word
 * into anagram table based on their hash code value
 * The addWord method add a word to anagram table based on the hash code value 
 * The getMaxEntries method gets all the entries that has a maximum list size. For example, if 3 entries
 * in anagram table have the same list size and that size is the maximum size between all lists in anagram
 * table, then it will display all these 3 list sizes.
 * 
 * Due Date: August 18, 2021
 * 
 * @author georgeshatem
 * 
 */


import java.util.*; // import the util library
import java.io.*; // import the io library 

public class Anagrams {
	
	// primes represents the first 26 prime numbers as said in assignment instructions to be intialized
	final Integer[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
	
	// letterTable is a hash table that will have the prime numbers above hashed for each character (e.g. a = 2, b = 3 c= 5, etc)
	Map<Character, Integer> letterTable;
	
	// anagram table is a hash table that will have the list of anagrams hashed based on their hash code
	Map<Long, ArrayList<String>> anagramTable;
	
	public Anagrams() {
		
		buildLetterTable(); // call buildLetterTable as instructed per assignment instructions
		
		// Define anagramTable. Cannot define it in addWord method because it will empty the anagramTable every time a word is added
		anagramTable = new HashMap<Long, ArrayList<String>>();

	}
	
	private void buildLetterTable() {
		
		// Define letterTable 
		letterTable = new HashMap<Character, Integer>();
		Character charrArray [] = new Character[26]; // characters a through z are 26 characters
		charrArray[0] = 'a'; // start with a 
		// store letters a through z in charrArray
		for (int i = 1; i < charrArray.length; i++) {
			
			// add 1 to the previous character and cast it to char to obtain the current character
			charrArray[i] = (char) (charrArray[i-1] + 1); 
			
			
		}
		
		for (int i = 0; i < charrArray.length; i++) {
			
			// Hash prime numbers above to each character (e.g. a = 2, b = 3, c = 5. etc)
			letterTable.put(charrArray[i], primes[i]);
			
			
		}
		
		
		
	}
	
	/**
	 * 
	 * @param s String added as input
	 * @return return the value of the hash code of s
	 * 
	 */
	
	private Long myHashCode(String s) {
		
		// Value is 1 because at first it multiplies the long of the first character by 1 to get the first character value in value (variable)
		long value = 1;
		
		for (int i = 0; i < s.length(); i++) {
			
			/*
			 * 
			 * Multiply the value by the value of the character at i.
			 * values of character at i are taken based on lettertable and what I did for hashing there
			 * e.g. a = 2, b = 3, c = 5, etc 
			 * 
			 */
			value = (value)*(letterTable.get(s.charAt(i)));
			
			
		}
		
		return value; // return the value
		
		
	}
	
	/**
	 * 
	 * @param s String added as input
	 * 
	 */
	
	public void addWord(String s) {
		
		// hashCode is the value returned from the myHashCode method
		long hashCode;
		
		hashCode = myHashCode(s); // Value of String s returned from myHashCode method
		
		if(anagramTable.containsKey(hashCode)) {
			
			/*
			 *  If anagramTable already has the hashCode value above,
			 *  then, all we have to do is add s to the hashCode value list in the anagramTable
			 * 
			 */
			anagramTable.get(hashCode).add(s);
			
		}
		
		else {
			
			/*
			 * If the anagramTable does not have the hashCode value above,
			 * then what needs to be done is storing that String value in a list and then
			 * put the list in the anagramTable for this new hashCode value
			 */
			ArrayList <String> hashStringList = new ArrayList<String>(); // Make a list
			hashStringList.add(s); // Add s to the list
			anagramTable.put(hashCode, hashStringList); // Add list to the new added hashCode value in anagramTable
			
			
		}
		
	}
	
	/**
	 * 
	 * @return return all the possible lists that have the maximum size of entry list. For example, if 
	 * the maximum size of entry list is 15, and there are 3 entry lists in the anagramTable, then it
	 * will return all 3 of them
	 * 
	 */
	
	private ArrayList<Map.Entry<Long, ArrayList<String>>> getMaxEntries(){
		
		// Define maximum size of entry list as 0 first 
		int maxEntry = 0;
		
		/*
		 * maxStringList will store all the possible lists that have the maximum size of entry list
		 * For example if the maximum size of entry list is 15 and there are 3 entry lists in the 
		 * anagramTable with size 15, then it will display all 3 of them
		 */
		ArrayList <Map.Entry<Long, ArrayList<String>>> maxStringList = new ArrayList<>();
		
		// Loop through all entries in anagramTable
		for (Map.Entry<Long, ArrayList<String>> oneEntry : anagramTable.entrySet()) {
			
			// Compare the value of the size of the current entry list in the loop to the max value
			if(oneEntry.getValue().size() > maxEntry) {
				
				// if the current size value of the entry list is bigger than max, then
				maxStringList.clear(); // clear the maxStringList since other previous lists may have been added there
				maxStringList.add(oneEntry); // Add that list to it
				maxEntry = oneEntry.getValue().size(); // Get the size of it
				
				
			}
			
			// if the size of the current entry list is equal to max, then
			else if (oneEntry.getValue().size() == maxEntry) {
				
				// Add that list to maxStringList
				maxStringList.add(oneEntry);
				
				
			}
			
			
		}
		
		return maxStringList; // return maxStringList
		
		
	}
	
	// Code provided by the assignment instructions
	private void processFile(String s) throws IOException{
		
		FileInputStream fstream = new FileInputStream( s );
		BufferedReader br = new BufferedReader(new InputStreamReader( fstream ));
		String strLine;
		
		while((strLine = br.readLine()) != null) {
			
			this.addWord( strLine );
			
		}
		
		br.close();
		
	}
	
	// Code provided by the assignment instructions
	public static void main(String[] args) {
		
		Anagrams a = new Anagrams();
		final long startTime = System.nanoTime();
		
		try {
			
			a.processFile("words_alpha.txt");
			
			
		}
		
		catch(IOException e1) {
			
			e1.printStackTrace();
		
			
		}
		
		ArrayList <Map.Entry<Long, ArrayList<String>>> maxEntries = a.getMaxEntries();
		final long estimatedTime = System.nanoTime() - startTime;
		final double seconds = ((double) estimatedTime / 1000000000);
		System.out.println("Time: "+ seconds);
		System.out.println("List of max anagrams: "+ maxEntries);
		
	}

}
