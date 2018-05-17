//Imports
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//Board Panel Class
public class BoardPanel extends JPanel {

  /*
   * The Paint Method This Method Creates the Board and Checker Pieces
   * @param g Graphics for drawing checker board
   */
  public void paint(Graphics g) {

    //String arrays for board Co-Ordinates
    String [] Letters = {"A","B","C","D","E","F","G","H","I","J","K","L"};
    String [] Numbers = {"1","2","3","4","5","6","7","8","9","10","11","12"};

    //Setting Font and Size
    g.setFont(new Font("NewTimesRoman", Font.PLAIN, 20));

// Variables
    int x;
    int y;

    // For Loop for each row element
    for (int row = 0; row < 12; row++) {
      // For loop for each column element
      for (int col = 0; col < 12; col++) {
        // Setting co-ordinates for squares
        x = (col * 60)+60;
        y = (row * 60)+60;
        g.drawString(Letters[col],x+25,30);
        g.drawString(Numbers[row],30,y+25);

        // Drawing Squares
        if ((row % 2) == (col % 2)) {
          g.setColor(new Color(119, 95, 62));
        } else {
          g.setColor(new Color(66, 50, 27));
        }
        g.fillRect(x, y, 60, 60);
      } // End or column loop
    } // End of row loop
    // Calling updateBoard Method
    updateBoard(g, CanadianCheckers.board); // Change for actual class
  }

  /*
   * The updateBoard Method This method draws the checker pieces on the board
   * given the 2d array
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
          x = (col * 60) + 72;
          y = (row * 60) + 72;

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
          }
        }

      } // End of column loop
    } // End of row loop
  }
}
