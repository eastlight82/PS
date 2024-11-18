#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <ctype.h>

int main()
{
	int i; char str[101];
	scanf("%s", str);
	int len = strlen(str);
	int roop = strlen(str);

	for (i = 0; i < roop; i++)
	{
		if (str[i] == 'c')
		{
			if ((str[i + 1] == '=') || (str[i + 1] == '-'))
				len -= 1;
		}
		if (str[i + 1] == 'j')
		{
			if ((str[i] == 'l') || (str[i] == 'n'))
				len -= 1;
		}
		if (str[i] == 's')
		{
			if (str[i + 1] == '=')
				len -= 1;
		}
		if (str[i] == 'd')
		{
			if (str[i + 1] == '-')
				len -= 1;
		}
		if (str[i] == 'z')
		{
			if (str[i + 1] == '=')
			{
				if (i != 0)
					if (str[i - 1] == 'd')
					len -= 2;
				if (str[i - 1] != 'd')
					len -= 1;
			}
		}
		
	}
	printf("%d", len);
}