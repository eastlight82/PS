//3점: ij로 반복문 돌려서, chose 2개 뽑기
#include <bits/stdc++.h>
using namespace std;
#define MAX 21

int N, answMin=INT_MAX; //인원#, answ
int S[MAX][MAX];
vector <bool> chose; //1~N, chose되면 A팀

void calcSkill(){//chose한거 합, !chose 합
    int A= 0, B=0;
    for (int i=1; i<=N; i++){ //*ij 2개로 chose 2개 뽑기
        for (int j=1; j<=N; j++){
            if (chose[i] && chose[j])
                A+= S[i][j]; //ij만 더해야함(ji는 그때)
                
            else if (!chose[i] && !chose[j])
                B+= S[i][j];
        }
    }
    
    answMin=min(answMin, abs(A-B));

}

void choseTeam(int idx, int cnt){//idx:여기부터 조사하세요
    if (cnt>=2 && (N-cnt)>=2)//한팀에 최소 2이상
        calcSkill();
    
    for (int i=idx; i<=N; i++){
        chose[i]=true;
        choseTeam(i+1,cnt+1);
        chose[i]=false;
    }
        
}

int main(){ios::sync_with_stdio(false); cin.tie(NULL);
    cin >> N;
    chose.resize(N+1);
    
    for (int i=1; i<=N; i++){
        for (int j=1; j<=N; j++){
            cin >> S[i][j];
        }
    }//input 완료
    
    for (int i=1; i<=N; i++){//첫 선택num
        chose[i]=true;
        choseTeam(i+1,1);
        chose[i]=false;
    }
    
    
    cout << answMin;
    
}