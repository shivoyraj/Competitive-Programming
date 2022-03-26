def phi(n):
    res,p=n,2
    while p*p<=n:
        if res%p==0:
            while n%p==0:
                n=n//p
            res=res-res//p
        p=p+1
    if n>1:
        res=res-res//n
    return res
    
n=100
for i in range(1,n):
    print(phi(i))
