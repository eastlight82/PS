#include <bits/stdc++.h>
using namespace std;

int main(){ios::sync_with_stdio(false); cin.tie(NULL);
  int T; cin>>T;

  vector <int> v;

  while (T--){
    v.resize(2);
    cin >>v[0] >>v[1];

    cout << accumulate(v.begin(),v.end(),0) << "\n";

    v.clear();
  }
}