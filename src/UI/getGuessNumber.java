package UI;

import java.util.Observable;

import application.FranceGame;
import application.NumberGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * A Controller for a window that shows the value of a Counter.
 * This has only one component (but you can add more components),
 * so write it in code instead of FXML.
 *
 */
public class getGuessNumber extends Stage implements java.util.Observer {
	/** a counter to show value of */
	NumberGame game;
	private int lastguess;
	/** the label that shows the counter value. */
	private Label label;
	
	/**
	 * Initialize a CounterView, which shows value of a counter.
	 * @param counter the Counter to show.
	 */
	public getGuessNumber(NumberGame game) {
		this.game = game;
		initComponents();
	}
	
	private void initComponents() {
		// components and containers for our window
		HBox root = new HBox();
		//TODO Set some padding around the HBox
		root.setPadding(new Insets(10));
		//TODO Align components in center of the HBox
		root.setAlignment(Pos.CENTER);
		// The label that will show the counter value.
		label = new Label("   ");
		// make the label big enough
		label.setPrefWidth(144);
		//TODO Make the text BIG. Use setFont to create a font.
		//TODO Be careful to import the correct Font class (not java.awt.Font).
		label.setFont(new Font("Arial", 80.0));
		//TODO Set the text alignment to CENTER
		label.setAlignment(Pos.CENTER);
		// Add the label to the HBox.  You can all more components, too.
		root.getChildren().add(label);
		// Create a Scene using HBox as the root element
		Scene scene = new Scene(root);
		// show the scene on the stage
		this.setScene(scene);
		this.setTitle("Number Guess");
		this.sizeToScene();
	}
	
	/** Show the window and update the counter value. */
	public void run() {
		this.show();
		displayCount();
	}
	
	public void displayCount() {
		label.setText( String.format("%d", lastguess) );
	}

	@Override
	public void update(Observable o, Object arg) {
		lastguess = (int) arg;
		displayCount();
	}	
}

