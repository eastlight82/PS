#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

#define dfltforMin 99999
#define blockMAX 101

int laddCnt, snakeCnt;
vector<pair<int, int>> ladd;
vector<pair<int, int>> snake;

vector<int> blockCnt(blockMAX, dfltforMin); // 각 칸에 도달하기 위한 최소 횟수

void BFS() {
    queue<int> q;
    q.push(1);
    blockCnt[1] = 0;

    while (!q.empty()) {
        int curr = q.front();
        q.pop();

        for (int i = 1; i <= 6; i++) {
            int next = curr + i;
            if (next > 100) continue; // 100번 칸을 넘지 않도록

            // 사다리나 뱀에 의해 이동이 발생하는지 체크
            for (auto &l : ladd) {
                if (next == l.first) {
                    next = l.second;
                    break;
                }
            }
            for (auto &s : snake) {
                if (next == s.first) {
                    next = s.second;
                    break;
                }
            }

            if (blockCnt[next] > blockCnt[curr] + 1) {
                blockCnt[next] = blockCnt[curr] + 1;
                q.push(next);
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> laddCnt >> snakeCnt;
    int fir, sec;

    while (laddCnt--) {
        cin >> fir >> sec;
        ladd.push_back({fir, sec});
    }

    while (snakeCnt--) {
        cin >> fir >> sec;
        snake.push_back({fir, sec});
    }

    BFS();
    cout << blockCnt[100] << endl;
    return 0;
}
