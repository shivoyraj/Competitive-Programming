def modInv(a, m):
    m0 = m
    y = 0
    x = 1
    if (m == 1):
        return 0
    while (a > 1):
        q = a // m
        t = m
        m = a % m
        a = t
        t = y
        y = x - q * y
        x = t
    if (x < 0):
        x = x + m0
    return x



def getX(a,m,n):
    prod,i=1,0
    while i<n:
        prod=prod*m[i]
        i=i+1
    res=0
    i=0
    while i<n:
        pi=prod//m[i]
        inv=modInv(pi,m[i])
        term=(pi*inv*a[i])%prod
        res=(res+term)%prod
        i=i+1
    return res
    
a=[2,4,1]
m=[3,5,2]
n=3

print(getX(a,m,n))


