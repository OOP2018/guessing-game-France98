package UI;

import java.net.URL;

import application.FranceGame;
import application.NumberGame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	/**
	 * Start the program using GUI from fxml.
	 */
	@Override
	public void start(Stage primaryStage) {
		NumberGame game = new FranceGame(100);
		try {
			URL url = getClass().getResource("GuessingGameUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: GuessingGameUI.fxml");
				Platform.exit();
			}
			// Load the FXML and get reference to the loader
			FXMLLoader loader = new FXMLLoader(url);
			// Create the UI. This will instantiate the controller object, too.
			Parent root = loader.load();
			// Now we can get the controller object from the FXMLloader.
			// This is interesting -- we don't need to use a cast!
			GuessController controller = loader.getController();	
			// Dependency Injection:
			// Set the Counter object we want the view to update.
			controller.setgame(game);
			// Build and show the scene
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Guessing Game");
			primaryStage.show();
		} catch (Exception e) {
			System.out.println("Exception creating scene: " + e.getMessage());
		}
		GuessCountUI view1 = new GuessCountUI(game);
		game.addObserver(view1);
		view1.run();
		getGuessNumber view2 = new getGuessNumber(game);
		game.addObserver(view2);
		view2.run();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
