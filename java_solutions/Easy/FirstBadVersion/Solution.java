public class Solution extends VersionControl {
    // Time Complexity O(log(n))
    // Space Complexity O(1)
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            // Calculating this way can end up in potentially integer overflow if both left
            // and right are very large.
            // In these cases using // left + (right - left) / 2 is preferred.
            // int mid = (right + left) / 2;

            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}