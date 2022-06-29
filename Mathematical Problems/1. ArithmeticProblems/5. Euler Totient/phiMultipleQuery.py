def mphi(n):
    phi=[i for i in range(n+1)]
    p=2
    while p<=n:
        if phi[p]==p:
            phi[p]=p-1
            i=2*p
            while i<=n:
                phi[i]=(phi[i]//p)*(p-1)
                i=i+p
        p=p+1
    return phi
    
l=mphi(30)
for i in range(1,len(l)):
    print(l[i])
