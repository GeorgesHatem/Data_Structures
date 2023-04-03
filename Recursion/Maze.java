import java.util.Stack;
import java.util.ArrayList;
/**
 * Class that solves maze problems with backtracking.
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() {
        return findMazePath(0, 0); // (0, 0) is the start point.
    }

    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */
    
    /*
     * Name: Georges Hatem
     * CS570: Homework Assignment 4
     * 
     * Added:
     * findMazePath(int x, int y),
     * findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, stack<PairInt> trace)
     * ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y)
     * ArrayList<PairInt> findMazePathMin(int x, int y)
     * 
     * Date: August 8, 2021
     */
    
    /*
     * Below is the implementation of findMazePath(int x, int y) for
     * Problem 1 in the assignment. 
     * 
     */
    public boolean findMazePath(int x, int y) {
       
    	/*
    	 * Basically, as stated in the assignment, if a cell is out of bounds
    	 * then we should return false since a cell outside of the grid cannot
    	 * be a part of a path in the grid. A cell is out of bounds when either 
    	 * x is less than 0, y is less than 0, x is bigger than the number of
    	 * column in the grid, or y is bigger than the number of rows in the 
    	 * grid as written in the program below.
    	 * 
    	 */
    	
    	if(x < 0 || y < 0 || x > (maze.getNCols() - 1) || y > (maze.getNRows() - 1)) {
    		
    		return false; // return false as stated above
    		
    		
    	}
    	
    	/*
    	 * As stated in the assignment, if a cell is not colored red
    	 * (NON_BACKGROUND), then false should be returned as you can
    	 * see below. The user will first input how many rows and columns
    	 * he wants in the grid and then the grid displays and the user
    	 * will click on the cells he/she wants and these cells will be
    	 * highlighted in Red (NON_BACKGROUND). Then after he/she clicks
    	 * solve, we have to find a path that starts with (0,0) and ends
    	 * with (getNCols() - 1, getNRows() - 1). So, as you can see if
    	 * a cell is not red, it cannot be part of the path and this
    	 * is why we are implementing this else if statement
    	 * 
    	 */
    	
    	else if (maze.getColor(x, y) != NON_BACKGROUND) {
    		
    		return false; // return false as stated above
    		
    		
    	}
    	
    	/*
    	 * If we reached the exit cell (the exit cell as stated in the
    	 * assignment is (getNCols() - 1, getNRows() - 1)), then we 
    	 * have reached the end. We should return true in this case and 
    	 * this is how we can exit the recursive calls in the else
    	 * statement. If we do not color the exit cell green (PATH) in
    	 * the else if statement and depend on the else statement below
    	 * to do that, then we would end up with the exit cell being 
    	 * colored either TEMPORARY (Black) if all findMazePath
    	 * (....,....) ended up being false or Green but we will not be
    	 * done yet and this is the reason why this else if statement is
    	 * needed 
    	 */
    	
    	else if ((x == (maze.getNCols() - 1)) && (y == maze.getNRows() - 1)) {
    		
    		maze.recolor(x, y, PATH); // recoloring green any cell that path
    		// through this else if statement
    		return true; // exit recursions since cell has been found
    		
    	}
    	
    	/*
    	 * This statement works like stated in the assignment as well.
    	 * Basically, any cell that enters the else statement below will be
    	 * colored Green at first. Then, we keep calling findMazePath() method recursively
    	 * until we get one of the 4 cells surrounding the cell you have
    	 * to be true. The only way to get it to be true is by reaching the
    	 * exit cell. The job in this method is to call each 4 cells 
    	 * surrounding the cell you have so that we can
    	 * find a path. Very important is that this method does not
    	 * check each 4 cells surrounding the actual one. It skips over
    	 * some of them. For example, in the grid given in Figure 1 c) of
    	 * the hw, once we reach cell (1, 2), we at first check cell (0,2)
    	 * cell (0,2) is red at the beginning since it was selected by the
    	 * user as indicated in Figure 1 b). So, we call (0,2) and check all
    	 * 4 cells surrounding it. Since all 4 cells return false then 
    	 * we go into the else inside of the else statement and we print it as temporary. Then
    	 * we check (2,2) since we call (x+1, y) before(x, y-1). So, that checks
    	 * and keep calling until we reach the exit cell, skipping (x, y-1), which are
    	 * (1,3) and (1,4)
    	 * 
    	 */
    	
    	else {
    		
    		maze.recolor(x, y, PATH); // recolor every cell passed the else
    		// statement as indicated in here
    		
    		// implement the if statement to capture only one path
    		if (findMazePath(x-1, y) || findMazePath(x+1, y) || findMazePath(x, y+1) || findMazePath(x, y-1)) {
    			
    			return true;
    			
    		}
    		
    		/*
    		 * If all 4 cells are false, then we reached a dead end and 
    		 * must color the green cell in the -8 as TEMPORARY (Black). An
    		 * example about reaching a dead end is described above  
    		 * 
    		 */
    		
    		else {
    			
    			// Color cell (x,y) as Temporary (Black)
    			maze.recolor(x, y, TEMPORARY);
    			return false; // return false since cell will not part of the
    			// path
    			
    		}
    		
    	}
    	
    }

    // ADD METHOD FOR PROBLEM 2 HERE
    
    /*
     * This method is a method made to help method 2 as indicated in the assignment
     * This method gets called by the problem 2 method as seen below:
     * public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y)
     * This method helps Problem 2 method above. This method is similar
     * to Problem 1 above since it is meant to find paths. The only difference
     * is that this method finds all paths from (0,0) leading to the exit
     * cell and also it keep updating the result (which is the multi-deimesional)
     * array.
     * 
     * 
     * 
     */
    private void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
    	
    	// Each cell can have a maximum of 4 paths. So, our maximum number of paths
    	// can only be 4. List1 represents x's and list 2 represents y's.
    	// To be able to capture all paths, we need to call for each cell 4 times
    	// So, call findMazePathStackBased(x+list1[i], y+list2[i], result, trace)
    	// This way we would cover (x-1, y), (x+1, y), (x, y-1), and (x, y+1)
    	// which represents all 4 paths that a cell can take. This is the reason
    	// for the creation of list1 and list2
    	int list1[] = {-1, 1, 0, 0}; // list1 is of x's
    	int list2[] = {0, 0, -1, 1}; // list2 is of y's
    	
    	
    	// Same solution as Problem 1 to check for out of bounds 
    	if (x < 0 || y < 0 || (x > (maze.getNCols() - 1)) || (y > (maze.getNRows() - 1))) {
    		
    		return; // return nothing since it is a void

    		
    	}
    	
    	// Same solution as Problem 1 to check for cells with non-Red colors
    	else if (maze.getColor(x, y) != NON_BACKGROUND) {
    		
    		return; // return nothing since it is a void
    		
    		
    	}
    	
    	// Same solution as Problem 1 to check for exit cell with
    	// implementation of finding the multi-dimensional ArrayList
    	else if ((x == (maze.getNCols() - 1)) && (y == (maze.getNRows() - 1))) {
    		
    		PairInt xyvalue = new PairInt(x,y); // Store (x, y) in xyvalue
    		trace.push(xyvalue); // Push the value of (x,y) into the stack
    		ArrayList finallist = new ArrayList(trace); // Create a finallist to store the values pushed into the stack
    		result.add(finallist); // Add the (x,y) values to the result
    		trace.pop(); // Remove the (x,y) values from the stack to clear the stack
    		
    		
    	}
    	
    	
    	else {
    		
    		maze.recolor(x, y, PATH); // recolor any cell that enters the else statement as green
    		// Store the (x,y) value into xyvalue
    		PairInt xyvalue = new PairInt(x,y); 
    		
    		// Push (x,y) value that path through this statement into the stack
    		trace.push(xyvalue);
    		
    		// Since list1 and list2 have same length
    		for (int i = 0; i < list1.length; i++) {
    			
    			// find all Paths based on the user selection
    			findMazePathStackBased(x+list1[i], y+list2[i], result, trace);
    			
    			
    			
    		}
    		
    		// Remove the (x,y) values from the stack to clear the stack
    		trace.pop();
    		// Recolor the colored (x,y) cell as red again so that we can find all other paths
    		maze.recolor(x, y, NON_BACKGROUND);
    		
    	}

    	
    }
    
    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y){
    	
    	// Create a multi-dimensional ArrayList called result
    	ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
    	// Create a stack called trace
    	Stack<PairInt> trace = new Stack<>();
    	// Call the method findMazePathStackBased
    	findMazePathStackBased(x, y, result, trace);
    	// return result (multi-dimensional ArrayList)
    	return result;
    	
    }
    
    public ArrayList<PairInt> findMazePathMin(int x, int y){
    	
    	// Define min as an integer to store the minimum size of the
    	// ArrayList that has the minimum size 
    	// in the mutli-dimensional ArrayList
    	int min;
    	// This gets the minimumIndex for the ArrayList with the min
    	// size
    	int minimumIndex = 0;
    	
    	// Define result as multi-dimensional ArrayList
    	ArrayList<ArrayList<PairInt>> result;
    	
    	// Call the function below to get all the Arraylists stored
    	// in the mutli-dimensional ArrayList
    	result = findAllMazePaths(x, y);
    	
    	// set the minimum value to be the value of the first
    	// ArrayList
    	min = result.get(minimumIndex).size();
    	// Go through the multi-dimensional ArrayList size to get each
    	// ArrayList
    	for (int i = 0; i < result.size(); i++) {
    	
    		// If the size of an Arraylist is less than min then store
    		// min value to be this ArrayList size and minimum Index
    		// to be the Index of that ArrayList in the list of 
    		// multiple ArrayLists and keep going
    		if (result.get(i).size() < min) {
    			
    			min = result.get(i).size();
    			minimumIndex = i;
    
    		}
    		
    		
    	}
    	
    	// return the ArrayList with shortest path
    	return result.get(minimumIndex);
    }
  

    /*<exercise chapter="5" section="6" type="programming" number="2">*/
    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }
    /*</exercise>*/

    /*<exercise chapter="5" section="6" type="programming" number="3">*/
    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
    /*</exercise>*/
}
/*</listing>*/
