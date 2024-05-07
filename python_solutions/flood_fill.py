# Time Complexity O(n * m)
# Space Complexity O(1)
class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        def helper(image, sr, sc, color, startColor):
            if sr < 0 or sr >= len(image) or sc < 0 or sc >= len(image[0]) or image[sr][sc] == color or image[sr][sc] != startColor:
                return

            image[sr][sc] = color

            helper(image, sr + 1, sc, color, startColor) # top
            helper(image, sr - 1, sc, color, startColor) # bottom
            helper(image, sr, sc - 1, color, startColor) # left
            helper(image, sr, sc + 1, color, startColor) # right

        helper(image, sr, sc, color, image[sr][sc])
        return image