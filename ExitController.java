//ExitController
//Controller class for when the exit button is clicked
//June 10,2020

//import packages
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitController { //start of ExitController

	private GameView theView;
	private GameModel theModel;

	public ExitController(GameView theView, GameModel theModel) { //constructor
		this.theView = theView;
		this.theModel = theModel;

		// Tell the View that when ever the rock button is clicked to execute the actionPerformed method
		this.theView.addExitListener(new ExitListener());
	}

	class ExitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			theView.clearOnExit(theView.north, theView.compAndUser, theView.east, theView.south); //clears the screen 
			theView.setScores(theModel.getUserPoints(),theModel.getCompPoints()); //sets the final scores
			theView.displayWinner(theModel.getWinner()); //displays the final msg for who won
		}

	}

}//end of ExitController
