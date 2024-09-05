package hw05;

import java.util.ArrayList;

/*@author
 * Jorge Arias
 * CIN : 401785303
 * CS 2013-07
 * Info : Class that iterates thru the 2d array using recursion and backtracking that
 * finds the exit from the starting point.
 */

public class MazeSolver {

	
	/**
	 * Constructor is private since there is no need to instantiate this class as it only contains
	 * static methods.
	 */
	private MazeSolver() {}

	/**
	 * Public method to solve a maze using recursion.  This method creates two empty ArrayLists
	 * that the recursive helper method will need to solve the given maze.
	 * 
	 * @param maze The {@code Maze} object we want to solve.
	 */
	public static void solve(Maze maze) {
		//ArrayList to keep track of which coordinates are on the path from start to end.
		ArrayList<Coordinate> path = new ArrayList<>();

		//ArrayList to keep track of which coordinates you have already been to.
		ArrayList<Coordinate> history = new ArrayList<>();
		solve(maze, maze.getStart(), path, history);
	}

	/**
	 * The recursive helper method that YOU will implement.  This method will do all the work for
	 * solving the maze.  
	 * 
	 * @param maze	The {@code Maze} object to solve.
	 * 
	 * @param currentPos	The {@code Coordinate} object that keeps track of your current position in the maze.
	 * 
	 * @param path			The {@code ArrayList} of {@code Coordinate} objects that are currently on the path
	 * 						from the start of the maze to the end.  This ArrayList should only contain the 
	 * 						coordinates from start up to your current position, and eventually should contain
	 * 						all the coordinates from start to end.
	 * 
	 * @param history		The {@code ArrayList} of {@code Coordinate} objects that you have already visited.
	 * 						This helps you to keep track of where you have been so you do not check the same
	 * 						position more than once.
	 * 
	 * 
	 */
	
	

	private static void solve(Maze maze, Coordinate currentPos, ArrayList<Coordinate> path, ArrayList<Coordinate> history) {
		//THIS IS THE METHOD THAT YOU MUST IMPLEMENT.
		//YOU MAY NOT CHANGE THE METHOD HEADER
		
		//Variables that hold the current rows and columns
		int j = currentPos.getRowIndex();
		int i = currentPos.getColIndex();
		
		//checks if the current position's value is equal to the exit char 'E'
		if(maze.getMazeValue(j,i) == 'E') {
			//if we get to the exit then we add it to the path and print the result
			path.add(currentPos);
			printResult(maze,path);
			//so we end the recursion and a stack overflow error doesnt occur we return 
			//after the prior methods are completed
			return;
			
		}
		
		/*dont want to visit a coordinate that has been visited so, by restricting it so 
		 * the recursion only happens if the coordinate is not in history that will 
		 * never happen.*/
		if(!history.contains(currentPos)) {
			
			//Updates the path and history with the current position
			path.add(currentPos);
			history.add(currentPos);
			
			
			/*check if going up is possible*/	
			if(j > 0 && maze.getMazeValue(j-1, i) != '+') {
				Coordinate newPos = new Coordinate(j-1,i);
				solve(maze,newPos,path,history);	
						
			}
			
			/*check if going down is possible*/
			if(currentPos.getRowIndex() < (maze.getNumRows() - 1) && 
					maze.getMazeValue(j+1, i) != '+') {
				Coordinate newPos = new Coordinate(j+1,i);
				solve(maze,newPos,path,history);	

			}
			
			/*check if going left is possible.As well as making sure we 
			 * dont go off the array(a negative number)*/		
			if(i > 0 && maze.getMazeValue(j, i-1) != '+') {
				Coordinate newPos = new Coordinate(j,i-1);
				solve(maze,newPos,path,history);
			}
				
			/*check if going right is possible. As well as checking that we dont 
			 * get index out of bounds due to the col value being greater than 
			 * what is set in the maze.*/	
			if(i < (maze.getNumCols() - 1) && maze.getMazeValue(j, i+1) != '+') {
				Coordinate newPos = new Coordinate(j,i+1);
				solve(maze,newPos,path,history);	
			}
			
		
			
		
			//Backtracking by removing the current position since history would 
			//most likely want to have prior locations while the path that will be displayed 
			//would not.
			path.remove(path.size()-1);
			
				
			
		}	
	
}

	/**
	 * Private method to print the final results once a solution has been found.
	 * 
	 * @param maze	A {@code Maze} object that we wish to display.
	 * @param path  An ArrayList of {@code Coordinate} objects that are on the path from the start
	 *              of the maze to the end.
	 */
	private static void printResult(Maze maze, ArrayList<Coordinate> path) {

		for (int i = 0 ; i < maze.getNumRows() ; i++) {
			for (int j = 0 ; j < maze.getNumCols(); j++) {
				Coordinate current = new Coordinate(i, j);
				
				if (current.equals(maze.getStart())) {
					System.out.print("S");
				}
				else {
					char ch = (path.contains(current) ? '*' : maze.getMazeValue(i, j));
					System.out.print(ch);
				}
			}
			System.out.println();
		}
		
		System.out.println("\nPATH:");
		
		for (int i = 1 ; i <= path.size() ; i++) {
			
			if (i == path.size()) {
				System.out.print(path.get(i - 1));
			}
			else {
				System.out.print(path.get(i - 1) + ", ");
			}
			
			
			if (i % 10 == 0)  {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}
}