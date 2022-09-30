def gcd(a,b):
    while b!=0:
        a=a%b
        a,b=b,a
    return a
    
a,b=25,100
print(gcd(a,b))
