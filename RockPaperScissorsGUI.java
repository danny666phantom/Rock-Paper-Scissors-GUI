package rockPaperScissors;

/**
 *  Daniel Lorenzo 1410 - 013 / Assignment A06 Rock Paper Scissors 
 *            Made with <3.
 *              /)_/)
 *             ( . .) 
 *             C(")(") 
 */

//	Import tools.
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

// Constructor.
public class RockPaperScissorsGUI extends JFrame {

	// Fields.
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static int player;
	private static int computer;
	private static JTextField txtPlayerScore;
	private static JTextField txtComputerScore;
	private static JTextField txtresult;
	private static JLabel lblPlayerPic;
	private static JLabel lblComputerPic;

	/**
	 * Launch the application.
	 */
	// Main Method.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RockPaperScissorsGUI frame = new RockPaperScissorsGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RockPaperScissorsGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		// Contains the Player's picture to be updated.
		JPanel pnlWest = new JPanel();
		pnlWest.setBackground(Color.WHITE);
		contentPane.add(pnlWest, BorderLayout.WEST);
		lblPlayerPic = new JLabel();

		lblPlayerPic.setIcon(resizeBlankIcon(new ImageIcon(RPSChoices.class
				.getResource("/rockPaperScissors/3.png"))));
		pnlWest.add(lblPlayerPic);
		// Contains the Computer's picture to be updated.
		JPanel pnlEast = new JPanel();
		pnlEast.setBackground(Color.WHITE);
		contentPane.add(pnlEast, BorderLayout.EAST);
		lblComputerPic = new JLabel();

		lblComputerPic.setIcon(resizeBlankIcon(new ImageIcon(RPSChoices.class
				.getResource("/rockPaperScissors/4.png"))));
		pnlEast.add(lblComputerPic);
		// Contains the score panel and the game label.
		JPanel pnlScores = new JPanel();
		pnlScores.setBorder(new EmptyBorder(0, 0, 10, 0));
		pnlScores.setBackground(Color.RED);
		contentPane.add(pnlScores, BorderLayout.NORTH);
		pnlScores.setLayout(new GridLayout(1, 4, 0, 0));
		txtPlayerScore = new JTextField("0");
		txtPlayerScore.setPreferredSize(new Dimension(10, 1));
		txtPlayerScore.setEditable(false);
		txtComputerScore = new JTextField("0");
		txtComputerScore.setEditable(false);
		txtresult = new JTextField("");
		txtresult.setHorizontalAlignment(SwingConstants.CENTER);
		txtresult.setFont(new Font("Arial Black", Font.BOLD, 18));
		txtresult.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtresult.setBackground(Color.RED);
		pnlScores.add(txtPlayerScore);
		pnlScores.add(txtresult);
		pnlScores.add(txtComputerScore);
		// Contains the Player's option buttons.
		JPanel pnlPlayerButtons = new JPanel();
		pnlPlayerButtons.setBorder(new EmptyBorder(20, 0, 0, 0));
		pnlPlayerButtons.setBackground(Color.RED);
		contentPane.add(pnlPlayerButtons, BorderLayout.SOUTH);
		pnlPlayerButtons.setLayout(new GridLayout(1, 3, 5, 5));

		JButton rdoRock = new JButton("");
		JButton rdoPaper = new JButton("");
		JButton rdoScissors = new JButton("");

		rdoRock.setIcon(resizeIcon(RPSChoices.ROCK.getIcon()));
		rdoPaper.setIcon(resizeIcon(RPSChoices.PAPER.getIcon()));
		rdoScissors.setIcon(resizeIcon(RPSChoices.SCISSORS.getIcon()));

		addAListener(rdoRock);
		addAListener(rdoPaper);
		addAListener(rdoScissors);

		rdoRock.setName("btnRock");
		rdoPaper.setName("btnPaper");
		rdoScissors.setName("btnScissors");

