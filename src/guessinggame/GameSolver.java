package guessinggame;
import java.util.Scanner;

/**
 * Automatically find the secret to any NumberGame
 * 
 * @author Phanuwatch Luangpradit
 *
 */
public class GameSolver {

	/**
	 * Play a NumberGame and return the solution.
	 * The NumberGameobject must provide messages (getMessage)
	 * containing the phrase "too small" if a guess is too small
	 * and "too large" if a guess is too large, for efficient
	 * solution.
	 * @param game is the NUmberGame to solve
	 * @return guess
	 */
	public int play(NumberGame game) {
		
		int min = 1;
		int max = game.getUpperBound();
		int guess = min + (max - min)/2;
		while (!game.guess(guess)){
			if(game.getMessage().toLowerCase().contains("too large")){
				max = guess - 1;
				guess = min + (max - min)/2;
			}if(game.getMessage().toLowerCase().contains("too small")){
				min = guess + 1;
				guess = min + (max - min)/2;
			}
		}
		return guess;
	}
}
