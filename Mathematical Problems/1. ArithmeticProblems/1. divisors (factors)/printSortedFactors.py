def printFactors(n):
    i=1
    while i*i<=n:
        if n%i==0:
            print(i)
        i=i+1
    while i>0:
        if n%i==0:
            print(n//i)
        i=i-1

printFactors(100)