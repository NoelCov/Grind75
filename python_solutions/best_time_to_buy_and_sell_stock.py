# Time Complexity O(n)
# Space Complexity O(1)
def maxProfit(self, prices):
    """
    :type prices: List[int]
    :rtype: int
    """

    maxProf, curr = 0, prices[0]
    for i in range(1, len(prices)):
        stock = prices[i]
        profit = stock - curr
        if profit < 1:
            curr = stock
        else:
            maxProf = max(profit, maxProf)

    return maxProf
