//Imports
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

//Board Panel Class
public class BoardPanel extends JFrame {

	/*
	 * The Paint Method This Method Creates the Board and Checker Pieces
	 * 
	 * @param g Graphics for drawing checker board
	 */
	public void paint(Graphics g) {

		// Variables
		int x;
		int y;

		// For Loop for each row element
		for (int row = 0; row < 12; row++) {
			// For loop for each column element
			for (int col = 0; col < 12; col++) {
				// Setting co-ordinates for squares
				x = col * 60;
				y = row * 60;

				// Drawing Squares
				if ((row % 2) == (col % 2)) {
					g.setColor(Color.gray);
				} else {
					g.setColor(Color.LIGHT_GRAY);
				}
				g.fillRect(x, y, 60, 60);
			} // End or column loop
		} // End of row loop
			// Calling updateBoard Method
		updateBoard(g, CanadianCheckers.checkerBoard); // Change for actual class
	}

	/*
	 * The updateBoard Method This method draws the checker pieces on the board
	 * given the 2d array
	 * 
	 * @param checkerBoard A 2D array containing the checker board pieces
	 */
	public void updateBoard(Graphics g, CheckerPiece [][] checkerBoard) {

		// Variables
		int x;
		int y;

		// For loop through each row element
		for (int row = 0; row < checkerBoard.length; row++) {
			// For loop through each column element
			for (int col = 0; col < checkerBoard[row].length; col++) {
				if (checkerBoard[row][col].getExistence()) {

					// Setting co-ordinates of checker pieces
					x = (col * 60) + 25;
					y = (row * 60) + 25;

					// Drawing checker piece if it exists
					if (checkerBoard[row][col].getStatus() == true) {
						g.setColor(Color.GREEN);
						g.fillOval(x, y, 40, 40);
					} else {
						g.setColor(Color.RED);
						g.fillOval(x, y, 40, 40);
					}
				}

			} // End of column loop
		} // End of row loop
	}
}
