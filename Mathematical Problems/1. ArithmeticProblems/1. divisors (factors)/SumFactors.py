def sumFactors(n):
    r,i=1,2
    while i*i<=n:
        sum,term=1,1
        while n%i==0:
            n=n//i
            term=term*i
            sum=sum+term
        r=r*sum
        i=i+1
    if n>=2:
        r=r*(n+1)
    return r
    
print(sumFactors(19))