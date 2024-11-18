#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>


int main()
{
	int* iarr; int i = 0;
	iarr = (int*)malloc(sizeof(int) * 31);
	for (i = 0; i < 31; i++)
	{
		iarr[i] = i;
	}
	for (i = 0; i < 28; i++)
	{
		int a;
		scanf("%d", &a);
		iarr[a] = 0;
	}
	for (i = 0; i < 31; i++)
	{
		if (iarr[i] != 0)
			printf("%d\n", iarr[i]);
	}
	free(iarr);
	
}