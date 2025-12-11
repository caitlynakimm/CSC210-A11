import java.util.*;

/**
 * Implements Dijkstra's shortest path algorithm to find shortest path from start to finish in a maze
 * Marks shortest path and displays result
 */
public class ShortestPath {

    /**
     * Helper class representing a node in priority queue used in Dijkstra's algorithm
     * Stores location in maze and current shortest distance to that location
     */
    private static class QueueNode implements Comparable<QueueNode> {
        MazeLocation location; //cell location
        int distance; //current shortest distance to current cell

        /**
         * Creates a QueueNode with given location and distance
         * @param location maze location
         * @param distance current shortest distance to location
         */
        QueueNode(MazeLocation location, int distance) {
            this.location = location;
            this.distance = distance;
        }

        /**
         * Compares this QueueNode with another one based on distance
         * @param other other QueueNode to compare to
         * @return negative integer, zero, or positive integer if this node's distance is less than, equal to, or greater than other's
         */
        public int compareTo(QueueNode other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    /**
     * Solves maze using Dijkstra's shortest path algorithm
     * Marks visited cells (light green), dead ends (red), and final shortest path (green)
     * @param maze maze to solve
     */
    public static void solve(Maze maze) {
        int height = maze.getHeight();
        int width = maze.getWidth();

        //initialied 2D arrays to store temporary info for each node
        int[][] distance = new int[height][width]; //stores shortest distance from start to current location/cell  
        MazeLocation[][] predecessor = new MazeLocation[height][width]; //stores previous location that leads to current location
        boolean[][] visited = new boolean[height][width]; //stores T/F for if current location was visited

        for (int i = 0; i < height; i++) { //i is row index (from 0 to height-1) and j is column index (from 0 to width-1)
            for (int j = 0; j < width; j++) {
                distance[i][j] = (int) Double.POSITIVE_INFINITY;
                predecessor[i][j] = null;
                visited[i][j] = false;
            }
        }

        //set starting point
        MazeLocation start = maze.getStart();
        MazeLocation finish = maze.getFinish();
        distance[start.getRow()][start.getCol()] = 0; //shortest distance when at start location is 0

        //implement priority queue (min-heap)
        PriorityQueue<QueueNode> shortestDistances = new PriorityQueue<>();
        shortestDistances.add(new QueueNode(start, 0));

        //Dijkstra's algorithm
        //store both location and distance in priority queue
        while (!shortestDistances.isEmpty()) {
            QueueNode current = shortestDistances.poll(); //get node with shortest distance
            int currentRow = current.location.getRow();
            int currentCol = current.location.getCol();

            if (visited[currentRow][currentCol]) { //if node with shortest distance was already visited then skip it
                continue;
            }

            //mark cell as VISITED (light green) with the animation
            if (!current.location.equals(start) && !current.location.equals(finish)) {
                maze.markCurrentLocation(current.location, MazeContents.VISITED);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {

                }
            }

            visited[currentRow][currentCol] = true; //mark node as visited

            //check all 4 directions from current
            MazeDirection[] directions = {
                MazeDirection.NORTH,
                MazeDirection.SOUTH,
                MazeDirection.EAST,
                MazeDirection.WEST
            };

            boolean hasUnvisitedNeighbors = false; //flag for if current cell has any unvisited explorable neighbors

            for (MazeDirection dir : directions) {
                MazeLocation neighbor = current.location.neighbor(dir);

                int neighborRow = neighbor.getRow();
                int neighborCol = neighbor.getCol();

                //check if neighbor is within bounds and explorable
                if (neighborRow >= 0 && neighborRow < height && 
                    neighborCol >= 0 && neighborCol < width && 
                    
                    maze.checkExplorable(neighborRow, neighborCol)) {

                    int newDistance = distance[currentRow][currentCol] + 1;

                    if (newDistance < distance[neighborRow][neighborCol]) { //if path to neighbor that was discovered is shorter
                        distance[neighborRow][neighborCol] = newDistance;
                        predecessor[neighborRow][neighborCol] = current.location;
                        shortestDistances.add(new QueueNode(neighbor, newDistance)); //add neighbor to priority queue with new distance
                        hasUnvisitedNeighbors = true;
                    }
                }
            }

            //mark dead ends (red)
            if (!hasUnvisitedNeighbors && !current.location.equals(start) && !current.location.equals(finish)) {
                maze.markCurrentLocation(current.location, MazeContents.DEAD_END);
            }

        }

        reconstructAndMarkPath(maze, predecessor, start, finish); //reconstruct final path and mark it (in green), if it exists
    }

    /**
     * Reconstructs shortest path from finish to start using predecessor array and marks path (green) in maze
     * @param maze maze to mark path in
     * @param predecessor 2D array of MazeLocations storing previous cell on shortest path
     * @param start starting location
     * @param finish finish location
     */
    private static void reconstructAndMarkPath(Maze maze, MazeLocation[][] predecessor, MazeLocation start, MazeLocation finish) {
        //see if path exists to finish
        int finishRow = finish.getRow();
        int finishCol = finish.getCol();

        if (predecessor[finishRow][finishCol] == null) {
            System.out.println("There is no path from start to finish for this maze!");
            return;
        }

        System.out.println("Found shortest path! Now marking it...");
        
        //trace back from finish location to start location using predecessor array
        MazeLocation current = finish;

        while (current != null && !current.equals(start)) {
            //check if current is marked as DEAD_END, if so, change it to PATH (green)
            if (maze.getContents(current.getRow(), current.getCol()) == MazeContents.DEAD_END) {
                maze.markCurrentLocation(current, MazeContents.PATH);
            }
            current = predecessor[current.getRow()][current.getCol()];
        }

        current = finish;

        while (current != null && !current.equals(start)) {
            maze.markCurrentLocation(current, MazeContents.PATH); //mark current cell as path (green)

            //delay for animation effect
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }

            current = predecessor[current.getRow()][current.getCol()];
        }

        maze.markCurrentLocation(start, MazeContents.PATH); //mark start cell as path

        System.out.println("Path marked!");
    }

    /**
     * Main method for running shortest path algorithm
     * Accepts maze file as command-line argument or uses demo maze if no file provided
     * @param args command-line arguments (first argument can be maze file name)
     */
    public static void main(String[] args) {
        Maze maze;

        if (args.length > 0) { //use SolveMaze class methods
            ArrayList<String> lines = SolveMaze.readMaze(args[0]);
            maze = SolveMaze.convertToMaze(lines);
        } else { //create demo maze using dimensions from Maze class
            maze = new Maze(new MazeContents[10][8], new MazeLocation(1,1), new MazeLocation(8, 6));
            maze.initDemoMaze();
        }

        MazeViewer viewer = new MazeViewer(maze);

        solve(maze); //run dijkstra's algorithm
    }
}
