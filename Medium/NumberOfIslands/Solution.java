class Solution {
    // Space Complexity O(n * m)
    // Time Complexity O((n * m * x) where x is the number of '1' in the grid.
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, numOfIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    dfs(rows, cols, i, j, grid);
                }
            }
        }
        return numOfIslands;
    }

    public void dfs(int rows, int cols, int row, int col, char[][] grid) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(rows, cols, row + 1, col, grid);
        dfs(rows, cols, row - 1, col, grid);
        dfs(rows, cols, row, col + 1, grid);
        dfs(rows, cols, row, col - 1, grid);
    }
}