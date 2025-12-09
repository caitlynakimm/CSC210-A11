/* This class should implement the DisplayableMaze interface */
public class Maze implements DisplayableMaze {
  private MazeContents[][] mazeGrid;
  private int width;
  private int height;
  private MazeLocation start;
  private MazeLocation finish;
  
  public int getHeight() {
    return height;
  }
  public int getWidth() {
    return width;
  }

  public MazeContents getContents(int i, int j) {
    if (i >= 0 && i < height && j >= 0 && j < width) {
      return mazeGrid[i][j];
    } else {
      return null;
    }
  }

  public Boolean checkExplorable(int i, int j) {
    if (i < 0 || i >= height || j < 0 || j >= width) { //check if location is within bounds
      return false;
    }

    MazeContents contents = mazeGrid[i][j];
    return contents.isExplorable; //check if already visited location or reached a wall (field is from MazeContents class)
  }

  public MazeLocation getStart() {
    return start;
  }

  public MazeLocation getFinish() {
    return finish;
  }

  private boolean isFinish(MazeLocation location) {
    return location.equals(finish);
  }

  private void markCurrentLocation(MazeLocation location, MazeContents content) {
    if (location.getRow() >= 0 && location.getRow() < height && location.getCol() >=0 && location.getCol() < width) {
      mazeGrid[location.getRow()][location.getCol()] = content;
    }
  }

    /** This DemoMaze method will allow you to generate a simple maze
     * to test your code on as you develop it. Ultimately, you need
     * to accept maze files as command line inputs or standard input.
     * You will need to implement the DisplayableMaze interface before you
     * can run the initDemoMaze method.
     * * @author Tianah Gooden
     * * @version October 17th 2023
     */
    public void initDemoMaze() { //String fileName, 
        this.height = 10;
        this.width = 8;
        this.mazeGrid = new MazeContents[height][width];
        this.start = new MazeLocation(1,1);
        this.finish = new MazeLocation(8,6);

        this.mazeGrid[0][0] = MazeContents.WALL; this.mazeGrid[0][1] = MazeContents.WALL; this.mazeGrid[0][2] = MazeContents.WALL; this.mazeGrid[0][3] = MazeContents.WALL; this.mazeGrid[0][4] = MazeContents.WALL; this.mazeGrid[0][5] = MazeContents.WALL; this.mazeGrid[0][6] = MazeContents.WALL; this.mazeGrid[0][7] = MazeContents.WALL;
        this.mazeGrid[1][0] = MazeContents.WALL; this.mazeGrid[1][1] = MazeContents.OPEN; this.mazeGrid[1][2] = MazeContents.OPEN; this.mazeGrid[1][3] = MazeContents.OPEN; this.mazeGrid[1][4] = MazeContents.OPEN; this.mazeGrid[1][5] = MazeContents.OPEN; this.mazeGrid[1][6] = MazeContents.WALL; this.mazeGrid[1][7] = MazeContents.WALL;
        this.mazeGrid[2][0] = MazeContents.WALL; this.mazeGrid[2][1] = MazeContents.WALL; this.mazeGrid[2][2] = MazeContents.OPEN; this.mazeGrid[2][3] = MazeContents.WALL; this.mazeGrid[2][4] = MazeContents.WALL; this.mazeGrid[2][5] = MazeContents.OPEN; this.mazeGrid[2][6] = MazeContents.WALL; this.mazeGrid[2][7] = MazeContents.WALL;
        this.mazeGrid[3][0] = MazeContents.WALL; this.mazeGrid[3][1] = MazeContents.OPEN; this.mazeGrid[3][2] = MazeContents.WALL; this.mazeGrid[3][3] = MazeContents.OPEN; this.mazeGrid[3][4] = MazeContents.OPEN; this.mazeGrid[3][5] = MazeContents.OPEN; this.mazeGrid[3][6] = MazeContents.WALL; this.mazeGrid[3][7] = MazeContents.WALL;
        this.mazeGrid[4][0] = MazeContents.WALL; this.mazeGrid[4][1] = MazeContents.OPEN; this.mazeGrid[4][2] = MazeContents.OPEN; this.mazeGrid[4][3] = MazeContents.OPEN; this.mazeGrid[4][4] = MazeContents.WALL; this.mazeGrid[4][5] = MazeContents.WALL; this.mazeGrid[4][6] = MazeContents.OPEN; this.mazeGrid[4][7] = MazeContents.WALL;
        this.mazeGrid[5][0] = MazeContents.WALL; this.mazeGrid[5][1] = MazeContents.OPEN; this.mazeGrid[5][2] = MazeContents.WALL; this.mazeGrid[5][3] = MazeContents.OPEN; this.mazeGrid[5][4] = MazeContents.OPEN; this.mazeGrid[5][5] = MazeContents.WALL; this.mazeGrid[5][6] = MazeContents.WALL; this.mazeGrid[5][7] = MazeContents.WALL;
        this.mazeGrid[6][0] = MazeContents.WALL; this.mazeGrid[6][1] = MazeContents.OPEN; this.mazeGrid[6][2] = MazeContents.WALL; this.mazeGrid[6][3] = MazeContents.WALL; this.mazeGrid[6][4] = MazeContents.OPEN; this.mazeGrid[6][5] = MazeContents.OPEN; this.mazeGrid[6][6] = MazeContents.OPEN; this.mazeGrid[6][7] = MazeContents.WALL;
        this.mazeGrid[7][0] = MazeContents.WALL; this.mazeGrid[7][1] = MazeContents.OPEN; this.mazeGrid[7][2] = MazeContents.WALL; this.mazeGrid[7][3] = MazeContents.OPEN; this.mazeGrid[7][4] = MazeContents.OPEN; this.mazeGrid[7][5] = MazeContents.WALL; this.mazeGrid[7][6] = MazeContents.OPEN; this.mazeGrid[7][7] = MazeContents.WALL;
        this.mazeGrid[8][0] = MazeContents.WALL; this.mazeGrid[8][1] = MazeContents.OPEN; this.mazeGrid[8][2] = MazeContents.OPEN; this.mazeGrid[8][3] = MazeContents.WALL; this.mazeGrid[8][4] = MazeContents.OPEN; this.mazeGrid[8][5] = MazeContents.WALL; this.mazeGrid[8][6] = MazeContents.OPEN; this.mazeGrid[8][7] = MazeContents.WALL;
        this.mazeGrid[9][0] = MazeContents.WALL; this.mazeGrid[9][1] = MazeContents.WALL; this.mazeGrid[9][2] = MazeContents.WALL; this.mazeGrid[9][3] = MazeContents.WALL; this.mazeGrid[9][4] = MazeContents.WALL; this.mazeGrid[9][5] = MazeContents.WALL; this.mazeGrid[9][6] = MazeContents.WALL; this.mazeGrid[9][7] = MazeContents.WALL;
  }

