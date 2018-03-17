package application;
/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		NumberGame game = new FranceGame(upperBound);
		System.out.println( game.toString() );
		System.out.println( game.getMessage() );
		GameConsole ui = new GameConsole( );
		int solution = ui.play( game );
		System.out.println("You guesses " + (game.getCount())  + " times");
	}
}
