import sys
#n=1234 9진수 4*9^0+3*9^1+2*9^2+1*9^3
al = {'A': 10,'B': 11,'C': 12,'D':13,'E':14,'F':15,
'G':16,'H':17,'I':18,'J':19,'K':20,'L':21,'M':22,
'N':23,'O':24,'P':25,'Q':26,'R':27,'S':28,'T':29,'U':30,'V':31,'W':32,'X':33,
'Y':34,'Z':35}

n,b=sys.stdin.readline().rstrip().split()

b=int(b)

sum=0

for i in range(len(n)):
    # print(n[i-1])
    if n[-i-1] in al:
        sum+=int(al[n[-i-1]])*(b**i)
    else:
        sum+=int(n[-i-1])*(b**i)
    
    
print(sum)