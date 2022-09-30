def countFactors(n):
    r,i=1,2
    while i*i<=n:
        c=0
        while n%i==0:
            n=n//i
            c=c+1
        r=r*(c+1)
        i=i+1
    
    if n>=2:
        r=r*2
    return r

print(countFactors(72))
