/**
 * Jerry, Justin
 * CheckerPiece class design for the checker objects in the game
 * May 11th, 2018
 */
public class CheckerPiece {
  
  //boolean variable that sets whether or not the piece exists or not 
  private boolean doesExist;
  
  //the coordinates of the checker piece on the board
  private int xCoord;
  private int yCoord;
  
  //the current status of the piece (black/white, red/white etc)
  private boolean status;
  
  //default constructor of checkerpiece that is useful for setting non-existent spaces in the 2d array
  public CheckerPiece() {
    this.xCoord=0;
    this.yCoord=0;
    this.status=false;
    this.doesExist=false;
  }
  
  //Set the position of the checker piece object (one that exists/doesnt)
  public CheckerPiece(int startingX, int startingY,boolean status, boolean doesExist) {
    this.xCoord=startingX;
    this.yCoord=startingY;
    this.status=status;
    this.doesExist=doesExist;
  }
  
  //method that returns the x coordinate of the checkerpiece on the board
  //@returns the x coordinate
  public int returnXCoord() {
   return this.xCoord; 
  }
  
  //method that returns the y coordinate of the checkerpiece on the board
  //@returns the y coordinate
  public int returnYCoord() {
   return this.yCoord; 
  }
  
  //method that returns the status of the checkerpiece (black/white, red/blue, etc)
  //@returns the type of checkerpiece
  public boolean getStatus() {
   return this.status; 
  }
  
  //method that checks whether or not the method exists on the board
  //@returns the existence of the piece
  public boolean getExistence() { 
    return this.doesExist;
  }                              
  
  //sets the coordinate of the piece on the board
  //@param1 is the x coordinate of the piece
  //@param2 is the y coordinate of the piece
  public void setCoords(int x, int y) {
   this.xCoord=x;
   this.yCoord=y;
  }
  
  //method that checks whether or not a piece can take (white piece)
  public boolean hasToTake() {
    if(this.status) {
      
      //Checks whether or not a piece to the diagonal top left of the piece and if its opposite status
      if (CanadianCheckers.board[this.returnXCoord()-1][this.returnYCoord()+1].getExistence()) {
        if(CanadianCheckers.board[this.returnXCoord()-1][this.returnYCoord()+1].getStatus()!=this.status) {
         return true; 
        }
      }
      
      //Checks whether or not a piece to the diagonal top right of the piece and if its opposite status
      if (CanadianCheckers.board[this.returnXCoord()+1][this.returnYCoord()+1].getExistence()) {
        if(CanadianCheckers.board[this.returnXCoord()+1][this.returnYCoord()+1].getStatus()!=this.status) {
         return true; 
        }
      }
      
    }
    
    //method that checks whether or not a piece can take (black piece)
    else if (!this.status){
      
      //Checks whether or not a piece to the diagonal top left of the piece and if its opposite status
      if (CanadianCheckers.board[this.returnXCoord()-1][this.returnYCoord()-1].getExistence()) {
        if(CanadianCheckers.board[this.returnXCoord()-1][this.returnYCoord()-1].getStatus()!=this.status) {
         return true; 
        }
      }
      
      //Checks whether or not a piece to the diagonal top right of the piece and if its opposite status
      if (CanadianCheckers.board[this.returnXCoord()+1][this.returnYCoord()-1].getExistence()) {
        if(CanadianCheckers.board[this.returnXCoord()+1][this.returnYCoord()-1].getStatus()!=this.status) {
         return true; 
        }
      }
      
    }
    return false;
  }
  
}
