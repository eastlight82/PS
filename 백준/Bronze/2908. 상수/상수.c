#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main(void) 
{
    int k; char st1[4], st2[4];
    scanf("%s %s", st1, st2);
    for (int j = 2; j >= 0; j--)
    {
        if (st1[j] > st2[j])
        {
            for (k = 2; k >= 0; k--)
                printf("%c", st1[k]);
            break;
        }
        else if (st1[j] < st2[j])
        {
            for (k = 2; k >= 0; k--)
                printf("%c", st2[k]);
            break;
        }
    }

}