class Solution {
    // Time Complexity O(q * n * m) where q is the size of the queue.
    // Space Complexity O(n * m)
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        // Time Complexity O(n * m)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.remove();
                int currRow = curr[0], currCol = curr[1];
                int[][] directions = new int[][] { { currRow - 1, currCol }, { currRow + 1, currCol },
                        { currRow, currCol - 1 }, { currRow, currCol + 1 } };

                for (int[] dir : directions) {
                    int row = dir[0], col = dir[1];
                    // Not out of bounds, not a 0, not in visited
                    if (isValid(row, col, rows, cols) && mat[row][col] != 0 && !visited[row][col]) {
                        queue.add(new int[] { row, col });
                        visited[row][col] = true;
                        mat[row][col] = level;
                    }
                }
            }
        }
        return mat;
    }

    public boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}