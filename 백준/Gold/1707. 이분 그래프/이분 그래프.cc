#include <bits/stdc++.h>
using namespace std;

#define MAX 20002
#define RED 1
#define BLUE 2

int K, V, E;
vector<int> adjList[MAX];
int vis[MAX];

void reset() {
    for (int i = 1; i <= V; i++) {
        adjList[i].clear();
        vis[i] = 0;
    }
}

bool DFS(int startX) {
    stack<int> stck;
    stck.push(startX); 
    vis[startX] = RED;

    while (!stck.empty()) {
        int curr = stck.top();

        for (int i=0; i<adjList[curr].size(); i++){
            int next=adjList[curr][i];
            if (!vis[next]){
                stck.push(next);
                vis[next]= (vis[curr]==RED) ? BLUE : RED;
            }
            else if (vis[next] == vis[curr]) {
                return false;
            }
            // else if (i== adjList[curr].size()-1){//끝까지 다 vis
            //     stck.pop();
            // }
        }
        
        if (stck.top()==curr)
            stck.pop();
    }
    return true;
}

bool isBipartite() {
    for (int i = 1; i <= V; i++) {
        if (!vis[i]) {
            if (!DFS(i))
                return false;
        }
    }
    return true;
}

int main() {
    ios::sync_with_stdio(false); 
    cin.tie(NULL);

    cin >> K; // Test Case input

    while (K--) {
        cin >> V >> E;
        reset();
        
        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adjList[u].push_back(v);
            adjList[v].push_back(u);
        } 
        
        if (isBipartite())
            cout << "YES\n";
        else
            cout << "NO\n";
    }
}
