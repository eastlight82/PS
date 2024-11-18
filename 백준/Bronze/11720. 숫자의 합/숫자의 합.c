#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>


int main()
{
	int N; char str[100];
	scanf("%d", &N);
	scanf("%s", str);
	int sum = 0;
	for (int i = 0; i < N; i++)
	{
		if (str[i] == '1' || str[i] == '0')
			sum = sum + (str[i] % 10 - 8);
		else
			sum = sum + (str[i] % 10 + 2);
	}
	printf("%d", sum);
	
}