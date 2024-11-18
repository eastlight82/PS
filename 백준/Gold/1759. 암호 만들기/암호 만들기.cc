//GPT
#include <bits/stdc++.h>
using namespace std;

int L, C;
vector<char> letters;

void chooseWords(int idx, string words, int vow, int con) {
    // 조건을 만족하면 출력
    if (words.size() == L) {
        if (vow >= 1 && con >= 2) {
            cout << words << '\n';
        }
        return;
    }

    for (int i = idx; i < C; i++) {
        char ch = letters[i];
        // 모음 체크
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            chooseWords(i + 1, words + ch, vow + 1, con);
        } else {
            chooseWords(i + 1, words + ch, vow, con + 1);
        }
    }
}

int main() {
    ios::sync_with_stdio(false); 
    cin.tie(NULL);

    cin >> L >> C;
    letters.resize(C);

    for (int i = 0; i < C; i++) {
        cin >> letters[i];
    }

    sort(letters.begin(), letters.end());

    chooseWords(0, "", 0, 0);

    return 0;
}
