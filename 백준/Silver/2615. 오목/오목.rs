use std::io;
static MAX:i32=19;


fn dfs(y:i32, x:i32, cnt:i32, d:i32, clr:i32, graph:&Vec<Vec<i32>>)->i32{
    let dyx: Vec<Vec<i32>>= vec![vec![1,0],vec![0,1],vec![1,1],vec![-1,1]];

    let nY=y+dyx[d as usize][0];
    let nX=x+dyx[d as usize][1];

    //cnt5: 6목이 조건 불만족이거나 clr 다르면 통과
    
    if cnt>=5{
        if (nY<0 || nY>=MAX || nX<0 || nX>=MAX) || graph[nY as usize][nX as usize]!=clr 
            {return 1}//조건만족, 다음꺼 x
        else {return 0}
    }

    // !cnt5: 다음이 조건 불만족이거나 clr 다르면 실패
    if (nY<0 || nY>=MAX || nX<0 || nX>=MAX) || graph[nY as usize][nX as usize]!=clr 
        {return 0} //조건 불만족
    

    dfs(nY,nX, cnt+1, d, clr, graph)

}

fn main() {
    let mut graph:Vec<Vec<i32>>=Vec::new(); //전체 오목판
    let dyx: Vec<Vec<i32>>= vec![vec![1,0],vec![0,1],vec![1,1],vec![-1,1]];

    for _ in 0..MAX{
        let mut buf=String::new();
        io::stdin().read_line(&mut buf).expect("P");
        let ls: Vec<&str>= buf.trim().split(" ").collect(); //[ [1,0,1,1,0] [1,2,0,1,1]]
        
        let mut v: Vec<i32>= vec![];

        for x in 0..MAX{
            v.push(ls[x as usize].parse().expect("F"))
        }
        graph.push(v)

    } //graph ipt 완료

    for startY in (0..MAX){
        for startX in (0..MAX){

            if graph[startY as usize][startX as usize]!=0{ //cnt=1, clr 정하기
                let clr=graph[startY as usize][startX as usize];

                for d in 0..4{
                    //y+dy, x+dx
                    let bfY=startY-dyx[d as usize][0]; 
                    let bfX=startX-dyx[d as usize][1];

                    if bfY>=0 && bfY<MAX && bfX>=0 && bfX<MAX { //범위 안
                        if graph[bfY as usize][bfX as usize]==clr{ //6목이면 ctinu
                            continue;
                        }
                    }

                    if dfs(startY,startX, 1, d, clr, &graph)==1{
                        println!("{clr}"); 
                        let answY=startY+1; let answX=startX+1;
                        println!("{answY} {answX}"); //실제 idx
                        return
                    }           
                }
            }
        }
        
    }

    println!("0")
    

}
