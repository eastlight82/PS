#include <bits/stdc++.h>
using namespace std;

#define MAX 1000
int M, N;
int maps[MAX][MAX]; // Tomato map

bool vis[MAX][MAX]; // Visited cells
int dist[MAX][MAX]; // Distance map

int cX[4] = {1, -1, 0, 0}, cY[4] = {0, 0, 1, -1}; // 4 directions

queue<pair<int, int>> q;

void BFS() {
    while (!q.empty()) {
        int X = q.front().first;
        int Y = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nX = X + cX[i];
            int nY = Y + cY[i];

            if (0 <= nX && nX < N && 0 <= nY && nY < M && !vis[nX][nY] && maps[nX][nY] == 0) {
                q.push({nX, nY});
                vis[nX][nY] = true;
                dist[nX][nY] = dist[X][Y] + 1;
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    cin >> M >> N;

    for (int i = 0; i < N; i++) { // Read the map
        for (int j = 0; j < M; j++) {
            cin >> maps[i][j];
            if (maps[i][j] == 1) { // Add ripe tomatoes to the queue
                q.push({i, j});
                vis[i][j] = true;
                dist[i][j] = 0; // Starting points have 0 days
            }
            else {
                dist[i][j] = -1; // Not visited and not ripe
            }
        }
    }

    BFS(); // Perform BFS from all ripe tomatoes

    int maxDist = 0;
    bool allRipe = true;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (maps[i][j] == 0 && dist[i][j] == -1) {
                allRipe = false; // There is at least one tomato that cannot be ripened
            }
            if (dist[i][j] > maxDist) {
                maxDist = dist[i][j];
            }
        }
    }

    if (allRipe) {
        cout << maxDist;
    } else {
        cout << -1;
    }

    return 0;
}
