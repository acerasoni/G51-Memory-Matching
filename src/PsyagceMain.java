
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Andrea Giulio Cerasoni
 */

public class PsyagceMain {

	final static int WIDTH = 4;
	final static int HEIGHT = 4;
	final static int COLOURS = 8;
	final static int TOT_BUTTONS = WIDTH * HEIGHT;
	final static int MAX_PER_COLOUR = TOT_BUTTONS/COLOURS;
	final static int BUT_SIZE = 100;

	int count, buttonCount, squareSelectOne, squareSelectTwo, redCount, blueCount, greenCount, yellowCount, orangeCount,
			whiteCount, cyanCount, magentaCount, blackCount, buttonClick = 0;

	public ColorButton[] buttons = new ColorButton[WIDTH * HEIGHT];
	public GenArray2<ColorButton> cbuttons = new GenArray2<ColorButton>(WIDTH * HEIGHT);
	public Iterator<ColorButton> buttonit = cbuttons.iterator();
	public int scoreOne, scoreTwo = 0;
	public boolean turnOne = true; // true = player one's turn, false =
									// player two's turn
	public boolean newRound = false;
	public boolean coloured = false;

	JFrame guiFrame = new JFrame();
	JLabel top = new JLabel();
	JLabel bottom = new JLabel();
	JPanel panel = new JPanel();
	Random rand = new Random();

	public void createGUI(PsyagceMain game) {

		guiFrame.setPreferredSize(new Dimension(850, 850));
		guiFrame.setTitle("Memory Game");
		top.setFont(new Font("Serif", Font.PLAIN, 35));
		bottom.setFont(new Font("Serif", Font.PLAIN, 35));
		guiFrame.setLayout(new BorderLayout(2, 2));
		panel.setLayout(new BorderLayout(2, 2)); // 2 pixel gaps
		panel.setLayout(new FlowLayout());
		panel.setLayout(new GridLayout(WIDTH, HEIGHT));
		guiFrame.add(panel, BorderLayout.CENTER);
		guiFrame.add(top, BorderLayout.NORTH);
		guiFrame.add(bottom, BorderLayout.SOUTH);

		populateArray(game);

		guiFrame.pack();
		guiFrame.setVisible(true);

	}

	public void populateArray(PsyagceMain reference) {
		while (count < (WIDTH * HEIGHT)) {
			int current = rand.nextInt(COLOURS);

			switch (current) {
			case 0:
				if (redCount < MAX_PER_COLOUR) {
					ColorButton newButton = new ColorButton(count, reference, BUT_SIZE, BUT_SIZE);
					newButton.setColour(Color.RED);
					newButton.draw();
					newButton.addListener();
					panel.add(newButton);
					buttons[count] = newButton;
					redCount++;
					count++;
				}
				break;
			case 1:
				if (blueCount < MAX_PER_COLOUR) {
					ColorButton newButton = new ColorButton(count, reference, BUT_SIZE, BUT_SIZE);
					newButton.setColour(Color.BLUE);
					newButton.draw();
					newButton.addListener();
					panel.add(newButton);
					buttons[count] = newButton;
					blueCount++;
					count++;
				}
				break;
			case 2:
				if (greenCount < MAX_PER_COLOUR) {

					ColorButton newButton = new ColorButton(count, reference, BUT_SIZE, BUT_SIZE);
					newButton.setColour(Color.GREEN);
					newButton.draw();
					newButton.addListener();
					panel.add(newButton);
					buttons[count] = newButton;
					greenCount++;
					count++;
				}
				break;
			case 3:
				if (yellowCount < MAX_PER_COLOUR) {

					ColorButton newButton = new ColorButton(count, reference, BUT_SIZE, BUT_SIZE);
					newButton.setColour(Color.YELLOW);
					newButton.draw();
					newButton.addListener();
					panel.add(newButton);
					buttons[count] = newButton;
					yellowCount++;
					count++;
				}
				break;
			case 4:
				if (orangeCount < MAX_PER_COLOUR) {

					ColorButton newButton = new ColorButton(count, reference, BUT_SIZE, BUT_SIZE);
					newButton.setColour(Color.ORANGE);
					newButton.draw();
					newButton.addListener();
					panel.add(newButton);
					buttons[count] = newButton;
					orangeCount++;
					count++;
				}

			case 5:
				if (whiteCount < MAX_PER_COLOUR) {

					ColorButton newButton = new ColorButton(count, reference, BUT_SIZE, BUT_SIZE);
					newButton.setColour(Color.WHITE);
					newButton.draw();
					newButton.addListener();
					panel.add(newButton);
					buttons[count] = newButton;
					whiteCount++;
					count++;
				}

			case 6:
				if (magentaCount < MAX_PER_COLOUR) {

					ColorButton newButton = new ColorButton(count, reference, BUT_SIZE, BUT_SIZE);
					newButton.setColour(Color.MAGENTA);
					newButton.draw();
					newButton.addListener();
					panel.add(newButton);
					buttons[count] = newButton;
					magentaCount++;
					count++;
				}

			case 7:
				if (cyanCount < MAX_PER_COLOUR) {

					ColorButton newButton = new ColorButton(count, reference, BUT_SIZE, BUT_SIZE);
					newButton.setColour(Color.CYAN);
					newButton.draw();
					newButton.addListener();
					panel.add(newButton);
					buttons[count] = newButton;
					cyanCount++;
					count++;
				}

			}
		}

	}

