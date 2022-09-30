def printInverse(n,m):
    inv=[0]*(n+1)
    inv[0]=1
    inv[1]=1
    print(inv[1])
    i=2
    while i<=n:
        inv[i]=m-((m//i)*inv[m%i])%m
        print(inv[i])
        i=i+1
        
n,m=3,11
printInverse(n,m)
