import sys

# 2n-1 2 3 5 9 17 33
# 1*2-0 2*2-1 4*2-3 8*2-7

n=int(sys.stdin.readline().rstrip())

print((2**(n)*2-2**(n)+1)**2)