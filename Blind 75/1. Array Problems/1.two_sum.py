#https://leetcode.com/problems/two-sum/

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map={}
        for i in range(len(nums)):
            d= target-nums[i]
            if d in map:
                return [map[d],i]
            else:
                map[nums[i]]=i
                    
