package UI;

import java.util.Observable;
import java.util.Observer;

import application.FranceGame;
import application.NumberGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GuessController implements Observer{

	@FXML
	Label hint;
	@FXML
	TextField input;
	NumberGame game ;
	
	@FXML
	public void handleGuess(ActionEvent event){
		int num = 0;
		try{
			hint.setText(game.getMessage());
			num = Integer.parseInt(input.getText().trim());
			game.guess(num);
			hint.setText(game.getMessage());
			input.clear();
		}catch (NumberFormatException e) {
			input.setText("Invalid");
		}
	}
	
	public void setgame(NumberGame game) {
		this.game = game ;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
}
