//PaperController
//Controller class for when the Paper button is clicked
//June 10,2020

//Import packages
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaperController { //start of PaperController

	private GameView theView;
	private GameModel theModel;

	public PaperController(GameView theView, GameModel theModel) { //constructor
		this.theView = theView;
		this.theModel = theModel;

		// Tell the View that when ever the Paper button is clicked to execute the actionPerformed method
		this.theView.addPaperListener(new PaperListener());
	}

	class PaperListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			int userNum = 2; //sets the user's Choice to 2 (Paper)

			if (theModel.getRounds() != 4) { //checks if the game is over
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

}//end of PaperController