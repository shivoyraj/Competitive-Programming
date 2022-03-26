prime =[]
def seive(n):
    isprime=[True for i in range(n+1)]
    i=2
    while i<=n:
        if isprime[i]:
            prime.append(i)
            j=i*i
            while j<=n:
                isprime[j]=False
                j=j+i
        i=i+1

seive(100)
print(prime)
print("count ", len(prime))