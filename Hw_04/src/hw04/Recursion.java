package hw04;
/*@author
 * Jorge Arias
 * CIN: 401755303
 * CS 2013-07
 * 
 * About: A class that doesnt have a public constructor 
 * but does contain 4 different methods created via recursion. 
 * 1. Bunny ears that features patterns and addition via recursion. 
 * 2.The paradox problem that features division and addition via recursion. 
 * 3.The substring method that features finding and counting how many times an element/value pops up. 
 * 4. the pair sums method that features addition in pairs  
 * */



public class Recursion {
	
	private Recursion() {}
	
	public static int bunnyEars(int n) {
		
		int bunnyEars = 0;
		
		if(n == 0) {
			
			return bunnyEars;	
			}
		
		else if(n%2 == 0){
			bunnyEars = 4;
				
		}
		else {
			bunnyEars = 5;
		
		}

		return(bunnyEars + bunnyEars(n-1) );
		
		
	}
	
	public static double zenosRaceParadox(int n , double distance) {
		
		double halfDistance = 0;
		
		if(n == 0) {
			return 0;
			
		}
		else{
			halfDistance = distance /2;
			
			
		}
		return halfDistance + zenosRaceParadox(n-1,halfDistance);
		
	}
	
	public static int substrings(String string,String substring) {
		
		if (string.length() == 0) {
	        return 0;
	    }
		
		//Rather than using contains, the startsWith method returns a boolean answer 
		//and it doesnt matter where the wanted substring is, will work even though its says startsWith
		//Also the contains method runs too much for some reason..
		if (string.startsWith(substring)) {
			//adding 1 to the continued result of the method. Also, calling the method 
			//with these parameters prevent any index from going over and the compared string is always 
			//within the desired substring's length
	        return 1 + substrings(string.substring(substring.length()), substring);
	    }


		
		return substrings(string.substring(1), substring);
		
		
		
		
	}
	
	public static int pairSums(int[] array,int index) {
		
		if (index == array.length - 1) {
	        return 0;
	    } 
		else {
	        int sum = array[index] + array[index + 1];
	        int[] result = new int[array.length - 1];
	        result[index] = sum;
	        System.arraycopy(array, 1, result, 0, array.length-1);
	        return sum + pairSums(result, index);
	    }

	
		
	}
	
	
	


}


