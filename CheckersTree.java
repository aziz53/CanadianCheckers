class CheckersTree{
  private CheckersNode root;
  CheckersTree(){
    this.root = new CheckersNode(null,null,0,0,0,0,0);
  }
  void addRight(int max, int oldX, int oldY, int maxX, int maxY){
    if(this.root.getRight() == null){
      this.root.setRight(max,oldX,oldY,maxX,maxY);
      return;
    }
    addRightHelper(root.getRight(),max,oldX,oldY,maxX,maxY);
  }
  void addRightHelper(CheckersNode root, int max, int oldX, int oldY, int maxX, int maxY){
    if(root.getMax() < max){
      if(root.getRight() == null){
        root.setRight(max,oldX,oldY,maxX,maxY);
        return;
      }else{
        addRightHelper(root.getRight(),max,oldX,oldY,maxX,maxY);
      }
    }else{
      if(root.getLeft() == null){
        root.setLeft(max,oldX,oldY,maxX,maxY);
        return;
      }else{
        addRightHelper(root.getLeft(),max,oldX,oldY,maxX,maxY);
      }
    }
  }
  void addLeft(int max, int oldX, int oldY, int maxX, int maxY){
    if(this.root.getLeft() == null){
      this.root.setLeft(max,oldX,oldY,maxX,maxY);
      return;
    }
    addLeftHelper(root.getLeft(),max,oldX,oldY,maxX,maxY);
  }
    void addLeftHelper(CheckersNode root, int max, int oldX, int oldY, int maxX, int maxY){
    if(root.getMax() < max){
      if(root.getRight() == null){
        root.setRight(max,oldX,oldY,maxX,maxY);
        return;
      }else{
        addLeftHelper(root.getRight(),max,oldX,oldY,maxX,maxY);
      }
    }else{
      if(root.getLeft() == null){
        root.setLeft(max,oldX,oldY,maxX,maxY);
        return;
      }else{
        addLeftHelper(root.getLeft(),max,oldX,oldY,maxX,maxY);
      }
    }
  }
}
class CheckersNode{
  private CheckersNode right;
  private CheckersNode left;
  private int points;
  private int oldX;
  private int oldY;
  private int newX;
  private int newY;
  CheckersNode(CheckersNode right, CheckersNode left, int points, int oldX, int oldY, int newX, int newY){
    this.right = right;
    this.left = left;
    this.points = points;
    this.oldX = oldX;
    this.oldY = oldY;
    this.newX = newX;
    this.newY = newY;
  }
  void setRight(int max, int oldX, int oldY, int newX, int newY){
    this.right = new CheckersNode(null,null,max,oldX,oldY,newX,newY);
  }
  void setLeft(int max, int oldX, int oldY, int newX, int newY){
    this.left = new CheckersNode(null,null,max,oldX,oldY,newX,newY);
  }
  CheckersNode getRight(){
    return this.right;
  }
  CheckersNode getLeft(){
    return this.left;
  }
  int getMax(){
    return this.points;
  }
  int getOldX(){
    return this.oldX;
  }
  int getOldY(){
    return this.oldY;
  }
  int getNewX(){
    return this.newX;
  }
  int getNewY(){
    return this.newY;
  }
}