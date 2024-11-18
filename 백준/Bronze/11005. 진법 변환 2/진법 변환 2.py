import sys
#31(n) 3(b)진법 1(n%b), '10'(n//b)-> 1, '3'-> 0, 1 => 1011
#A:10(65) Z:35(90) +55

n,b=map(int,sys.stdin.readline().rstrip().split())

sum=[]

while n>=b:
    if n%b<10:
        sum.insert(0,n%b)
    else:
        sum.insert(0,chr(n%b+55))
    n=n//b

if n%b<10:
    sum.insert(0,n%b)
else:
    sum.insert(0,chr(n%b+55))

rst=''

for i in sum:
    rst+=str(i)

print(rst)