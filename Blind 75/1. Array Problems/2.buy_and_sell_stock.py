#https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        mres=0
        mget=0
        l=[]
        i=len(prices)-1
        while i>=0:
            if prices[i]>mget:
                mget=prices[i]
            l.append(mget)
            i=i-1
        i=0
        while i<len(l):
            d = l[len(l)-1-i]-prices[i]
            if d>mres:
                mres=d
            i=i+1
        return mres
