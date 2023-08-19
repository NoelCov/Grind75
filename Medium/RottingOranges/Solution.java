class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int goodOrangesCounter = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    goodOrangesCounter++;
                }
            }
        }

        if (goodOrangesCounter == 0) {
            return 0;
        }
        // I do not need to start from each orange like I thought I did. I have to do
        // every orange at the same time. All I need to do is remove this piece of code
        // and add all the bad oranges to the queue and treat them all as the first
        // level.
        int[][] visited = new int[rows][cols];
        int res = bfs(rows, cols, grid, queue, visited);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return res;
    }

    // Return level!
    public int bfs(int rows, int cols, int[][] grid, Queue<int[]> queue, int[][] visited) {
        int minsElapsed = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.remove();
                int row = curr[0];
                int col = curr[1];
                grid[row][col] = 2;

                int[][] adjacentCells = new int[][] { { row + 1, col }, { row - 1, col }, { row, col + 1 },
                        { row, col - 1 } };
                for (int[] adjacentCell : adjacentCells) {
                    int currRow = adjacentCell[0], currCol = adjacentCell[1];
                    if (isValid(rows, cols, currRow, currCol) && grid[currRow][currCol] == 1
                            && visited[currRow][currCol] == 0) {
                        queue.add(adjacentCell);
                        visited[currRow][currCol] = 1;
                    }
                }
                ;
            }
            minsElapsed++;
        }
        return minsElapsed;
    }

    public boolean isValid(int rows, int cols, int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return true;
        }
        return false;
    }
}