#include <bits/stdc++.h>
using namespace std;

#define MAX 1000001

int arr[MAX];

void prime_check(){
  //arr[i]==0이면 i 소수

  for (int i=2; i<=sqrt(MAX); i++){
    if (arr[i]!=0)
      continue;

    for (int j=i; i*j<=MAX; j++){
      arr[i*j]=1;
    }
  }
}

int main(){ios_base::sync_with_stdio(false); cin.tie(NULL);
  //짝수 입력-> 홀소수+홀소수
  int n; 

  prime_check();
  
  while (1){
    cin >> n; if (n == 0) break;
    bool pri=false;

    for (int i=3; i<MAX; i+=2){
      if (arr[i]==0 && arr[n-i]==0){
        cout << n << " = " << i << " + " << n-i << "\n";
        pri=true;
        break;
      }   
    }

    if (!pri) cout << "\"Goldbach's conjecture is wrong.\"";
  }
}

