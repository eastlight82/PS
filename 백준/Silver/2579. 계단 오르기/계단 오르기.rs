//3점: 마지막 계단은 밟아야하니, dp[0] 제외
use std::io;
use std::collections::*;
use std::cmp::*;

fn main() {
    //계단 오르기: 한번에 +1, 2(쉬는거 최대 1번)
    //연속 3개x
    //마지막은 꼭

    let mut br = String::new();
    io::stdin().read_line(&mut br).unwrap();

    let N = br.trim().parse().unwrap();
    let mut vec1: Vec<i32> = Vec::new(); //stair값
    for _ in 0..N {
        br.clear();
        io::stdin().read_line(&mut br).unwrap();
        let floor: i32 = br.trim().parse().unwrap();

        vec1.push(floor);
    } //stair[0 as usize]

    let mut dp: Vec<Vec<i32>> = vec![vec![0;3];N]; //dp

    dp[0]=vec![0, vec1[0],0];

    //dp[a][0,1,2] 3이상x

    for i in 1..N{
        if i==1{
            dp[i][0]= dp[i-1][1];
            dp[i][1]= dp[i-1][0]+vec1[i];
            dp[i][2]= dp[i-1][1]+vec1[i];
        }
        else{
            dp[i][0]= max(dp[i-1][1],dp[i-1][2]);
            dp[i][1]= dp[i-1][0]+vec1[i];
            dp[i][2]= dp[i-1][1]+vec1[i];
        }
    }

    println!("{}",max(dp[N-1][1],dp[N-1][2]));
}

