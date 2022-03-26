import math
def isPerfectSquare(n):
    if n>=0:
        sr=(int)(math.sqrt(n))
        return ((sr*sr)==n)
    return False

n=100
for i in range(n+1):
    if isPerfectSquare(i):
        print(i)

# isPerfectSquare(11)