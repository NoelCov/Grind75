# Time Complexity O(log n)
# Space Complexity O(1)
def search(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: int
    """
    left, right = 0, len(nums) - 1

    while left <= right:
        mid = right + left // 2

        curr = nums[mid]
        if curr == target:
            return mid
        elif curr > target:
            right = mid - 1
        else:
            left = mid + 1
    return -1
    
# Recursive approach
def search(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: int
    """
    def binarySearch(left, right, nums, target):
        if right < left:
            return -1

        mid = right + left // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] > target:
            return binarySearch(left, mid - 1, nums, target)
        else:
            return binarySearch(mid + 1, right, nums, target)
    
    return binarySearch(0, len(nums) - 1, nums, target)
