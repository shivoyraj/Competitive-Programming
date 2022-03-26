#https://leetcode.com/problems/product-of-array-except-self/

import math
class Solution:    
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        l=[]
        if 0 in nums:
            c=0
            for i in nums:
                if i==0:
                    c=c+1
            if c>=2:
                return [0 for i in range(len(nums))]
            elif c==1:
                prod=1
                for j in nums:
                    if j!=0:
                        prod=prod*j
                l=[0 for i in range(len(nums))]
                l[nums.index(0)]=prod
                return l
            return nums
        else:
            prod=math.prod(nums)
            l=[prod//i for i in nums]
            return l
        
