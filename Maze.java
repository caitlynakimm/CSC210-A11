/* This class should implement the DisplayableMaze interface */
/**
 * Represents maze that can be solved using path-finding algorithms
 * Implements DisplayableMaze interface for visualization
 */
public class Maze implements DisplayableMaze {
  private MazeContents[][] mazeGrid; //2D array representing grid of maze cells
  private int width; //width of maze in cells
  private int height; //height of maze in cells
  private MazeLocation start; //starting location in maze
  private MazeLocation finish; //finish location in maze
  
  /**
   * Creates maze with given grid dimensions and start/finish locations
   * @param grid 2D array of MazeContents representing maze layout
   * @param start starting location in maze
   * @param finish finish location (goal) in maze
   */
  public Maze(MazeContents[][] grid, MazeLocation start, MazeLocation finish) {
    this.mazeGrid = grid;
    this.height = grid.length;
    this.width = grid[0].length; //set the width to be the length of the grid's first line
    this.start = start;
    this.finish = finish;
  }

  /**
   * Returns height of maze in cells
   * @return height of maze
   */
  public int getHeight() {
    return height;
  }

  /**
   * Returns width of maze in cells
   * @return width of maze
   */
  public int getWidth() {
    return width;
  }

  /**
   * Returns contents of cell at given coordinates
   * @param i row index (starts at 0)
   * @param j column index (starts at 0)
   * @return MazeContents at (i, j) or null if coordinates are out of bounds
   */
  public MazeContents getContents(int i, int j) {
    if (i >= 0 && i < height && j >= 0 && j < width) {
      return mazeGrid[i][j];
    } else {
      return null;
    }
  }

  /**
   * Checks if cell at given coordinates is explorable
   * Cell is explorable if it's within bounds and not a wall or visited\
   * @param i row index
   * @param j column index
   * @return true if cell is explorable, else false
   */
  public Boolean checkExplorable(int i, int j) {
    if (i < 0 || i >= height || j < 0 || j >= width) { //check if location is within bounds
      return false;
    }

    MazeContents contents = mazeGrid[i][j];
    return contents.isExplorable; //check if already visited location or reached a wall (field is from MazeContents class)
  }

  /**
   * Returns starting location of maze
   * @return MazeLocation of start
   */
  public MazeLocation getStart() {
    return start;
  }

  /**
   * Returns finish location of maze
   * @return MazeLocation of finish
   */
  public MazeLocation getFinish() {
    return finish;
  }

  /**
   * Checks if given location is finish location
   * @param location location to check
   * @return true if location is finish, else false
   */
  private boolean isFinish(MazeLocation location) {
    return location.equals(finish);
  }

  /**
   * Marks given location in maze with given content
   * @param location location to mark
   * @param content MazeContents to place at that location
   */
  public void markCurrentLocation(MazeLocation location, MazeContents content) {
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

  /**
   * Solves maze using recursive backtracking algorithm
   * @return true if solution found, else false
   */
  public boolean solve() {
    boolean solutionFound = solveFrom(start);

    if (solutionFound) {
      System.out.println("Solution found.");
    } else {
      System.out.println("Solution was not found.");
    }
    return solutionFound;
  }

  /**
   * Recursive helper method for solving maze from current location
   * @param current current location in maze
   * @return true if path to finish found from this location, else false
   */
  private boolean solveFrom(MazeLocation current) {
    try { 
      Thread.sleep(10);	
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
}
