
def leastPrimeFactor(n) :
    
    for i in range(2, n + 1) :    
        if (least_prime[i] == 0) :
            least_prime[i]=i
            for j in range(i * i, n + 1, i) :
                if (least_prime[j] == 0) :
                    least_prime[j] = i

                
def factorSum(n):
    res=1
    prev=least_prime[n]
    term=prev
    sum=prev+1
    n=n//prev
    while n>1:
        if least_prime[n]==prev:
            term=term*prev
            sum=sum+term
        else:
            prev=least_prime[n]
            res=res*sum
            term=prev
            sum=1+term
        n=n//prev
    res=res*sum
    return res


L=[72,7,12]
least_prime=[0] * (max(L) + 1)
leastPrimeFactor(max(L))
for i in L:
    print(factorSum(i))

