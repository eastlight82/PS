#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>


int main()
{
	int* iarr; int i = 0;
	iarr = (int*)malloc(sizeof(int) * 10);
	for (i = 0; i < 10; i++)
	{
		int a;
		scanf("%d", &a);
		iarr[i] = a % 42;
	}
	int cnt = 10; int arb = 43;
	for (i = 0; i < 10; i++)
		for (int j = i + 1; j < 10; j++)
		{
			if (iarr[i] == iarr[j])
			{
				iarr[j] = arb;
				cnt--;
				arb++;
			}
		}
	printf("%d", cnt);
	free(iarr);
	
}