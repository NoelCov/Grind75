# Time Complexity O(n)
# Space Complexity O(n)    
def twoSum(self, nums, target):
    if len(nums) == 2:
        return [0, 1]

    map = {}
    for idx, num in enumerate(nums):
        num_needed = target - num

        if num_needed in map:
            return [idx, map.get(num_needed)]
        
        map[num] = idx
        