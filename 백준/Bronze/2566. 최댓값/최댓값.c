#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main()
{
	int i, j; int iarr[9][9];
		for (i = 0; i < 9; i++)
		{
			for (j = 0; j < 9; j++)
				scanf("%d", &iarr[i][j]);
		}
		int max = 0; int I=1, J=1;
		for (i = 0; i < 9; i++)
		{
			for (j = 0; j < 9; j++)
				if (max < iarr[i][j])
				{
					max = iarr[i][j];
					I = i + 1; J = j + 1;
				}
					
		}

		printf("%d\n%d %d", max, I, J);

}