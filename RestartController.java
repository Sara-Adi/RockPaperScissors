//RestartController
//Controller class for when the restart button is clicked
//June 10,2020

//Import packages
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartController { //start of RestartController

	private GameView theView;
	private GameModel theModel;

	public RestartController(GameView theView, GameModel theModel) { //constructor
		this.theView = theView;
		this.theModel = theModel;

		// Tell the View that when ever the Restart button is clicked to execute the actionPerformed method
		this.theView.addRestartListener(new RestartListener());
	}

	class RestartListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			theModel.restartGame();

			theView.setCompChoice();
			theView.setScores(theModel.getUserPoints(),theModel.getCompPoints());
			theView.setRounds(theModel.getRounds());

		}

	}

}//end of RestartController