#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int N;

int gcd(long long int a, long long int b) {
    if (b == 0)
        return a;
    return gcd(b, a % b);
}

int main() {
    long long int x, y;
    scanf("%lld %lld", &x, &y);
    printf("%lld", x * y / gcd(x, y));

}