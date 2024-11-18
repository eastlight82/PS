use std::io::*;
use std::collections::*;
use std::cmp::*;

#[derive(Copy, Clone, Eq, PartialEq)]
struct Node { //N의 v, w 설정
    vertex: usize,
    cost: usize,
}

// 우선순위 큐에서 `Node`가 작은 순으로 나오도록 `Ord`와 `PartialOrd`를 구현
impl Ord for Node {
    fn cmp(&self, other: &Self) -> Ordering {
        // 우선순위 큐에서 최소 힙을 사용해야 하므로 반대로 비교
        other.cost.cmp(&self.cost)
    }
}

impl PartialOrd for Node {
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
        Some(self.cmp(other))
    }
}

fn dijkstra(adjL: &HashMap<usize, Vec<(usize, usize)>>, start: usize) -> HashMap<usize, usize> {
    let mut dist = HashMap::new(); // dist
    let mut heap = BinaryHeap::new(); // !vis, min

    // 시작N dist 0
    dist.insert(start, 0);
    heap.push(Node { vertex: start, cost: 0 });

    while let Some(Node { vertex, cost }) = heap.pop() {
        // 현재 노드의 비용이 더 크다면 이미 dist 처리됨: 무시
        if cost > *dist.get(&vertex).unwrap() {
            continue;
        }

        // adjN들 new 갱신
        if let Some(neighbors) = adjL.get(&vertex) {
            for &(next_vertex, weight) in neighbors {
                let next_cost = cost + weight;

                // new<기존| 새 path
                if next_cost < *dist.get(&next_vertex).unwrap_or(&usize::MAX) {
                    dist.insert(next_vertex, next_cost);
                    heap.push(Node {
                        vertex: next_vertex,
                        cost: next_cost,
                    });
                }
            }
        }
    }

    dist
}

fn main() {
    // 그래프를 adjL로 표현 (노드: [(adj N, w)])
    let mut br: String= String::new();
    stdin().read_line(&mut br);
    let n:i32= br.trim().parse().unwrap();  //N
    br.clear(); stdin().read_line(&mut br);
    let m:i32= br.trim().parse().unwrap();  //E

    let mut adjL: HashMap<usize, Vec<(usize, usize)>> = HashMap::new();

    for i in 0..m{
        br.clear(); stdin().read_line(&mut br);
        let ipt_v:Vec<&str>= br.trim().split(" ").collect();
        let a1:usize=ipt_v.get(0).unwrap().parse().unwrap();
        let a2:usize=ipt_v.get(1).unwrap().parse().unwrap();
        let a3:usize=ipt_v.get(2).unwrap().parse().unwrap();

        adjL.entry(a1).or_insert(vec![]).push((a2,a3));
    }

    br.clear(); stdin().read_line(&mut br);
    let ipt_v:Vec<&str>= br.trim().split(" ").collect();
    let start_city:usize=ipt_v.get(0).unwrap().parse().unwrap();
    let end_city:usize=ipt_v.get(1).unwrap().parse().unwrap();



    let distances = dijkstra(&adjL, start_city);

    println!("{}",distances.get(&end_city).unwrap());

    // for (node, distance) in &distances {
    //     println!("Node {}: Distance {}", node, distance);
    // }
}
