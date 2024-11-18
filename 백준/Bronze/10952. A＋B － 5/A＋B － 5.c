#include <stdio.h>

int main()
{
	while (1)
	{
		int b = 0; int c = 0;
		scanf("%d %d", &b, &c);
		if (b == 0 && c==0)
			break;
		printf("%d\n", b + c);
	}

}