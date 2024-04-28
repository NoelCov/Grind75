class Solution {
    public int search(int[] nums, int target) {
        // Check if array is rotated by checking if arr[0] < arr[arr.lenght - 1]. If this is true array is NOT rotated.
        boolean rotated = true;
        if (nums[0] < nums[nums.length - 1]) {
            rotated = false;
        }

        int pivot = 0;
        int left = 0, right = nums.length - 1;
        // If array rotated find the pivot.
        while(left < right && rotated) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                pivot = mid + 1;
                break;
            } else if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
    
        left = 0;
        right = nums.length - 1;
        if (rotated) {
            if (target >= nums[pivot] && target <= nums[right]) {
                left = pivot;
            } else {
                right = pivot - 1;
            }
        } 

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}