package hw05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class with a method to read a maze file into the program.
 * 
 * @author Keenan Knaur
 * 
 * DO NOT CHANGE THE CODE IN THIS CLASS.
 * 
 * @see {@code Maze}
 */
public class MazeReader {
	/**
	 * Constructor is private since there is no need to instantiate this class as it only contains
	 * static methods.
	 */
	private MazeReader() {}
	
	/**
	 * This method opens a maze.txt file and parses the information contained within.  The format
	 * of a maze.txt is as follows:
	 * 		-The first line of the file indicates the number of rows in the maze.
	 * 		-The second line of the file is the row index and column index of the start position.
	 * 		-The third line of the file is the row index and column index of the end position.
	 * 		-The rest of the file contains the character data that makes up the maze.
	 * 
	 * @param mazeFile	A {@code File} object that will be a .txt file containing all the maze 
	 * 				    information.
	 * 
	 * @return	An instance of the {@code Maze} class constructed using all of the information that
	 * 			has been parsed from the given {@code File} object.
	 */
	public static Maze readMaze(File mazeFile) {
		Scanner reader = null;
		
		try {
			reader = new Scanner(mazeFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Read the dimensions of the maze;
		int numRows = Integer.parseInt(reader.nextLine());
		
		//Initialize the maze to the dimensions read from the file.
		char[][] mazeData = new char[numRows][];
		
		//Read and create the start coordinate.
		String[] tokens = reader.nextLine().split(",");
		Coordinate start = new Coordinate(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		
		//Read and create the end coordinate.
		tokens = reader.nextLine().split(",");
		Coordinate end = new Coordinate(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		
		//Read all the maze data
		int i = 0;
		while(reader.hasNextLine()) {
			mazeData[i] = reader.nextLine().toCharArray();
			i++;
		}
		
		return new Maze(mazeData, start, end);
	}
}