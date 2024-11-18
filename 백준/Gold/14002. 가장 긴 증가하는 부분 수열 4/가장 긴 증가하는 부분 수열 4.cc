//3점: 반복문들 햇갈리지 않기
#include <bits/stdc++.h>
using namespace std;

int N;
vector <int> Ai;
//memo
vector <int> memoLen; //길이
vector <int> memoVec[1001];


int main()
{
    cin >> N;
    Ai.resize(N); memoLen.resize(N);
    
    for (int i=0; i<N; i++)
        cin >> Ai[i]; //cin완료: Ai
    
    
    for (int i=0; i<N; i++)
        memoLen[i]=1; //len=1로 초기화
    
    memoVec[0].push_back(Ai[0]);
    
    for (int i=1; i<N; i++){ //i=현재 memo할값
        int maxLenJ=-1; //dfltVal
        
        for (int j=0; j<i; j++){ //j=비교할 값
            //증가 만족j중 LenMax 구하기
            if (Ai[j]<Ai[i]){ 
                if (maxLenJ==-1) //이것이 만족j중 init값
                    maxLenJ=j;
                
                else if (memoLen[j]>memoLen[maxLenJ]) 
                    maxLenJ=j;
            }
        }
            
            
        if (maxLenJ!=-1) {//O
            memoLen[i]=memoLen[maxLenJ]+1;
            
            for (int k=0; k<memoVec[maxLenJ].size(); k++){
                memoVec[i].push_back(memoVec[maxLenJ][k]);
            }//memoVec에 이전값 push
        }
            
        memoVec[i].push_back(Ai[i]);//현값 push
            
    }

    int answLen=0, answI;
    //cout: Max#수열의 #, vec
    for (int i=0; i<N; i++){
        if (answLen<memoLen[i]){
            answLen=max(answLen, memoLen[i]);
            answI=i;
        }
    }
    cout << answLen << "\n";
    
    for (int i=0; i<memoVec[answI].size(); i++){
        cout << memoVec[answI][i] << " ";
    }
}