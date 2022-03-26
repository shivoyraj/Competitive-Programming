import math

LPF=[]
def leastPrimeFactor(n) :
     

    least_prime = [0] * (n + 1) 
    for i in range(2, n + 1) :
         
        if (least_prime[i] == 0) :
            LPF.append(i)
 
            for j in range(i * i, n + 1, i) :
                if (least_prime[j] == 0) :
                    least_prime[j] = i
         
        else:
            LPF.append(least_prime[i])

def getFactorization(x):
    while x!=1:
        print(LPF[x],end=" ")
        x=x//LPF[x]
    print()
arr=[6,8,10,30]

m=max(arr)
LPF.append(0)
LPF.append(1)
leastPrimeFactor(m)
#print(LPF)

for i in arr:
    getFactorization(i)

