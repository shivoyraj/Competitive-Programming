class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res=[]
        nums.sort()
        for i in range(len(nums)-2):
            if nums[i]>0:
                break
            x=i+1
            y=len(nums)-1
            sum = -nums[i]
            while x<y:
                if nums[x]+nums[y]==sum:
                    temp = [nums[i],nums[x],nums[y]]
                    if temp not in res:
                        res.append(temp)
                    x=x+1
                    y=y-1
                elif nums[x]+nums[y]<sum:
                    while x<len(nums)-1 and nums[x]==nums[x+1]:
                        x=x+1
                    x=x+1
                elif nums[x]+nums[y]>sum:
                    while y>0 and nums[y]==nums[y-1]:
                        y=y-1
                    y=y-1
                
        return res
