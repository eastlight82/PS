#include <bits/stdc++.h>
using namespace std;

vector <int> heights; //memo

int main(){ios::sync_with_stdio(false); cin.tie(NULL);
int sum9=0, N;
  for (int i=0; i<9; i++){
    cin >> N;
    heights.push_back(N);
    sum9+=N; 
  } //9난쟁이 memo
  sort(heights.begin(), heights.end()); //정렬

  int sum=0; //9C2=36, 뺄 2개 고르기
  bool roopEndCheck= false;
  for (int i=0; i<9; i++){
    if (roopEndCheck)
      break;

    for (int j=0; j<9; j++){
      if (i==j) //동일한건 못뺌
        continue;
      
      if (sum9-heights[i]-heights[j]==100){
        for (int m=0; m<9; m++){
          if (m!= i && m!= j)
            cout << heights[m] << "\n";
        }
        roopEndCheck=true;
        break;
      }
    }
  }
}