	public void repopulate() {
		while (count < (WIDTH * HEIGHT)) {
			int current = rand.nextInt(COLOURS);

			switch (current) {
			case 0:
				if (redCount < MAX_PER_COLOUR) {
					buttons[count].setColour(Color.RED);
					redCount++;
					count++;
				}
				break;
			case 1:
				if (blueCount < MAX_PER_COLOUR) {
					buttons[count].setColour(Color.BLUE);
					blueCount++;
					count++;
				}
				break;
			case 2:
				if (greenCount < MAX_PER_COLOUR) {

					buttons[count].setColour(Color.GREEN);
					greenCount++;
					count++;
				}
				break;
			case 3:
				if (yellowCount < MAX_PER_COLOUR) {

					buttons[count].setColour(Color.YELLOW);
					yellowCount++;
					count++;
				}
				break;
			case 4:
				if (orangeCount < MAX_PER_COLOUR) {

					buttons[count].setColour(Color.ORANGE);
					orangeCount++;
					count++;
				}

			case 5:
				if (whiteCount < MAX_PER_COLOUR) {

					buttons[count].setColour(Color.WHITE);
					whiteCount++;
					count++;
				}

			case 6:
				if (magentaCount < MAX_PER_COLOUR) {

					buttons[count].setColour(Color.MAGENTA);
					magentaCount++;
					count++;
				}

			case 7:
				if (cyanCount < MAX_PER_COLOUR) {

					buttons[count].setColour(Color.CYAN);
					cyanCount++;
					count++;
				}

			}
		}
		int x = 0;
		while (x < buttons.length) {
			buttons[x].showBlack = false;
			buttons[x].showColour = false;
			buttons[x].draw();
			x++;
		}

	}

	public void displayLabel() {

		top.setBackground(Color.GREEN);
		top.setOpaque(true);
		bottom.setOpaque(true);
		bottom.setBackground(Color.RED);
		bottom.setText("Player 2 - Score = " + scoreTwo + " / Player 1's turn, please wait.");
		top.setText("Player 1 - Score = " + scoreOne + " / Select your first square.");

	}

