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
         int points = getPoints(board,i,j);
         if(points > max){
           System.out.println("BEST MOVE IS DIRECTLY BELOW: From Y: " + i + " From X: " + j);
           max = points;
         }
       }
     }
   }
   if(max == 0){
     for(int i=0; i<board[i].length; i++){
       for(int j=0; j<board[j].length; j++){
         if(board[i][j].getStatus() == true){
           if(i > -1 && j > -1){
             if(board[i+1][j+1].getExistence() == false){
               System.out.println("MOVE FROM: Y: " + i + " X: " + j + " TO " + "Y: " + (i+1) + " X " + (j+1));
               break;
             }
           }
           if(i > -1 && j < 12){
             if(board[i+1][j-1].getExistence() == false){
               System.out.println("MOVE FROM: Y: " + i + " X: " + j + " TO " + "Y: " + (i+1) + " X " + (j-1));
               break;
             }
           } 
         }
       }
     }
   }
 }
	
public static int getPoints(CheckerPiece[][] checkerBoard, int y, int x){
   if(y > -1 && x > -1){
     if(checkerBoard[y][x].getStatus() != checkerBoard[y+1][x+1].getStatus()){
       return 1 + getPoints(board,y+2,x+2);
     }
   }else if(y > -1 && x < 12){
     if(checkerBoard[y][x].getStatus() != checkerBoard[y+1][x-1].getStatus()){
       return 1 + getPoints(board,y+2,x-2);
     }
   }
   System.out.println("Y: " + y + " X: " + x);
   return 0;
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
