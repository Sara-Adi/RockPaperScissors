//GameView
//In charge of the GUI
//June 10,2020

//import packages
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.border.Border;

public class GameView extends JFrame{//start of class
	//initialize instance variables
	public JPanel north = new JPanel();
	private JLabel title = new JLabel ("Rock! Paper! Scissors!");

	public JPanel userSide = new JPanel();
	public Border b1 = BorderFactory.createTitledBorder ("Player");
	private JLabel prompt = new JLabel ("Choose your move: ");
	private JLabel userBlank = new JLabel (" ");
	private JButton rock = new JButton ("Rock");
	private JButton paper = new JButton ("Paper");
	private JButton scissor = new JButton ("Scissors");

	public JPanel computer = new JPanel();
	public Border b1B = BorderFactory.createTitledBorder ("Computer");
	private JLabel compBlank = new JLabel (" ");
	private JTextField compC = new JTextField (10);

	public JPanel compAndUser = new JPanel();

	public JPanel east = new JPanel();
	private JButton restart = new JButton ("Restart");
	private JButton exit = new JButton ("Exit");

	public JPanel south = new JPanel();
	public Border b3 = BorderFactory.createTitledBorder(" ScoreBoard");
	private JLabel userSB = new JLabel ("Your Score: ");
	private JTextField userScore = new JTextField (5);
	private JLabel compSB = new JLabel ("Computer's Score: ");
	private JTextField compScore = new JTextField (5);
	private JLabel rounds = new JLabel ("Rounds:");
	private JLabel roundNum = new JLabel("0");

	GameView (){//start of GameView method
		//sets the initial layout (GUI)

		north.setBackground (Color.BLUE);
		title.setFont(new Font ("Serif", Font.BOLD, 40));
		title.setForeground(Color.RED);

		userSide.setBorder(b1);

		computer.setBorder(b1B);

		Border b2 = BorderFactory.createTitledBorder ("Options");
		east.setBorder(b2);
		BoxLayout eastLayout = new BoxLayout (east, BoxLayout.Y_AXIS);

		south.setBorder(b3);

		this.setSize(520, 260);//sets the preferred size of the screen

		//Add the components to the JPanels
		north.add(title);

		userSide.add(prompt);
		userSide.add(userBlank);
		userSide.add(rock);
		userSide.add(paper);
		userSide.add(scissor);

		computer.add(compBlank);
		computer.add(compC);

		east.setLayout(eastLayout);
		east.add(restart);
		east.add(exit);

		south.add(rounds);
		south.add(roundNum);
		south.add(userSB);
		south.add(userScore);
		south.add(compSB);
		south.add(compScore);

		compAndUser.setLayout (new GridLayout (1,2));
		compAndUser.add(userSide);
		compAndUser.add(computer);
		//add the JPanels to the JFrame
		this.add(north, BorderLayout.NORTH);
		this.add(compAndUser,BorderLayout.CENTER);
		this.add(east,BorderLayout.EAST);
		this.add(south,BorderLayout.SOUTH); 
	}//end of GameView

	public int getUserScore(){  //start of getUserScore
		return Integer.parseInt(userScore.getText()); //returns an integer representing the user's choice (1=rock, 2=paper, 3=scissors)
	}//end of getUserScore

	public int getCompScore(){  //start of getCompChoice
		return Integer.parseInt(compScore.getText());	//returns an integer representing the computers choice
	}//end of getCompChoice

	public void setCompChoice() {//start of setCompChoice
		compC.setText("");
	}//end of setCompChoice

	public void setCompChoice (String stringChoice) {//start of setCompChoice
		compC.setText(stringChoice); //sets the JTextField with the computers choice
	}//end of setCompChoice

	public void setScores(int solution1, int solution2){ //start of setScores
		userScore.setText(Integer.toString(solution1));
		compScore.setText(Integer.toString(solution2));
	}//end of setScores

	public void setRounds(int numRound){ //start of setRounds
		roundNum.setText(Integer.toString(numRound));
	}//end of setRounds

	public void displayWinner(String win){  //start of displayWinner
		//remove the center/east JPanels from the screen to display the final msg with who won  
		compAndUser.removeAll();
		east.removeAll();
		compAndUser.repaint();
		east.repaint();
		JLabel msg = new JLabel ("");
		msg.setFont(new Font ("Serif", Font.BOLD, 40));
		compAndUser.add(msg);

		if (win.equals("User")) {  
			msg.setText("    P L A Y E R      W I N S!");
		}

		else if (win.equals("Computer")) {
			msg.setText(" C O M P U T E R    W I N S!");
		}

		else if (win.contentEquals("Tie")) {
			msg.setText("          I T' S    A   T I E!");
		}

	}//end of displayWinner

	public void restart() {//start of restart
		this.repaint();
	}//end of restart

	public void clearOnExit(JPanel n, JPanel c, JPanel e, JPanel s){ //start of clearOnExit
		//clears the JFrame to only display the final scores/winner
		compAndUser.removeAll();
		east.removeAll(); 

		compAndUser.setBorder (BorderFactory.createEmptyBorder()); 
		south.setBorder (BorderFactory.createEmptyBorder());

		compAndUser.repaint();
		east.repaint();   
	}//end of clearOnExit

	// If an option is clicked execute a method in the Controller named actionPerformed

	void addRockListener(ActionListener listenForRockButton){ 
		rock.addActionListener(listenForRockButton);  
	}

	void addPaperListener(ActionListener listenForPaperButton){ 
		paper.addActionListener(listenForPaperButton); 
	}

	void addScissorListener(ActionListener listenForScissorButton){
		scissor.addActionListener(listenForScissorButton);
	}

	void addRestartListener(ActionListener listenForRestartButton){ 
		restart.addActionListener(listenForRestartButton);
	}

	void addExitListener(ActionListener listenForExitButton){
		exit.addActionListener(listenForExitButton);
	}

}//end of class