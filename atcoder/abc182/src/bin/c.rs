use proconio::input;
use proconio::marker::Chars;
use std::cmp;


fn main() {
    input!{
        n:Chars
    }
    let l = n.len();
    let mut ans = l;
    for i in 0..(1<<l){
        let mut sum = 0;
        let mut count = 0;
        for j in 0..l {
            if((i>>j) & 1) == 1{
                sum += n[j].to_digit(10).unwrap();
            }else{
                count += 1;
            }
        }
        if sum %3 == 0{
            ans = cmp::min(ans, count);
        }
    }
    if ans == l{
        println!("{}", -1);
    }else{
        println!("{}", ans);
    }
}
