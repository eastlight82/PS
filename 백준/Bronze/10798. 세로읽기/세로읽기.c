#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main()
{
	int i, j; char iarr[5][16];
	for (i = 0; i < 5; i++)
	{
		for (j = 0; j < 15; j++)
		{
			iarr[i][j] = NULL;
		}
	}
	for (i = 0; i < 5; i++)
	{
		scanf("%s", iarr[i]);
	}//iarr[0][0]->[1][0]->[2][0]...[4][0]
	for (i = 0; i < 15; i++)
	{
		for (j = 0; j < 5; j++)
		{
			if (iarr[j][i] == NULL)
				continue;
				
			printf("%c", iarr[j][i]);
			
		}
	}


}