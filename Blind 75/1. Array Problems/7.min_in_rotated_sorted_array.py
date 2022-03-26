class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        l=0
        h=len(nums)-1
        while l<=h:
            mid=(l+h)//2
            if nums[mid]<nums[mid-1]:
                return nums[mid]
            if nums[mid]<nums[h]:
                h=mid-1
            else:
                l=mid+1
