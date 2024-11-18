#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int main()
{
	int iarr[6];
	int chess[6] = { 1,1,2,2,2,8 };
	for (int i = 0; i < 6; i++)
	{
		scanf("%d", &iarr[i]);
	}
	for (int i = 0; i < 6; i++)
	{
		printf("%d ", chess[i] - iarr[i]);
	}
	
}