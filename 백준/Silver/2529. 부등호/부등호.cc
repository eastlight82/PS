#include <bits/stdc++.h>
using namespace std;

int k; // 부등호의 개수
vector<char> v; // 부등호를 저장하는 벡터
bool numChose[10]; // 숫자가 선택되었는지 여부를 저장하는 배열
string answMax = "", answMin = "9999999999"; // 가능한 최대, 최소 값을 저장

// 부등호 조건을 만족하는 숫자열을 생성하는 함수
void makeAnsw(int cnt, string answ) {
    if (cnt == k + 1) { // 숫자가 모두 채워졌다면
        if (answ > answMax) answMax = answ; // 최대값 갱신
        if (answ < answMin) answMin = answ; // 최소값 갱신
        return;
    }

    for (int i = 0; i <= 9; i++) {
        if (!numChose[i]) { // 숫자가 사용되지 않았다면
            if (cnt == 0 || (v[cnt - 1] == '<' && answ.back() < (i + '0')) || (v[cnt - 1] == '>' && answ.back() > (i + '0'))) {
                numChose[i] = true;
                makeAnsw(cnt + 1, answ + to_string(i));
                numChose[i] = false;
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> k;
    v.resize(k);
    for (int i = 0; i < k; i++) {
        cin >> v[i];
    }

    for (int i = 0; i <= 9; i++) {
        numChose[i] = true;
        makeAnsw(1, to_string(i));
        numChose[i] = false;
    }

    cout << answMax << '\n' << answMin << '\n';

    return 0;
}
