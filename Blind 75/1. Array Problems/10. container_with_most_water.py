class Solution:
    def maxArea(self, height: List[int]) -> int:
        if len(height)<=1:
            return 0
        ma=0
        i=0
        j=len(height)-1
        while i<j:
            l=min(height[i],height[j])
            a=l*(j-i)
            ma=max(ma,a)
            if height[i]<height[j]:
                i=i+1
            else:
                j=j-1
        return ma
            
        
