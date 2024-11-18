//5점
#include <bits/stdc++.h>
using namespace std;

int N; //1부터 N까지 이어쓰기

int main(){ios::sync_with_stdio(false); cin.tie(NULL);
    cin >> N;
    
    //1~9는 +1, 10~99: +2, 100~999: +3...
    int copyN= N, digit=1;
    while (copyN){
        copyN/=10;
        
        if (copyN)
            digit++;
    }//digit 구하기
    
    
    switch (digit){
        
        case 1: cout << N;
            break;
            
        case 2: cout << 9+(N-9)*2;
            break;
            
        case 3: cout << 9+2*90+(N-99)*3;
            break;
            
        case 4: cout << 9+2*90+3*900+(N-999)*4;
            break;
            
        case 5: cout << 9+ 2*90+ 3*900+ 4*9000+ (N-9999)*5;
            break;
        
        case 6: cout << 9+ 2*90+ 3*900+ 4*9000+ 5*90000+ (N-99999)*6;
            break;
        
        case 7: cout << 9+ 2*90+ 3*900+ 4*9000+ 5*90000+ 6*900000+ 
        (N-999999)*7; break;
        
        case 8: cout << 9+ 2*90+ 3*900+ 4*9000+ 5*90000+ 6*900000+
        7*9000000+ (N-9999999)*8; break;
        
        case 9: cout << 9+ 2*90+ 3*900+ 4*9000+ 5*90000+ 6*900000+
        7*9000000+ 8*90000000+ (N-99999999)*9; break;
        
        case 10: cout << 9+ 2*90+ 3*900+ 4*9000+ 5*90000+ 6*900000+
        7*9000000+ 8*90000000+ 9*900000000+ (N-999999999)*10;
        
    }
    
    
}