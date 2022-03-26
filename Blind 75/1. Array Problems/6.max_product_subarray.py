class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        np, pp = 1, 1
        mp = nums[0]
        for i in nums:
            l = (i, i * np, i * pp)
            np = min(l)
            pp = max(l)
            mp = max(mp, pp)
        return mp
                
