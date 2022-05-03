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
    a.push_back(2000000001);
    a.push_back(-2000000001);

    sort(a.begin(), a.end());
    
    for(int i=0; i<q; i++){
        auto posL = lower_bound(a.begin(), a.end(), b[i]);
        int right = *posL;
        int left = *(--posL);
        // cout << left <<" "<< right <<endl;
        cout << min(abs( left - b[i]) , abs(right - b[i])) << endl;
    }
}