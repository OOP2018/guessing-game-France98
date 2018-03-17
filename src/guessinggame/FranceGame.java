package guessinggame;
import java.util.Random;

import javafx.beans.Observable; 

/**
 * Game of guessing a secret number.
 * @author Phanuwatch Luangpradit
 *
 */
public class FranceGame extends NumberGame{
	private int UpperBound;
	private int secret;
	private int count = 0;
	
	/**
	 * Initialize a new game.
	 * @param upperbound is the max value for the secret a number.
	 */
	public FranceGame(int upperbound){
		this.UpperBound = upperbound;
		long seed = System.nanoTime(); 
		Random rand = new Random(seed);
		this.secret = rand.nextInt(upperbound) + 1;
		super.setMessage("I'm thinking of a number between 1 and " + upperbound);
	}
	
	/**
	 * check the number that player guess is correct or not.
	 * @param number that player guess.
	 */
	public boolean guess(int number){
		count++;
		if(number == secret){
			setMessage("Right! The secret number is " + this.secret);
			setChanged();
			notifyObservers(number);
			return true;
		}else if(number < secret){
			setMessage("Sorry, too small.");
		}else{
			setMessage("Sorry, too large.");
		}
		setChanged();
		notifyObservers(number);
		return false;
	}
	
	/**
	 * Return the upperbound for the solution to this game.
	 * @return the upperbound of the game.
	 */
	public int getUpperBound(){
		return this.UpperBound;
	}
	
	/**
	 * Describe the game.
	 * @return the sentence that set in toString.
	 */
	public String toString(){
		return "Guess a secret number";
	}
	
	/**
	 * Return how many times that player guesses.
	 * @return count that how many times that player played
	 */
	public int getCount(){
		
		return this.count;
		
	}
}