		ButtonGroup groupRadios = new ButtonGroup();
		groupRadios.add(rdoRock);
		groupRadios.add(rdoPaper);
		groupRadios.add(rdoScissors);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RockPaperScissorsGUI.class
				.getResource("/rockPaperScissors/ash.png")));
		pnlPlayerButtons.add(label);

		pnlPlayerButtons.add(rdoRock);
		pnlPlayerButtons.add(rdoPaper);
		pnlPlayerButtons.add(rdoScissors);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(RockPaperScissorsGUI.class
				.getResource("/rockPaperScissors/dawn.png")));
		pnlPlayerButtons.add(label_1);
		// Contains an empty spacer panel.
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBorder(new EmptyBorder(0, 40, 100, 40));
		pnlCenter.setBackground(Color.RED);
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout(0, 0));

		JLabel lblSpacer = new JLabel("V.S");
		lblSpacer.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpacer.setFont(new Font("Arial Black", Font.BOLD, 36));
		pnlCenter.add(lblSpacer);
		JButton btnExitGame = new JButton("Exit Game");
		pnlCenter.add(btnExitGame, BorderLayout.SOUTH);
		addExitGameListener(btnExitGame);

	}

	// Method to execute the exit button in the middle of the screen of the
	// game.
	public static void addExitGameListener(JButton b) {
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
	}

	// Method to assign a random number to pick out a random choice of rock,
	// paper, scissors.
	private static int assignComputer() {

		Random r = new Random();
		return r.nextInt(3) + 1;
	}

	// Method to scale Icons.
	private static ImageIcon resizeIcon(ImageIcon img) {
		Image newimg = img.getImage();
		newimg = newimg
				.getScaledInstance(150, 115, java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(newimg);
		return img;
	}

	// Method to scale Icons.
	private static ImageIcon resizeBlankIcon(ImageIcon img) {
		Image newimg = img.getImage();
		newimg = newimg
				.getScaledInstance(384, 340, java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(newimg);
		return img;
	}

	// Here is the ActionListener for the click event for one of the three
	// buttons of rock, paper or scissors.
	// There are also 4 other methods that get called that to interact with the
	// GUI and run the Logic.
	private static void addAListener(JButton b) {
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (b.getName() == "btnRock") {
					player = 1;
				} else if (b.getName() == "btnPaper") {
					player = 2;
				}

				else if (b.getName() == "btnScissors") {
					player = 3;
				}
				changePlayerPic(player);
				computer = assignComputer();
				changeComputerPic(computer);

				evaluate(player, computer);
			}

		});
	}

	// This method calls the Equals method that Evaluates from the rpsEnums
	// Class for winning and losing and draw combinations.
	private static void evaluate(int player, int computer) {
		assignWin(RPSChoices.equals(player, computer));
		checkForWinner(RPSChoices.equals(player, computer));
	}

	// This method will set the score in a txt field.
	private static void assignWin(int score) {
		switch (score) {
		case 1:
			txtPlayerScore.setText(Integer.parseInt(txtPlayerScore.getText())
					+ 1 + "");
			break;
		case 2:
			txtComputerScore.setText(Integer.parseInt(txtComputerScore
					.getText()) + 1 + "");
			break;
		case 3: // Tie.
			break;
		default:

		}
	}

	// This method sets the text for if they win, lose or tie.
	private static void checkForWinner(int score) {
		switch (score) {
		case 1:
			txtresult.setText("You Are a Pokemon Master!!!");
			break;
		case 2:
			txtresult.setText("You need more training!");
			break;
		case 3:
			txtresult.setText("Tie");
			break;
		default:

		}
	}

	// This Method gets called to assign an image for the computers choice when
	// the user clicks one of the buttons for rock, paper, scissors.
	private static void changeComputerPic(int pic) {
		switch (pic) {
		case 1:
			lblComputerPic.setIcon(resizeBlankIcon(new ImageIcon(
					RPSChoices.class.getResource("/rockPaperScissors/3.png"))));
			break;
		case 2:
			lblComputerPic.setIcon(resizeBlankIcon(new ImageIcon(
					RPSChoices.class.getResource("/rockPaperScissors/4.png"))));
			break;
		case 3:
			lblComputerPic.setIcon(resizeBlankIcon(new ImageIcon(
					RPSChoices.class.getResource("/rockPaperScissors/5.jpg"))));
			break;
		default:
			break;

		}

	}

	// This Method gets called when the user clicks one of the buttons for rock,
	// paper, scissors.
	private static void changePlayerPic(int pic) {
		switch (pic) {
		case 1:
			lblPlayerPic.setIcon(resizeBlankIcon(new ImageIcon(RPSChoices.class
					.getResource("/rockPaperScissors/3.png"))));
			break;
		case 2:
			lblPlayerPic.setIcon(resizeBlankIcon(new ImageIcon(RPSChoices.class
					.getResource("/rockPaperScissors/4.png"))));
			break;
		case 3:
			lblPlayerPic.setIcon(resizeBlankIcon(new ImageIcon(RPSChoices.class
					.getResource("/rockPaperScissors/5.jpg"))));
			break;
		default:

		}

	}

}
