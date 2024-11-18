//5점, Gold 달성!

#include <bits/stdc++.h>
using namespace std;
#define MAX 1000001

int F,S,G,U,D; //총 F층, 링크는 G층, 현재 S층, 위로 U층, 아래로 D층

//각 층별로 도달필요 Cnt memo하기
vector <int> Floors(MAX);
bool vis[MAX]; //cnt=1,2,3..순서로 점점 커지기에, 따로 min값 구할 필요 x
queue <int> q;

void BFS(int S){
  q.push(S); vis[S]= true; Floors[S]=0;

  while (!q.empty()){
    int curr= q.front(); q.pop();

    if (curr==G) break; //G값 구하면 Break

    int nextU= curr+U;
    if (nextU<=F && !vis[nextU]){
      q.push(nextU);
      vis[nextU]=true;
      Floors[nextU]=Floors[curr]+1;
    }

    int nextD= curr-D;
    if (nextD>=1 && !vis[nextD]){
      q.push(nextD);
      vis[nextD]=true;
      Floors[nextD]=Floors[curr]+1;
    }
  }
}


int main() {ios::sync_with_stdio(false); cin.tie(NULL);
  cin >> F >> S >> G >> U >> D; //총 F층, 링크는 G층, 현재 S층, 위로 U층, 아래로 D층

  BFS(S);

  if (S!=G && Floors[G]==0)
    cout << "use the stairs";

  else
    cout << Floors[G];
}

