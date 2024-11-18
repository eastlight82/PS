#include <bits/stdc++.h>
using namespace std;

string S,P; //P<S?

int main(){ios::sync_with_stdio(false); cin.tie(NULL);
  cin >> S >> P;

  if (strstr(S.c_str(), P.c_str()))
    cout << 1;
  else
    cout << 0;
}