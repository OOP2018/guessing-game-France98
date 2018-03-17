package application;
import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 */
public class GameConsole {

	/**
	 * The play method plays a game using input from a user.
	 * @param game
	 * @return
	 */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		boolean running = true;
		int num = 0;
		Scanner input = new Scanner(System.in);
		while (running) {
			System.out.print("your guess? ");
			num = input.nextInt();
			if (game.guess(num) == true) {
				System.out.println(game.getMessage());
				break;
			}
			System.out.println(game.getMessage());
		}
		return num;
	}
	
}
