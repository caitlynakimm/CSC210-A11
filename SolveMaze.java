import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Provides methods for reading maze files and converting them to Maze objects
 */
class SolveMaze {

  /**
   * Reads maze from text file and returns lines as an ArrayList
   * Each line in file represents row in maze
   * @param fname name of file to read
   * @return ArrayList of strings, each representing a row of maze
   * @throws FileNotFoundException if file can't be found
   */
  public static ArrayList<String> readMaze(String fname){
    ArrayList<String> lines = new ArrayList<>();
    try {
      Scanner file = new Scanner(new File(fname));
      while (file.hasNextLine()) {
        lines.add(file.nextLine());
      }
      file.close();
      return lines;
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);  
    }
    return lines;
  }
  
  /**
   * Converts ArrayList of strings (represents maze) into Maze object
   * @param lines ArrayList of strings representing maze
   * @return Maze object created from input lines
   */
  public static Maze convertToMaze(ArrayList<String> lines){
    int height = lines.size();
    int width = 0;

    for (String line: lines) { //finding maximum width to find width of maze
      if (line.length() > width) {
        width = line.length();
      }
    }

    MazeContents[][] grid = new MazeContents[height][width];
    MazeLocation start = null;
    MazeLocation finish = null;

    for (int row = 0; row < height; row++) {
      String currentLine = lines.get(row);
      for (int col = 0; col < width; col++) {
        char cell;
        if (col < currentLine.length()) {
          cell = currentLine.charAt(col);
        } else {
            cell = ' '; //missing cells will be treated as open spaces
        }

        switch (cell) {
          case '#': 
            grid[row][col] = MazeContents.WALL; break;
          case ' ':
          case '.': 
            grid[row][col] = MazeContents.OPEN; break;
          case 'S': 
            grid[row][col] = MazeContents.OPEN;
            start = new MazeLocation(row, col);
            break;
          case 'F': 
            grid[row][col] = MazeContents.OPEN;
            finish = new MazeLocation(row, col);
            break;
        }
      }
    }
    return new Maze(grid, start, finish);
  }

  /**
   * Main method for running recursive maze solver
   * Expects maze's file name to be a command-lind argument
   * @param args command-line arguments (first argument should be file name)
   */
  public static void main(String[] args) {
    if(args.length <= 0){
      System.err.println("Please provide the name of the maze file.");
      System.exit(-1);
    }
    ArrayList<String> lines = readMaze(args[0]);
    Maze maze = convertToMaze(lines);
    MazeViewer viewer = new MazeViewer(maze);
    maze.solve();
    
    // Maze maze = new Maze();
    // MazeViewer viewer = new MazeViewer(maze);
  }
}
