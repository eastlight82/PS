//3점: Greedy Idea()는 잘짬, main구현(while, 세부idx), 예외ctrl 잘하기
#include <bits/stdc++.h>
using namespace std;

int N,K; //보석 N개 (무게,가격)
//가방 K개 (Max무게): 가방엔 1개의 보석
vector <pair <int, int>> jew;
vector <int> bag;

priority_queue <int> tmp;
vector <int> answ; 

int main(){ios::sync_with_stdio(false); cin.tie(NULL);
  cin >> N >> K;
  jew.resize(N); bag.resize(K);

  for (int i=0; i<N; i++)
    cin >> jew[i].first >> jew[i].second;
  
  for (int i=0; i<K; i++)
    cin >> bag[i]; //cin: 완료


  //Greedy: 가방을 min하게 sort->가능한 보석중 max
  sort(bag.begin(),bag.end()); 
  sort(jew.begin(),jew.end()); //jew sort: 가능한거 먼저

  int idx=0; //*jew#보단 밑
  for (int i=0; i<K; i++){
    while (idx<N && jew[idx].first <= bag[i]){ //*while (jew가 가방 크기 만족 && idx가 jew#보다 밑)
        tmp.push(jew[idx].second); //65 99
        idx++; //*else뜨면, 다음 idx는 else뜬거부터
      } 
      
    if (!tmp.empty()){ //*DoubleFree error
      answ.push_back(tmp.top());
      tmp.pop();
    }
  }
  
  //cout 가격Sum의 최대
  cout << accumulate(answ.begin(),answ.end(),0LL); //*범위 최대 20억 넘어감
}