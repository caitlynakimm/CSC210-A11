# A11 Recursive Maze Explorer

## README Basics 
Your README should include the following information. Each student needs to submit all of this information themselves, even when pair programming. 

Programming Partner Name:
- N/A

Other Collaborators (and kudos to helpful members of the class):
- N/A

Any references used besides JavaDoc and course materials:
- https://stackoverflow.com/questions/58990344/check-if-im-going-out-of-bounds-in-a-maze
- https://www.geeksforgeeks.org/dsa/rat-in-a-maze-problem-when-movement-in-all-possible-directions-is-allowed/
- https://www.geeksforgeeks.org/java/java-program-for-rat-in-a-maze-backtracking-2/
- https://stackoverflow.com/questions/5343689/java-reading-a-file-into-an-arraylist
- https://www.baeldung.com/java-infinity
- https://www.baeldung.com/java-solve-maze

Describe any use of AI on this assignment and what it taught you:
- I used AI to help me implement a priority queue to store the shortest distances to a given cell/location in the maze and to help me implmement Dijkstra's algorithm using my 2D array approach. It taught me that elements (nodes) in the queue should store both the location and shortest distance of the cells and in the algorithm, I should be checking if the current location has any unvisited explorable neighbors and update their shortest distances if the new ones I calculate are shorter than the current distances stored. Further, I learned the algorithm focuses on exploring all the cells and then backtracking from the finish to start to find the shortest path of a maze. Also, I used AI to help me understand how to color code the VISITED, DEAD_END, and PATH cells. I learned that towards the beginning of the algorithm, as I traverse through the cells in the queue, I should mark the cells as visited. Next, mark cells that have no unvisited neighbors as dead ends. Finally, once I am backtracking, mark the cells I traverse as path (even if they were originally marked as dead ends), and also mark the start as path.

## Reflection

Do you have any remaining questions about this assignment?
- 

In phase four, what method did you choose to store the extra data?  Why did you make this choice?
- 

Reflection on your experience with this assignment:
- 
