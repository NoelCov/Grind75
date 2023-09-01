class Solution {

    // Time Complexity O(n * m)
    // Space Complexity O(n * m)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            // left to right
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            top++;

            // top to bottom
            for (int row = top; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            right--;

            // right to left
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    res.add(matrix[bottom][col]);
                }
            }
            bottom--;

            // bottom to top
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    res.add(matrix[row][left]);
                }
            }
            left++;
        }
        return res;
    }
}