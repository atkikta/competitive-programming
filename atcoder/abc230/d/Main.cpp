#include <bits/stdc++.h>
using namespace std;

bool less_second(pair<int,int> lhs, pair<int,int> rhs) {
    return lhs.second < rhs.second;
}
int main(){
    int n, d;
    cin >> n >> d;
    vector<pair<int, int>> vec(n);
    for(int i=0; i<n; i++){
        int l, r;
        cin >> l >> r;
        vec[i] = make_pair(l, r);
    }
    sort(vec.begin(), vec.end(), less_second);
    int at = 0;
    int to = 0;
    int count = 0;
    for(auto p: vec){
        if(to < p.first){
            count ++;
            at = p.second;
            to = at + d -1;
        }
    }
    cout << count << endl;
}