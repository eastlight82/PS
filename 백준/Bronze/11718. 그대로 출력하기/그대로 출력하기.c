#include <stdio.h>

int main()
{
	int ch;

	while (1)
	{
		// 키보드로부터 입력받음
		ch = getchar();
		if (ch == EOF)
		{
			break;
		}
		putchar(ch);
	}

	return 0;
}