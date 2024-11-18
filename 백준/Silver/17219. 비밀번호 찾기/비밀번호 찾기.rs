use std::io;
use std::collections::*;

fn main() {
    let mut ipt= String::new();
    io::stdin().read_line(&mut ipt);
    let v:Vec<&str>= ipt.trim().split(" ").collect();
    let n: i32= v.get(0).unwrap().parse().unwrap();
    let m: i32= v.get(1).unwrap().parse().unwrap();

    let mut maps: HashMap<String,String>= HashMap::new();

    for i in 0..n{
        ipt.clear();
        io::stdin().read_line(&mut ipt);
        let v:Vec<&str>= ipt.trim().split(" ").collect();
        let v1= v.get(0).unwrap().to_string();
        let v2= v.get(1).unwrap().to_string();
        maps.insert(v1, v2);
    }

    for i in 0..m{
        ipt.clear();
        io::stdin().read_line(&mut ipt);
        let v= ipt.trim();
        let x= maps.get(v).unwrap();
        println!("{x}");

    }

}