	public void promptCError() {
		JOptionPane.showMessageDialog(panel, "This square is already turned!", "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void promptBError() {
		JOptionPane.showMessageDialog(panel, "This is a Black square!", "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void startGame(PsyagceMain gameone) {

		createGUI(gameone);
		displayLabel();

	}

	public void initVars() {

		buttonCount = 0;
		squareSelectOne = 100;
		squareSelectTwo = 100;
		newRound = false;
		for (int x = 0; x < buttons.length; x++) {
			if (!buttons[x].showBlack)
				buttons[x].showColour = false;
			buttons[x].draw();
		}

	}

	public void reset(ColorButton a, ColorButton b, boolean c) {
		if (c) {
			a.flip(false);
			a.flip(false);
			a.draw();
			b.draw();
		} else {
			a.showBlack = true;
			b.showBlack = true;
			a.draw();
			b.draw();
		}
	}

	public void updateGen() {

		cbuttons.set(squareSelectOne, buttons[squareSelectOne]);
		cbuttons.set(squareSelectTwo, buttons[squareSelectTwo]);
		System.out.println("Test");
	}

	public void checkBlack() {
		for (ColorButton c : cbuttons) {
			if (c.showBlack)
				blackCount++;
		}
	}

	public void endGame() {

		updateGen();

		if (buttonClick == WIDTH * HEIGHT) {

			reset(buttons[squareSelectOne], buttons[squareSelectTwo], false);
			checkBlack();
			if (blackCount == WIDTH * HEIGHT) {
				if (scoreOne == scoreTwo)
					JOptionPane.showMessageDialog(panel, "It's a draw.", "Game concluded",
							JOptionPane.INFORMATION_MESSAGE);
				if (scoreOne > scoreTwo)
					JOptionPane.showMessageDialog(panel, "Player 1 wins!", "Game concluded",
							JOptionPane.INFORMATION_MESSAGE);
				if (scoreTwo > scoreOne)
					JOptionPane.showMessageDialog(panel, "Player 2 wins!", "Game concluded",
							JOptionPane.INFORMATION_MESSAGE);

				stateReset();
			}
		}

	}

	public void stateReset() {
		buttonCount = 0;
		squareSelectOne = 100;
		squareSelectTwo = 100;
		redCount = 0;
		blueCount = 0;
		greenCount = 0;
		yellowCount = 0;
		blackCount = 0;
		orangeCount = 0;
		whiteCount = 0;
		cyanCount = 0;
		magentaCount = 0;
		turnOne = true;
		scoreTwo = 0;
		scoreOne = 0;
		newRound = false;
		buttonClick = 0;
		count = 0;
		repopulate();
		displayLabel();
		guiFrame.pack();

	}

	public void displayResult(int first, int second) {
		if (buttons[first].buttonColour == buttons[second].buttonColour) {
			if (turnOne) {
				scoreOne = scoreOne + 2;
				top.setText("Player 1 - Score = " + scoreOne + " / Well done! Click a square to continue");
				newRound = true;
				coloured = false;
				buttonClick = buttonClick + 2;
				endGame();
			} else {
				scoreTwo = scoreTwo + 2;
				buttonClick = buttonClick + 2;
				bottom.setText("Player 2 - Score = " + scoreTwo + " / Well done! Correct Square Selected");
				newRound = true;
				coloured = false;
				endGame();
			}

		} else {
			if (turnOne) {
				top.setText("Player 1 - Score = " + scoreOne + " / Failed. Click a square to continue");
				newRound = true;
				coloured = true;
				turnOne = false;
				endGame();

			} else {
				bottom.setText("Player 2 - Score = " + scoreTwo + " / Failed. Click a square to continue");
				turnOne = true;
				newRound = true;
				coloured = true;
				endGame();
			}
		}
	}

	public void swap() {
		if (turnOne) {
			bottom.setText("Player 2 - Score = " + scoreTwo + " / Player 1's turn, please wait.");
			top.setText("Player 1 - Score = " + scoreOne + " / Select your first square.");
		} else {
			bottom.setText("Player 2 - Score = " + scoreTwo + " / Select your first square.");
			top.setText("Player 1 - Score = " + scoreOne + " / Player 2's turn, please wait.");

		}

	}

	public void buttonClicked(int iButton) {
		if (!newRound) {
			if (buttons[iButton].showBlack)
				promptBError();
			else {

				if (buttons[iButton].showColour) {
					promptCError();
				} else {
					buttons[iButton].flip(true);
					buttons[iButton].draw();
					buttonCount++;

					if (buttonCount == 1) {
						squareSelectOne = iButton;
						if (turnOne)
							top.setText("Player 1 - Score = " + scoreOne + " / Select your second square.");
						else
							bottom.setText("Player 2 - Score = " + scoreTwo + " / Select your second square.");
					} else {
						squareSelectTwo = iButton;
						displayResult(squareSelectOne, squareSelectTwo);
					}
				}

			}
		} else {
			reset(buttons[squareSelectOne], buttons[squareSelectTwo], coloured);
			initVars();
			swap();
		}
	}

	public static void main(String[] args) {

		PsyagceMain gameone = new PsyagceMain();
		PsyagceMain gametwo = new PsyagceMain();
		gameone.startGame(gameone);
		gametwo.startGame(gametwo);
		

	}

}
