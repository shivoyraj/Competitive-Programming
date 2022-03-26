class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        s=nums[0]
        ms=nums[0]
        for i in range(1,len(nums)):
            s=s+nums[i]
            s= max(s,nums[i])
            ms= max(s,ms)
        return ms
