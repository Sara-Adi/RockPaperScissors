//RockPaperScissors
//Main
//June 10, 2020

public class RockPaperScissors {//start of class

	public static void main(String[] args) {//start of main

		//initialize the View and Model
		GameView theView = new GameView();         
		GameModel theModel = new GameModel();

		RockController theController = new RockController(theView,theModel);

		PaperController theController2 = new PaperController (theView, theModel);

		ScissorController theController3 = new ScissorController (theView,theModel);

		RestartController theController4 = new RestartController (theView, theModel);

		ExitController theController5 = new ExitController (theView, theModel);

		theView.setVisible(true);//sets the GUI visible
	}//end of main
	
}//end of class