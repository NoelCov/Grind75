class Solution {
    // Time Complexity O(n)
    // Space Complexity O(n)
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> prioQueue = new PriorityQueue<>((Point point1, Point point2) -> {
            if (point1.distance < point2.distance) {
                return -1;
            } else if (point1.distance > point2.distance) {
                return 1;
            } else {
                return 0;
            }
        });

        for(int[] point : points) {
            prioQueue.add(new Point(point));
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            res[i] = prioQueue.remove().point;
        }
        return res;
    }
}

class Point {
    public int[] point;
    public double distance;

    public Point(int[] point) {
        this.point = point;
        this.distance = calculateDistance();
    }

    private double calculateDistance() {
        return Math.sqrt(Math.pow((point[0] - 0), 2) + Math.pow((point[1] - 0), 2));
    }
}