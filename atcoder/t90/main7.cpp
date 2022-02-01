#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin >> n;
    vector<int> a(n);
    for(int i=0; i<n; i++){
        int ai;
        cin >> ai;
        a[i] = ai;
    }
    int q;
    cin >> q;
    vector<int> b(q);
    for(int i=0; i<q; i++){
        int bi;
        cin >> bi;
        b[i] = bi;
    }
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());
    
    for(int i=0; i<q; i++){
        int lb = lower_bound(a.begin(), a.end(), )
    }
    
}