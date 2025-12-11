import java.util.*;

public class ShortestPath {
    private static class Node implements Comparable<Node> {
        MazeLocation location;
        int distance;

        public Node(MazeLocation location, int distance) {
            this.location = location;
            this.distance = distance;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

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
        distance[start.getRow()][start.getCol()] = 0; //shortest distance when at start location is 0

        //implement priority queue (min-heap)
        PriorityQueue<Node> shortestDistances = new PriorityQueue<>();
        shortestDistances.add(new Node(start, 0));

        //store both location and distance in priority queue
        
    }
}
