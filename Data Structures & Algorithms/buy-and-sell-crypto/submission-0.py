class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_cp=float("inf")
        max_profit=0

        for sp in prices:
            profit=sp-min_cp
            max_profit=max(profit,max_profit)
            min_cp=min(min_cp,sp)
        return max_profit
