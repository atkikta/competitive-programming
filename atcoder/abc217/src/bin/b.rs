use proconio::input;
use std::collections::BTreeSet;

fn main() {
    input!{
        s1: String,
        s2: String,
        s3: String,
    }
    let mut set: BTreeSet<String> = vec![
        String::from("ABC"),
        String::from("ARC"),
        String::from("AGC"),
        String::from("AHC")].iter().cloned().collect();
    set.remove(&s1);
    set.remove(&s2);
    set.remove(&s3);
    let ans = set.iter().next();
    println!("{}", ans.unwrap());
}