  public boolean solve() {
    boolean solutionFound = solveFrom(start);

    if (solutionFound) {
      System.out.println("Solution found.");
    } else {
      System.out.println("Solution was not found.");
    }
    return solutionFound;
  }

  private boolean solveFrom(MazeLocation current) {
    try { 
      Thread.sleep(50);	
    } catch (InterruptedException e) {

    }

    if (isFinish(current)) { //if current location is finish
      markCurrentLocation(current, MazeContents.PATH);
      return true;
    }

    if (!checkExplorable(current.getRow(), current.getCol())) { //if current location isn't explorable
      return false;
    }

    markCurrentLocation(current, MazeContents.VISITED); //mark current as visited
    
    //recursively explore nearby squares from all four directions until reach finish or is unreachable
    boolean reachedPath =
      solveFrom(current.neighbor(MazeDirection.NORTH)) ||
      solveFrom(current.neighbor(MazeDirection.SOUTH)) ||
      solveFrom(current.neighbor(MazeDirection.EAST)) ||
      solveFrom(current.neighbor(MazeDirection.WEST));

    if (reachedPath) { //mark square as part of path or is a dead-end
      markCurrentLocation(current, MazeContents.PATH);
    } else {
      markCurrentLocation(current, MazeContents.DEAD_END);
    }

    return reachedPath;
  }

  public static void main(String[] args) {
    Maze maze = new Maze();
    maze.initDemoMaze();

    System.out.println("====Testing Maze Solver:====");
    
    System.out.println("Initial Maze (S = Start, F = Finish):");
    for (int i = 0; i < maze.getHeight(); i++) {
      for (int j = 0; j < maze.getWidth(); j++) {
        MazeLocation location = new MazeLocation(i,j);
        if (location.equals(maze.getStart())) {
          System.out.print("S ");
        } else if (location.equals(maze.getFinish())) {
          System.out.print("F ");
        } else {
          MazeContents content = maze.getContents(i, j);
          if (content == MazeContents.WALL) {
            System.out.print("# ");
          } else {
            System.out.print(". ");
          }
        }
      }
      System.out.println();
    }

    System.out.println("====Solving Maze:====");
    boolean solved = maze.solve();

    System.out.println("Final Maze:");
    for (int i = 0; i < maze.getHeight(); i++) {
      for (int j = 0; j < maze.getWidth(); j++) {
        MazeContents content = maze.getContents(i, j);
        if (content == MazeContents.WALL) {
          System.out.print("# ");
        } else if (content == MazeContents.PATH) {
          System.out.print("P ");
        } else if (content == MazeContents.VISITED) {
          System.out.print("V ");
        } else if (content == MazeContents.DEAD_END) {
          System.out.print("X ");
        } else {
          System.out.print(". ");
        }
      }
      System.out.println();
    }
    
    System.out.println("====Result:====");
    if (solved) {
      System.out.println("Maze is solved!");
    } else {
      System.out.println("No maze solution was found.");
    }
  }
}
