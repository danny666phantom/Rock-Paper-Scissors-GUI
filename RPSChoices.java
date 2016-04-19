package rockPaperScissors;

/**
 *  Daniel Lorenzo 1410 - 013 / Assignment A06 Rock Paper Scissors 
 *            Made with <3.
 *              /)_/)
 *             ( . .) 
 *             C(")(") 
 */

import javax.swing.ImageIcon;

public enum RPSChoices {

	// ENUMS.
	ROCK(
			new ImageIcon(
					RPSChoices.class.getResource("/rockPaperScissors/3.png"))), PAPER(
			new ImageIcon(
					RPSChoices.class.getResource("/rockPaperScissors/4.png"))), SCISSORS(
			new ImageIcon(
					RPSChoices.class.getResource("/rockPaperScissors/5.jpg")));

	// Fields.
	private ImageIcon icon;

	// Constructor.
	private RPSChoices(ImageIcon icon) {
		this.icon = icon;

	}

	// Getter Method for icon.
	public ImageIcon getIcon() {
		return icon;
	}

	// Equals method that Evaluates for winning and losing and draw
	// combinations.
	public static int equals(int player, int computer) {
		int result = 0;

		if (player == 1 && computer == 2) {
			result = 2;
		} else if (player == 2 && computer == 3) {
			result = 2;
		} else if (player == 3 && computer == 1) {
			result = 2;
		} else if ((player == 1 && computer == 3)) {
			result = 1;
		} else if (player == 2 && computer == 1) {
			result = 1;
		} else if (player == 3 && computer == 2) {
			result = 1;
		} else {
			result = 3;
		}

		return result;

	}

}
