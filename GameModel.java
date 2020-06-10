//GameModel
//In charge of all the data/back end of the game
//June 10,2020

public class GameModel {//start of GameModel
	//initialize variables
	int compP =0;
	int userP =0;
	static int rounds=0;
	static int cChoice_ = 0;

	public static int getComputerChoice() {//start of getComputerChoice
		cChoice_ = (int) (Math.random()*3)+1;//Determines the computers move (1=rock, 2=paper, 3=scissors)
		return cChoice_;
	}//end of getComputerChoice

	public void calcWinner (int userChoice) { //start of calcWinner
		int compChoice = getComputerChoice();
		//Determines the winner of the round by comparing the number choice of the user and computer  
		if (userChoice==1)
		{
			if (compChoice==1)
			{
			}
			else if (compChoice ==2)
			{
				compP++;
			}
			else
			{
				userP++;
			}
		}

		else if (userChoice==2)
		{
			if (compChoice==1)
			{
				userP++;
			}
			else if (compChoice==2)
			{
			}
			else
			{
				compP++;
			}
		}

		else
		{
			if (compChoice==1)
			{
				compP++;
			}
			else if (compChoice==2)
			{
				userP++;
			}
			else 
			{
			}
		}

		rounds++;

	}//end of calcWinner

	public boolean isGameOver() {  //start of isGameover
		if (rounds==5)
			return true;
		else
			return false;
	}//end of isGameOver

	public int getUserPoints() {  //start of getUserPoints
		return userP;
	}//end of getUserPoints

	public int getCompPoints() {  //start of getCompPoints
		return compP;
	} //end of getCompPoints

	public void restartGame() { //start of restartGame
		userP=0;
		compP=0;
		rounds=0;
	}//end of restartGame

	public String compIntToString() { //start of compIntToString
		//Determines the word choice of the computers choice in order to display on the GUI
		if (cChoice_==1) {
			return "Rock";
		}

		else if (cChoice_==2) {
			return "Paper";
		}

		else{
			return "Scissors";
		}

	}  //end of CompIntToString 

	public String getWinner() {  //start of getWinner
		if (userP>compP)
			return "User";
		else if (userP<compP)
			return "Computer";
		else
			return "Tie";
	}//end of getWinner

	public int getRounds() {  //start of getRounds
		return rounds;
	}//end of getRounds

}//end of GameModel
