class Solution {
    // Time Complexity O(m * n)
    // Space Complexity O(1)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length, cols = image[0].length;
        int originalColor = image[sr][sc];
        dfs(image, sr, sc, rows, cols, color, originalColor);

        return image;
    }

    public void dfs(int[][] image, int row, int col, int rows, int cols, int color, int originalColor) {
        // What are base cases? If we are out of bounds, if the curren pixel's color is different.
        if (row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != originalColor || image[row][col] == color) {
            return;
        }

        // Change color
        image[row][col] = color;

        // Perform change in neighbors
        // TOP, BOTTOM, LEFT, RIGHT.
        int[][] directions = { {row - 1, col}, {row + 1, col}, {row, col - 1}, {row, col + 1} };
        for(int[] direction : directions) {
            dfs(image, direction[0], direction[1], rows, cols, color, originalColor);
        }
    }
}