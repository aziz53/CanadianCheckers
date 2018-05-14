//Imports
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
		updateBoard(g, CheckerPiece.checkerBoard); // Change for actual class
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
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(new File("crown.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// For loop through each row element
		for (int row = 0; row < checkerBoard.length; row++) {
			// For loop through each column element
			for (int col = 0; col < checkerBoard[row].length; col++) {
				if (checkerBoard[row][col].getExistence()) {

					// Setting co-ordinates of checker pieces
					x = (col * 60) + 12;
					y = (row * 60) + 12;

					// Drawing checker piece if it exists
					if (checkerBoard[row][col].getStatus() == true) {
						g.setColor(Color.WHITE);
					
					} else {
						g.setColor(Color.BLACK);	
					}
					g.fillOval(x, y, 35, 35);
					
					//Drawing Crown
					if (checkerBoard[row][col] instanceof King) {
						g.drawImage(image,(col * 60)+ 12 ,(row * 60) + 25,35,10,this);
						
						
					    
						System.out.println("Heyyyy");
					}
				}

			} // End of column loop
		} // End of row loop
	}
}
