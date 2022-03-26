import math
def print3DivNums(n):
    sr=(int)(math.sqrt(n))
    isPrime=[True for i in range(sr+1)]
    for i in range(2,sr+1):
        if isPrime[i]:
            print(i*i)
        for j in range(i*i,sr+1,i):
            isPrime[j]=False


print3DivNums(500)