//RockController
//Controller class for when the Rock button is clicked
//June 10,2020

//Import packages
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockController { //start of RockController

	private GameView theView;
	private GameModel theModel;

	public RockController(GameView theView, GameModel theModel) {
		this.theView = theView;
		this.theModel = theModel;

		// Tell the View that when ever the rock button is clicked to execute the actionPerformed method
		this.theView.addRockListener(new RockListener());
	}

	class RockListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			int userNum = 1; //user's choice is set to 1 (rock)

			if (theModel.getRounds()!=4) { //checks if the game is over
				theModel.calcWinner(userNum);

				theView.setCompChoice(theModel.compIntToString());
				theView.setScores(theModel.getUserPoints(),theModel.getCompPoints());
				theView.setRounds(theModel.getRounds());
			}

			else {
				theView.setRounds(theModel.getRounds()+1);
				theView.setCompChoice(theModel.compIntToString());
				theView.displayWinner(theModel.getWinner()); 
			}

		}

	}

}//end of RockController