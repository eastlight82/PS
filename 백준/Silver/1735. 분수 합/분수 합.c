#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int gcd(long long int a, long long int b) 
{
    if (b == 0)
        return a;
    return gcd(b, a % b);
}

int main() //두 분모의 최소공배수 구하고, 각 분자마다 최소공배수/분모
//곱하기
{
    long long int son[2], mom[2];
    scanf("%lld %lld", &son[0], &mom[0]);//1번째 분자, 분모
    scanf("%lld %lld", &son[1], &mom[1]);//2번째 분자, 분모
    long long int realmom = mom[0]*mom[1]/gcd(mom[0], mom[1]);//결과값 분모
    long long int realson = (son[0] * realmom / mom[0]) + (son[1] * realmom / mom[1]);
    int a = gcd(realson, realmom);
    printf("%lld %lld",realson/a, realmom/a);

}
