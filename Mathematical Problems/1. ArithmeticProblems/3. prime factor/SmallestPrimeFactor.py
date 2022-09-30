
def leastPrimeFactor(n) :
          
    for i in range(2, n + 1) :    
        if (least_prime[i] == 0) :
            least_prime[i]=i
            print("smallest prime factor of",i," ",i)
            for j in range(i * i, n + 1, i) :
                if (least_prime[j] == 0) :
                    least_prime[j] = i
         
        else:
            print("smallest prime factor of",i," ",least_prime[i])
         
 
n = 10
least_prime = [0] * (n + 1)
leastPrimeFactor(n)
for i in least_prime:
    if i!=0:
        print(i,end=" ")