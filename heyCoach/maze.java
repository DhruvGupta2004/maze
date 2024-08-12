package heyCoach;

public class maze {

    // this to keep in mind while solving the question
    // 1. the place where the robot is moving mark it
    // 2. after each move we have to check weather it is exit or not
    // 3. backtrack is the right way as after cover the path we have to come back if we not found the answer/ exit
    // 4. we use dfs here
    // 5. 1 is also check at each step in maze as we cants move on 1.

    // Function to generate a random maze



    public static void main(String[] args) {
        // Example usage
        int[][] mazeGrid = {
                {0, 0, 0, 1},
                {1, 0, 0, 0},
                {1, 0, 1, 0},
                {1, 0, 0, 0}
        };

        int startRow = 0;
        int startCol = 0;
        int endRow = 2;
        int endCol = 3;

        // we make this to check weather we have visited this place previously or not.
        boolean pathFound = explorePath(mazeGrid, startRow, startCol, endRow, endCol);
        System.out.println("Path exists: " + pathFound);
    }

    public static boolean explorePath(int[][] maze, int startRow, int startCol, int endRow, int endCol) {
        // initialize the visited array
        boolean[][] hasBeenVisited = new boolean[maze.length][maze[0].length];

        // start the pathfinding process
        return searchPath(maze, startRow, startCol, endRow, endCol, hasBeenVisited);
    }

    private static boolean searchPath(int[][] maze, int currentRow, int currentCol, int endRow, int endCol, boolean[][] hasBeenVisited) {
        // if we have reached the end
        if (currentRow == endRow && currentCol == endCol) {
            return true;
        }

        // check if the current position is out of bounds or already visited or blocked
        if (!isMoveValid(maze, hasBeenVisited, currentRow, currentCol)) {
            return false;
        }

        // mark the current position as visited
        hasBeenVisited[currentRow][currentCol] = true;

        // explore in all four directions
        //Up
        if (searchPath(maze, currentRow - 1, currentCol, endRow, endCol, hasBeenVisited)) {
            return true;
        }
        //Down
        if (searchPath(maze, currentRow + 1, currentCol, endRow, endCol, hasBeenVisited)) {
            return true;
        }
        //Left
        if (searchPath(maze, currentRow, currentCol - 1, endRow, endCol, hasBeenVisited)) {
            return true;
        }
        //Right
        if (searchPath(maze, currentRow, currentCol + 1, endRow, endCol, hasBeenVisited)) {
            return true;
        }

        // Unmark the current position
        hasBeenVisited[currentRow][currentCol] = false;
        return false; // in case of No path found
    }

    private static boolean isMoveValid(int[][] maze, boolean[][] hasBeenVisited, int row, int col) {
        int numberOfRows = maze.length;
        int numberOfCols = maze[0].length;
        return row >= 0 && row < numberOfRows && col >= 0 && col < numberOfCols && maze[row][col] == 0 && !hasBeenVisited[row][col];
    }

}
