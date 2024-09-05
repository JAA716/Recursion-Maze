package hw04;
/*@author
 * Jorge Arias
 * CIN: 401755303
 * CS 2013-07
 * 
 * About: A main method that copies a menu gui. 
 * This menu show cases all the methods created in the Recursion class
 * */

import java.util.Scanner;

public class RecursionMain {
	public static void main(String[]args) {
		
		Scanner input = new Scanner(System.in);
		
		boolean run = true;
		
		System.out.println("-----------------------------------------  "
				+ "Welcome! Please select an option from bellow ----------"
				+ "-------------------------------");
		
		while(run) {
			System.out.println("\n\n1. Bunny Ears"
					+ "\n2. Zeno's Race Paradox\n"
					+ "3. Substrings\n"
					+ "4. Pair Sums\n"
					+ "5. Exit Program");
			int choice = input.nextInt();
			
			switch(choice) {
			case 1:  
				
				System.out.println("\nOn the planet Bunnytopia, rabbits are either even or odd.  An even rabbit has 4 ears, and an odd rabbit has 5 ears."
						+ "\nPlease provide the number of bunnies to count: ");
				int numBunnies = input.nextInt();
				System.out.println("\nTotal Bunny Ears: "+Recursion.bunnyEars(numBunnies));
				
				break;
			case 2:
				
				System.out.println("\nA simplified version of the Greek philosopher Zeno's "
						+ "racecourse paradox goes like this: A runner on a race course can "
						+ "never reach the end of the race course because they must first "
						+ "travel half the distance to the end.  After the runner travels "
						+ "this first half distance, they must then travel half of the "
						+ "remaining distance.  Once the runner reaches half of the "
						+ "remaining distance they must still travel half of the next"
						+ " remaining distance.  On and on it goes infinitely dividing the "
						+ "distance so that the runner can never actually reach the end."
						+ "\nPlease provide the number of itterations to put this runner through : ");
				int runnerAbuse = input.nextInt();
				System.out.println("\nNow enter the distance that they will never reach(it can be "
						+ "a decimal value) :");
				double unachievableDistance = input.nextDouble();
				System.out.println("\nDistnace that will never be met: "
							+Recursion.zenosRaceParadox(runnerAbuse, unachievableDistance));
				
				break;
			case 3: 
				
				System.out.println("\nThe game is find a needle in a hay stack. "
						+ "\nPlease provide a sentence or word to act as the hay stack: ");
				input.nextLine();
				String hayStack = input.nextLine();
				System.out.println("\nNow provide a letter that will act as the needle: ");
				String needle = input.next();
				System.out.println("\nThe needle was found "+Recursion.substrings(hayStack, needle) + " times.");
				
				break;
			case 4: 
				System.out.print("\nIf given an assortment of numbers it is possible to add them in pairs.");
				
				System.out.print("\nNow how many values do you want to enter? ");
		        int size = input.nextInt();

		        int[] array = new int[size];

		        System.out.println("\nPlease enter the values: ");

		        for (int i = 0; i < size; i++) {
		        	if(array[i] < 0) {
		        		array[i] = 0;
		        		break;
		        		
		        	}
		            array[i] = input.nextInt();
		           
		        }
				
		        System.out.println("The sum of the given values is: " + Recursion.pairSums(array, 0));
				
				
				
				break;
			default: System.out.println("Thank-you for your patrionage!");
					 run = false;
				
			}
			
		}

		
	}

}
