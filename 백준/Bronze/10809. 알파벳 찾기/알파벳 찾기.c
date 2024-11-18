#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
    char strS[101];//입력값
    char stra[26];//a b c d 
    int str_one[26];//-1 -1 -1
    int i;
    scanf("%s", strS);
    for (i = 0; i < 26; i++)
        stra[i] = i + 97;///a b c d 만들어줌
    for (i = 0; i < 26; i++)
        str_one[i] = -1;///-1 -1 -1 만들어줌
    for (i = 0; i < 101; i++)
    {
        if (strS[i] == NULL)
            break;

        for (int j = 0; j < 26; j++)
        {
            if (stra[j] == strS[i])
                if (str_one[j]== -1)
                    str_one[j] = i;

        }
    }
    for (i = 0; i < 26; i++)
        printf("%d ", str_one[i]);

    return 0;
}