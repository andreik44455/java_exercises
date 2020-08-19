public class Game
{

// ----------------------------------------------------------------------
// Part a: the score message

  //variable for message for user
  private String scoreMessage;

  //accessor method
  public String getScoreMessage()
  {
    return scoreMessage;
  } // getScoreMessage

  //mutator method
  public void setScoreMessage(String message)
  {
    scoreMessage = message;
  } // setScoreMessage

  //returns my name
  public String getAuthor()
  {
    return "Andrei Korovin";
  } // getAuthor


// ----------------------------------------------------------------------
// Part b: constructor and grid accessors

  //variable for a size of the grid
  private final int gridSize;

  //2 dimensional array of Cell type
  private final Cell [][] Grid;
  
  //constructor of the class Game
  public Game(int requiredGridSize)
  {
    //assigning grid size to an argument 
    gridSize = requiredGridSize;

    //assigning the size of the array
    Grid = new Cell[gridSize][gridSize];

    //fill the array with cells by 2 nested loops
    for (int row = 0; row<gridSize; row++)
      for (int col = 0; col<gridSize; col++)
        Grid[row][col] = new Cell();
        
  } // Game

  //accessor method
  public int getGridSize()
  {
    return gridSize;
  } // getGridSize

  //accessor method
  public Cell getGridCell(int x, int y)
  {
    return Grid[x][y];
  } // getGridCell


// ----------------------------------------------------------------------
// Part c: initial game state

// Part c-1: setInitialGameState method
  
  //variable for storing the score
  private int score;
 
  //method for initial state of the Snake game
  public void setInitialGameState(int requiredTailX, int requiredTailY,
                                  int requiredLength, int requiredDirection)
  {
    //start with 0 number of trees
    numberOfTree = 0;

    //set clear all the cells in the array
    for (int row = 0; row<gridSize; row++)
      for (int col = 0; col<gridSize; col++)
        Grid[row][col].setClear();

    //call the placeSnake method by giving 4 arguments
    placeSnake(requiredTailX,requiredTailY,
               requiredLength, requiredDirection);
 
    //call placeFood method
    placeFood();
 
    //call placeTree method only if treeEnable is true
    if (treeEnable == true) {
      placeTree();
    }
    
    //set score to 0
    score = 0;
  } // setInitialGameState


// ----------------------------------------------------------------------
// Part c-2 place food

  private void placeFood() {

    //variables for coordinates of the grid
    int x, y;
     
    //loop for getting random coordinates in a grid but not into busy coords
    do {
      x = (int) (Math.random() *(gridSize-1));
      y = (int) (Math.random() *(gridSize-1));
    } while (Grid[x][y].getType() != Cell.CLEAR);

    //place food in calculated coordinates
    Grid[x][y].setFood();
   
  }
// ----------------------------------------------------------------------
// Part c-3: place snake

  //variables for coords of tail and head, length and direction of the snake
  private int TailX, TailY, HeadX, HeadY, Length, snakeDirection;
   
  //method for placing the snake in the grid
  private void placeSnake(int requiredTailX, int requiredTailY,
                          int requiredLength, int requiredDirection) {

    //assign given coords of tail
    TailX = requiredTailX;
    TailY = requiredTailY;
   
    //assign given length
    Length = requiredLength;
  
    //assign given direction
    snakeDirection = requiredDirection;
   
    //place a snake tail with out direction of the snake and in opposite
    Grid[TailX][TailY].setSnakeTail(Direction.opposite(snakeDirection),
                                    snakeDirection);
    //getting coords of a body of a snake one before the tail   
    int BodyX = TailX + Direction.xDelta(snakeDirection);
    int BodyY = TailY + Direction.yDelta(snakeDirection);
   
    //placing each cell of a body in a loop
    for (int index = 0; index < Length-2; index++) {
      Grid[BodyX][BodyY].setSnakeBody(Direction.opposite(snakeDirection),
                                      snakeDirection);
      BodyX += Direction.xDelta(snakeDirection);
      BodyY += Direction.yDelta(snakeDirection);
    }
   
    //placing the snake head in the last calculated coords in the loop
    HeadX = BodyX;
    HeadY = BodyY;
    Grid[HeadX][HeadY].setSnakeHead(Direction.opposite(snakeDirection),
                                    snakeDirection);
   
  }

// ----------------------------------------------------------------------
// Part d: set snake direction

  //method for setting snake Direcrion with given one
  public void setSnakeDirection(int requiredDirection)
  {
    //do not allow snake to face itself
    if (requiredDirection == Direction.opposite(snakeDirection))
      scoreMessage = "You can not go back!";
    else {
      //Grid[HeadX][HeadY].setSnakeHead(Direction.opposite(snakeDirection),
      //                                requiredDirection);
      //set out direction of the head to the given one 
      Grid[HeadX][HeadY].setSnakeOutDirection(requiredDirection);
      snakeDirection = requiredDirection;
    }
  } // setSnakeDirection


// ----------------------------------------------------------------------
// Part e: snake movement

// Part e-1: move method


  public void move(int moveValue)
  {
    //if snake head is not bloody - create the next cell of the head
    if (Grid[HeadX][HeadY].isSnakeBloody() == false) {
      int newX = HeadX;
      int newY = HeadY;
      newX += Direction.xDelta(snakeDirection);
      newY += Direction.yDelta(snakeDirection);
      //if it is okay to move(check a crash at new pos and deal with it)
      if (okayToMove(newX,newY) == true) {
        //variable to remember whether there is food in the new head pos
        boolean foodIsHere;
        //if there is food in new pos -move head, eat food, 
        //else - move head and tail.
        if (Grid[newX][newY].getType() == Cell.FOOD) {         
          moveHead(newX,newY);
          foodIsHere = true;
          eatFood(moveValue);
        }
        else {
          moveHead(newX,newY);
          moveTail();     
        }   
      }
    }
   
  } // move


// ----------------------------------------------------------------------
// Part e-2: move the snake head
  public void moveHead(int xValue,int yValue) {
     
    //get in direction of the snake   
    int newInDirect = Grid[HeadX][HeadY].getSnakeInDirection();
 
    //place snake body in the head cell
    Grid[HeadX][HeadY].setSnakeBody(newInDirect,
                                    snakeDirection);
   
    //place snake head in the new coords
    Grid[xValue][yValue].setSnakeHead(Direction.opposite(snakeDirection),
                                      snakeDirection);
    
    //update coords of the head with a new ones.
    HeadX = xValue;
    HeadY = yValue;
  }

// ----------------------------------------------------------------------
// Part e-3: move the snake tail
  public void moveTail() {

    //get out direction of a snake tail
    int tailOut = Grid[TailX][TailY].getSnakeOutDirection();
    
    //clear the cell
    Grid[TailX][TailY].setClear();
  
    //get coords of the cell which is the one before the tail
    TailX += Direction.xDelta(tailOut);
    TailY += Direction.yDelta(tailOut);

    //get its out direction
    int newTailOut = Grid[TailX][TailY].getSnakeOutDirection();

    //place snake tail in new coords with its directions
    Grid[TailX][TailY].setSnakeTail(Direction.opposite(tailOut),
                                    newTailOut);
  }

// ----------------------------------------------------------------------
// Part e-4: check for and deal with crashes
  public boolean okayToMove(int nextX,int nextY) {

    //do not allow snake to go out of the grid
    if (nextX<0 || nextY<0 || nextX==gridSize || nextY==gridSize) { 
      scoreMessage = "Do not try to go through the wall!";

      //if 0 moves left - set snake bloody
      Grid[HeadX][HeadY].setSnakeBloody(reduceCount());
      
      return false;
    } else if (Grid[nextX][nextY].isSnakeType()) {
      //do not allow snake to eat itself
      if (reduceCount()) {
        //if 0 moves left - set snake bloody 
        Grid[HeadX][HeadY].setSnakeBloody(true);
        Grid[nextX][nextY].setSnakeBloody(true);
        scoreMessage = "Ooops! You ate yourself!";
      }
      
      return false;
    } else if (Grid[nextX][nextY].getType() == Cell.TREE) {
      //do not allow to go through the tree
      scoreMessage = "Did not you see this?";

      //if 0 moves left - set snake bloody
      Grid[HeadX][HeadY].setSnakeBloody(reduceCount());
      return false;
    }
    else {
      //reset current count down when it is okay to move
      resetCount();
      return true;
    }
  }

// ----------------------------------------------------------------------
// Part e-5: eat the food
  public void eatFood(int moveValue) {
    //increase length of the snake by one
    Length ++;  
    int treeScore = score;
    //remeber the current score
    int result = score;
    int treeResult = treeScore;
    //if trees enable - use another formula for the score and place tree
    if (treeEnable == true) {
      //compute the score with trees
      treeScore += numberOfTree*moveValue *
               ((Length / (gridSize * gridSize / 36 + 1)) + 1);
      //compute the increase with trees
      treeResult = treeScore - treeResult;
      
      //compute normal score
      score += moveValue * ((Length / (gridSize * gridSize / 36 + 1)) + 1);  

      //compute how much scores you got
      result = score - result;
     
      scoreMessage = "Yummy!You just got " + treeResult + " scores / " +
                     numberOfTree + " trees in the grid! / " + result +
                     " is actual increase";
      score = treeScore;
      placeTree();
    }
    //else use default formula for scores
    else  {
      //compute normal score
      score += moveValue * ((Length / (gridSize * gridSize / 36 + 1)) + 1);  
  
      //compute how much scores you got
      result = score - result;

      scoreMessage = "Yummy!You just got " + result + " scores!";
    }

    //call place food method
    placeFood();
    
  }

  public int getScore()
  {
    return score;
  } // getScore


// ----------------------------------------------------------------------
// Part f: cheat


  public void cheat()
  {
    //half the score
    score /= 2;
    
    scoreMessage = "Your score was halved by " + score;
    
    //make the snake green
    for (int x = 0; x < gridSize; x++)
      for (int y = 0; y < gridSize; y++)
        Grid[x][y].setSnakeBloody(false);
  
  } // cheat


// ----------------------------------------------------------------------
// Part g: trees
  //variable to emeber whether the trees enabled or not
  private boolean treeEnable;
  
  //current number of trees
  private int numberOfTree;
  
  //switches trees on or off
  public void toggleTrees()
  {
    //if off - switch on and place a tree
    if (treeEnable == false) {
      treeEnable = true; 
      //call palceTree method
      placeTree();
    }
    else {
      //if on - switch off 
      treeEnable = false;
      //nested for loop to clear the grid from the trees
      for (int row = 0; row<gridSize; row++)
        for (int col = 0; col<gridSize; col++)
          if (Grid[row][col].getType() == Cell.TREE)
            Grid[row][col].setClear(); 
    }
  } // toggleTrees
  
  //method to place a tree
  private void placeTree() {
    //x and y coordinates for new tree
    int x, y;

    //increase number of trees by  one
    numberOfTree ++;
  
    //loop for getting random coordinates in a grid but not into busy coords
    do {
     x = (int) (Math.random() *(gridSize-1));
     y = (int) (Math.random() *(gridSize-1));
    } while (Grid[x][y].getType() != Cell.CLEAR);
   
     //place tree in the computed coords
     Grid[x][y].setTree();
   
   }//place Tree


// ----------------------------------------------------------------------
// Part h: crash countdown
  //crash countdown start value
  private final int numberOfMoves = 5;
  
  //variable to remember current countdown value
  private int currentCountdown;

  //method to reset the current countdown value
  private void resetCount() {
 
    //the current countdown is less than the countdown start, then show message
    if (currentCountdown < numberOfMoves) { 
      scoreMessage = "You have escaped from death by " +
                     currentCountdown + " moves!";
    }//if

    //update the current countdown with start value
    currentCountdown = numberOfMoves; 
  }//resetCount

  //method to redice the current countdown
  private boolean reduceCount() {
    //decrease countdown by one
    currentCountdown--;
    
    //output message for user that he/she has only so many moves before death 
    if (currentCountdown > 0) {
      scoreMessage = "You have left " + currentCountdown + 
                     " moves before death!";
      return false;
    } 
    else {
      //reset it to the countdown start
      currentCountdown = numberOfMoves;
      return true;
    }//else
  
  }//reduceCount

  

// ----------------------------------------------------------------------
// Part i: optional extras

//burning trees

  //coords of the tree in front of a snake
  private int xBurn, yBurn;

  //method to burn a tree
  private void burnTree() {
   //find coords of the tree in front of us
   xBurn = HeadX + Direction.xDelta(snakeDirection);
   yBurn = HeadY + Direction.yDelta(snakeDirection);

    //if the next cell is not out of bounds and it is tree, then burn it
    if (xBurn>=0 && yBurn>=0 && xBurn<gridSize && yBurn<gridSize &&
        Grid[xBurn][yBurn].getType() == Cell.TREE) {
      Grid[xBurn][yBurn].setClear();
      numberOfTree--;
      scoreMessage = "Now " + numberOfTree + " trees left!";
    }
  }


  public String optionalExtras()
  {
    return "  No optional extras defined\n";
  } // optionalExtras


  public void optionalExtraInterface(char c)
  {
    if (c == 'b')
      burnTree();
    else if (c > ' ' && c <= '~')
      setScoreMessage("Key " + c + " is unrecognised (try h)");
  } // optionalExtraInterface

} // class Game
