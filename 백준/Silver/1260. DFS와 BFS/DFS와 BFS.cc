#include <bits/stdc++.h>
using namespace std;

#define MAX 1001
 
vector<vector <int>> vec(MAX);
bool vis[MAX];

void reset() {
    for (int i = 0; i <= MAX; i++)
        vis[i] = 0;
}
 
void bfs(int temp){
    queue<int> q;
    q.push(temp); vis[temp] = true; cout << temp << " ";
    
    while(!q.empty()){
        int curr = q.front();
        q.pop(); 
 
        for (int i = 0; i < vec[curr].size(); i++){
            int val= vec[curr][i];
            if(!vis[val]){ //방문하지 않은 곳만 탐색
                q.push(val); vis[val] = true; cout << val << " ";
            }
        }
    }
}
 
void dfs(int x){
    vis[x] = true; cout << x << " ";
 
    for (int i = 0; i < vec[x].size(); i++){
        if(!vis[vec[x][i]]){ //방문하지 않은 곳만 탐색
            dfs(vec[x][i]);
        }
    }
}
 
int main(){
    int n, m, v, a, b;
    cin >> n >> m >> v;
 
    for (int i = 1; i <= m;i++){
        cin >> a >> b;
        vec[a].push_back(b); //양방향 간선처리
        vec[b].push_back(a); //양방향 간선처리
    }
    for (int i = 1; i <= n;i++){
        sort(vec[i].begin(), vec[i].end()); // 낮은 숫자부터 탐색.
    }
    dfs(v);
    cout << endl; reset();
    bfs(v);
    
    return 0;
}