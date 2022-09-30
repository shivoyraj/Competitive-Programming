import math
p1=[]
p2=[]

def seive(n):
    isprime=[True for i in range(n+1)]
    i=2
    while i<=n:
        if isprime[i]:
            p1.append(i)
            j=i*i
            while j<=n:
                isprime[j]=False
                j=j+i
        i=i+1



def segmentedSeive(l,h):
    seive(int(math.sqrt(h)))
    if l<2:
        l=2
    m=h-l+1;
    prime=[True for i in range(m)]
    n=len(p1)
    for i in range(n):
        k=p1[i]
        sm=(l//k)*k
        if sm<l:
            sm=sm+k
        if sm==k:
            sm=sm+k
        j=sm
        while j<=h:
            prime[j-l]=False
            j=j+k

    for i in range(m):
        if prime[i]==True:
            p2.append(i+l)


q=int(input())


for i in range(q):
    l,r=map(int,input().split())
    segmentedSeive(l,r)
    print(p2)
    p1.clear()
    p2.clear()


