#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
  
  string s; cin >> s;//문자열(접미사 만들거)
  vector <string> tail_vec; //접미사 담을 vec
  for (int i=0; i<s.size(); i++)//vec에 다 담음
  {
    string tmp= s.substr(i,s.size()-i);
    tail_vec.push_back(tmp);
  }

  sort(tail_vec.begin(),tail_vec.end());

  for (int i=0; i<s.size(); i++)//출력
  {
    cout << tail_vec[i] << '\n';
  }

}