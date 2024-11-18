#include <stdio.h>

int main()
{	
	int a;
	scanf("%d", &a);
	for (int i = 0; i < a; i++)
	{
		int b = 0; int c = 0;
		scanf("%d %d", &b, &c);
		printf("Case #%d: %d + %d = %d\n", i+1, b, c, b + c);
	}

}

