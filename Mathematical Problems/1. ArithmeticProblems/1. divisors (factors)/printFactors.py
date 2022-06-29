def printFactors(n):
    i=1
    while i*i<=n:
        if n%i==0:
            print(i)
            if i!=n//i:
                print(n//i)
        i=i+1

printFactors(100)