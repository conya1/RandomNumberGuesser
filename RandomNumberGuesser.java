/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: An application that will receive a guess and report if the guess is the random number that was generated. This application will narrow down the choices according to the previous guesses and continue to prompt us to enter a guess until we guess
 * correctly
 * Due: 09/27/2021
 * Platform/compiler:Java Eclipes JDK
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Njenwieh Onya Clovis
*/

import java.util.Scanner;
/**
 * Driver Class, responsible to print the head and also ask the user for 
 * an initial guess of the RNG between 0 and 100
 * print out the result for that guess using the method from the RNG class
 */
public class RandomNumberGuesser {
    public static Scanner scan;
    public static int randNum;
    public static int nextGuess, highGuess, lowGuess;
    public static RNG rang;
    /**
     * The main method for the RNG app
     */
    public static void main(String[] args) {
        rang = new RNG();
        String play_or_not = "yes";
        while ( play_or_not.equals("yes")) {
 
  initialiseGame();
            playGame();
            System.out.println("Try again? (yes or no)");
            play_or_not = scan.next();    
        }
        System.out.println("Thanks for playing...");
    }
    /**
     * initialize the game by using the initializeGame method
     */
    public static void initialiseGame() {
        lowGuess = 0;
        highGuess = 100;
        randNum = RNG.rand();
        RNG.resetCount();
    }
    
    /**
     * play the game
     */
    public static void playGame() {
        scan = new Scanner(System.in);
        System.out.println("Enter your first guess");
        nextGuess = scan.nextInt();

        while(nextGuess != randNum) {
            if (!RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
                nextGuess = scan.nextInt();
                continue;
            }

            System.out.println("Number of guesses is "+RNG.getCount());
            if (nextGuess>randNum) {
                highGuess = nextGuess;
                System.out.println("Your guess is too high");
                
            } else {
                lowGuess = nextGuess;
                System.out.println("Your guess is too low");
            }
            System.out.println("Enter your next guess between "+ lowGuess + " and " + highGuess);
            nextGuess = scan.nextInt();
        }
        System.out.println("Number of guesses is "+(RNG.getCount()));
        System.out.println("Congratulations, you guessed correctly");
             
    }
}


import java.util.Random;
import java.util.Scanner;

/**
 * This is the utility class to accompany RandomNumberGuesser
 * It contains static methods to generate a random number,
 * validate the guesses as being between the previous low and high guesses,
 * and maintain the number of guesses.
 * @author ralexander
 */
public class RNG{
	private static int count=0;
	static Scanner scan;
	public RNG() {
		count++;
	}
	
	/**
	 * Sets the count to zero
	 */
	public static void resetCount() {
		count = 0;
	}
	
	/**
	 * generates a random integer between 1 and 100
	 * @return the random number as an integer
	 */
	public static int rand() {
		Random rand = new Random();
		int randInt = rand.nextInt(100)+1;
		return randInt;
	}
	
	/**
	 * Checks that nextGuess is strictly between lowGuess and highGuess
	 * @param nextGuess
	 * @param lowGuess
	 * @param highGuess
	 * @return a boolean, true if the guess is with the bounds, false otherwise
	 */
	public static boolean inputValidation(int nextGuess, int lowGuess, int highGuess) {
		//do {
		boolean rtnValue = true;
		if (nextGuess>=highGuess || nextGuess<=lowGuess) {
				   System.out.println("   >>> Guess must be between "+lowGuess+" and "+highGuess+
						   ".  Try again");				   
				   rtnValue = false;
			   }
		//	} while (nextGuess>=highGuess || nextGuess<=lowGuess);
		count++;
		return rtnValue;
		
	}

	/**
	 * @return an integer, the current value of count
	 */
	public static int getCount() {
		return count;
	}
}


