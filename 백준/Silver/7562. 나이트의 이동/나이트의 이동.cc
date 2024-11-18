#include <bits/stdc++.h>
using namespace std;

#define MAX 301
int l, nx, ny, gx, gy;

// string maps[MAX];
bool vis[MAX][MAX];
int dist[MAX][MAX];

int dX[8]={-2,-2,-1,-1,1,1,2,2},dY[8]={1,-1,2,-2,2,-2,1,-1};

void reset(){
  for (int i=0; i<MAX; i++)
    for (int j=0; j<MAX; j++){
      vis[i][j]=0;
      dist[i][j]=0;
    }
}

//BFS, 모두 순회 돌려서 저장해두기
void BFS(int start_x, int start_y){
  queue <pair<int,int>> q;
  q.push({start_x,start_y}); vis[start_x][start_y]=true;

  while (!q.empty()){
    int X=q.front().first;
    int Y=q.front().second;
    q.pop();

    for (int i=0; i<8; i++){
      int nX= X+ dX[i]; //a,b값은 고정되어야
      int nY= Y+ dY[i];
      
      if (0<=nX && 0<=nY && nX<l && nY<l && !vis[nX][nY]){
        q.push({nX,nY}); //연결된 곳: 같은 섬(cnt X)
        vis[nX][nY]=true;
        dist[nX][nY]=dist[X][Y]+1;
      }
    }
  } 
}


int main() {ios_base::sync_with_stdio(false); cin.tie(NULL);
  int cases; cin >> cases;
  //nx, ny: 현재, gx, gy: goal

  while (cases--){
    cin >> l >> nx >> ny >> gx >> gy;
    BFS(nx,ny);    

    cout << dist[gx][gy] << endl;
    reset(); //case 여러번일 경우: reset해야
  }
  
}


