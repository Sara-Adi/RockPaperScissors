//ScissorController
//Controller class for when the Scissor button is clicked
//June 10,2020

//Import packages
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScissorController {

	private GameView theView;
	private GameModel theModel;

	public ScissorController(GameView theView, GameModel theModel) { //constructor
		this.theView = theView;
		this.theModel = theModel;

		// Tell the View that when ever the scissor button is clicked to execute the actionPerformed method  
		this.theView.addScissorListener(new ScissorListener());
	}

	class ScissorListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			int userNum = 3; //user's choice is =3 (Scissor)

			if (theModel.getRounds() != 4) { //checks if the game is not over
				theModel.calcWinner(userNum);

				theView.setCompChoice(theModel.compIntToString());
				theView.setScores(theModel.getUserPoints(),theModel.getCompPoints());
				theView.setRounds(theModel.getRounds());
			}

			else {
				theView.setRounds(theModel.getRounds() +1);
				theView.setCompChoice(theModel.compIntToString());
				theView.displayWinner(theModel.getWinner()); 
			}

		}

	}

}//end of ScissorController
