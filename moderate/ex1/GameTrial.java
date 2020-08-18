public class Game
{

// ----------------------------------------------------------------------
// Part a: the score message
  private String scoreMessage;

  public String getScoreMessage()
  {
    return scoreMessage;
  } // getScoreMessage


  public void setScoreMessage(String message)
  {
    scoreMessage = message;
  } // setScoreMessage


  public String getAuthor()
  {
    return "Andrei Korovin";
  } // getAuthor


// ----------------------------------------------------------------------
// Part b: constructor and grid accessors
  private final int gridSize;
  private final Cell [][] Grid;
  

  public Game(int requiredGridSize)
  {
    gridSize = requiredGridSize;
    Grid = new Cell[gridSize][gridSize];
    for (int row = 0; row<gridSize; row++)
      for (int col = 0; col<gridSize; col++)
        Grid[row][col] = new Cell();
        
  } // Game


  public int getGridSize()
  {
    return gridSize;
  } // getGridSize


  public Cell getGridCell(int x, int y)
  {
    return Grid[x][y];
  } // getGridCell


// ----------------------------------------------------------------------
// Part c: initial game state

// Part c-1: setInitialGameState method
  private int score;
  public void setInitialGameState(int requiredTailX, int requiredTailY,
                                  int requiredLength, int requiredDirection)
  {
    for (int row = 0; row<gridSize; row++)
      for (int col = 0; col<gridSize; col++)
        Grid[row][col].setClear();
    placeSnake(requiredTailX,requiredTailY, requiredLength, requiredDirection);
    placeFood();
    

    score = 0;
  } // setInitialGameState


// ----------------------------------------------------------------------
// Part c-2 place food
   private void placeFood() {
   int x, y;

   do {
     x = (int) (Math.random() *(gridSize-1));
     y = (int) (Math.random() *(gridSize-1));
   }
   while (Grid[x][y].getType() != Cell.CLEAR);
   Grid[x][y].setFood();
   
   }
// ----------------------------------------------------------------------
// Part c-3: place snake
   private int TailX, TailY, HeadX, HeadY, Length, snakeDirection;

   private void placeSnake(int requiredTailX, int requiredTailY,
                           int requiredLength, int requiredDirection) {
   TailX = requiredTailX;
   TailY = requiredTailY;
   Length = requiredLength;
   snakeDirection = requiredDirection;
   Grid[TailX][TailY].setSnakeTail(Direction.opposite(snakeDirection),
                                   snakeDirection);
  
   int BodyX = TailX + Direction.xDelta(snakeDirection);
   int BodyY = TailY + Direction.yDelta(snakeDirection);
   for (int index = 0; index < Length-2; index++)
   {
     Grid[BodyX][BodyY].setSnakeBody(Direction.opposite(snakeDirection),
                                     snakeDirection);
     BodyX += Direction.xDelta(snakeDirection);
     BodyY += Direction.yDelta(snakeDirection);
   }
   HeadX = BodyX;
   HeadY = BodyY;
   Grid[HeadX][HeadY].setSnakeHead(Direction.opposite(snakeDirection),
                                   snakeDirection);
   
   }

// ----------------------------------------------------------------------
// Part d: set snake direction


  public void setSnakeDirection(int requiredDirection)
  {
    if (requiredDirection == Direction.opposite(snakeDirection))
      scoreMessage = "You can not go back!";
    else
    {
      Grid[HeadX][HeadY].setSnakeHead(Direction.opposite(snakeDirection),
                                      requiredDirection);
      snakeDirection = requiredDirection;
    }
  } // setSnakeDirection


// ----------------------------------------------------------------------
// Part e: snake movement

// Part e-1: move method


  public void move(int moveValue)
  {
    if (Grid[HeadX][HeadY].isSnakeBloody() == false)
    {
      int newX = HeadX;
      int newY = HeadY;
      newX += Direction.xDelta(snakeDirection);
      newY += Direction.yDelta(snakeDirection);
      if (okayToMove(newX,newY) == true)
      {
        boolean foodIsHere;

        if (Grid[newX][newY].getType() == Cell.FOOD)
        {
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
    int newOutDirect = Grid[xValue][yValue].getSnakeOutDirection();
    int newInDirect = Grid[HeadX][HeadY].getSnakeInDirection();





    Grid[HeadX][HeadY].setSnakeBody(newInDirect,
                                   snakeDirection);
   
    Grid[xValue][yValue].setSnakeHead(Direction.opposite(snakeDirection),
                                      snakeDirection);
    

    HeadX = xValue;
    HeadY = yValue;
 

      


  }

// ----------------------------------------------------------------------
// Part e-3: move the snake tail
  public void moveTail() {
     int tailOut = Grid[TailX][TailY].getSnakeOutDirection();
     Grid[TailX][TailY].setClear();
     TailX += Direction.xDelta(tailOut);
     TailY += Direction.yDelta(tailOut);
     int newTailOut = Grid[TailX][TailY].getSnakeOutDirection();
     Grid[TailX][TailY].setSnakeTail(Direction.opposite(tailOut),
                                  newTailOut);
  }

// ----------------------------------------------------------------------
// Part e-4: check for and deal with crashes
  public boolean okayToMove(int nextX,int nextY) {
  if (nextX<0 || nextY<0 || nextX==gridSize || nextY==gridSize)
    {
      Grid[HeadX][HeadY].setSnakeBloody(true);
      scoreMessage = "Do not try to go through the wall!";
      return false;
    }
    else if (Grid[nextX][nextY].isSnakeType())
    {
      Grid[HeadX][HeadY].setSnakeBloody(true);
      Grid[nextX][nextY].setSnakeBloody(true);
      scoreMessage = "Ooops! You ate yourself!";
      return false;
     }
    else 
      return true;
  }

// ----------------------------------------------------------------------
// Part e-5: eat the food
  public void eatFood(int moveValue) {
  Length ++;
  int result = score;
  score += moveValue * ((Length / (gridSize * gridSize / 36 + 1)) + 1);  
  result = score - result;
  placeFood();
  scoreMessage = "Yummy!You just got " + result + " scores";
  }

  public int getScore()
  {
    return score;
  } // getScore


// ----------------------------------------------------------------------
// Part f: cheat


  public void cheat()
  {
    score /=2;
    scoreMessage = "Your score was halved by " + score;
    for (int x=0; x < gridSize; x++)
      for (int y = 0; y < gridSize; y++)
        Grid[x][y].setSnakeBloody(false);
  
  } // cheat


// ----------------------------------------------------------------------
// Part g: trees


  public void toggleTrees()
  {
  } // toggleTrees


// ----------------------------------------------------------------------
// Part h: crash countdown


// ----------------------------------------------------------------------
// Part i: optional extras


  public String optionalExtras()
  {
    return "  No optional extras defined\n";
  } // optionalExtras


  public void optionalExtraInterface(char c)
  {
    if (c > ' ' && c <= '~')
      setScoreMessage("Key " + new Character(c).toString()
                      + " is unrecognised (try h)");
  } // optionalExtraInterface

} // class Game
