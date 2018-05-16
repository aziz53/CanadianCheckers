import javax.swing.JFrame;
import javax.swing.JPanel;


public class CanadianCheckers extends JFrame {
	
	public static CanadianCheckers frame;
	public static CheckerPiece[][] board;
	
	/**
	 * Method that sets the content panel for the JFrame.
	 * @param panel the panel that users will see.
	 */
	public static void setContent(JPanel panel){
		frame.setContentPane(panel);
		frame.revalidate();
	}
	
	/**
	 * Method to create the board with empty pieces.
	 */
	public static void initializeBoard(){
		board = new CheckerPiece[12][12];
		for(int row = 0; row < 12; row++){
			for(int col = 0; col < 12; col++){
				CheckerPiece piece = new CheckerPiece();
				board[row][col] = piece;
			}
		}
		
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 12; j+=2){
				if(i % 2 == 0 && j == 0){
					j = 1;
				}
				CheckerPiece piece = board[i][j];
				piece.setExistence(true);
				piece.setStatus(true);
			}
		}
		
		for(int i = 11; i > 6; i--){
			for(int j = 0; j < 12; j+=2){
				if(i % 2 != 0 && j == 0){
					j = 1;
				}
				CheckerPiece piece = board[i][j];
				piece.setExistence(true);
				piece.setStatus(false);
			}
		}
		
		
	}
	
	 public static void buildTree(CheckerPiece[][] board){
   int max = 0;
   int oldX = 0;
   int oldY = 0;
   int maxX = 0;
   int maxY = 0;
   for(int i=0; i<board[i].length; i++){
     for(int j=0; j<board[j].length; j++){
       if(board[i][j].getStatus() == true){
         int points = board[i][j].getPoints(i,j);
         int xLoc = board[i][j].getNewX();
         int yLoc = board[i][j].getNewY();
         if(points > max){
           max = points;
           oldX = j;
           oldY = i;
           maxX = xLoc;
           maxY = yLoc;
         }
       }
     }
   }
   int savedPoints = 0;
   oldX = 0;
   oldY = 0;
   int safeX = 0;
   int safeY = 0;
   pointTree.addRight(max,oldX,oldY,maxX,maxY);
   if(max > 0){
     return;
   }
   for(int i=0; i<board[i].length; i++){
     for(int j=0; j<board[j].length; j++){
       if(board[i][j].getStatus() == false){
         int points = board[i][j].getPoints(i,j);
         int xLoc = board[i][j].getSafeX();
         int yLoc = board[i][j].getSafeY();
         if(points > savedPoints){
           savedPoints = points;
           oldX = j;
           oldY = i;
           safeX = xLoc;
           safeY = yLoc;
         }
       }
     }
   }
   pointTree.addLeft(savedPoints,oldX,oldY,safeX,safeY);
 }
	
	public CanadianCheckers(){
		setTitle("Canadian Checkers");
		setVisible(true);
		setSize(720, 745);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		System.out.println("> Starting Canadian Checkers...");
		frame = new CanadianCheckers();
		initializeBoard();
		setContent(new MainMenu());
	}
	
}
