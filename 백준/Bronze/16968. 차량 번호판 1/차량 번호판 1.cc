#include<iostream>
#include<string>
 
#define endl "\n"
using namespace std;
 
string Inp;
 
void Input()
{
    cin >> Inp;
}
 
void Solution()
{
    int C = 26;
    int D = 10;
    int Answer = 1;
 
    for (int i = 0; i < Inp.length(); i++)
    {
        if (Inp[i] == 'c')
        {
            if (i - 1 >= 0)
            {
                if (Inp[i - 1] == 'c')
                {
                    Answer = Answer * (C - 1);
                }
                else
                {
                    Answer = Answer * C;
                }
            }
            else
            {
                Answer = Answer * C;
            }
        }
        else
        {
            if (i - 1 >= 0)
            {
                if (Inp[i - 1] == 'd')
                {
                    Answer = Answer * (D - 1);
                }
                else
                {
                    Answer = Answer * D;
                }
            }
            else
            {
                Answer = Answer * D;
            }
        }
    }
    cout << Answer << endl;
}
 
void Solve()
{
    Input();
    Solution();
}
 
int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    //freopen("Input.txt", "r", stdin);
    Solve();
 
    return 0;
}