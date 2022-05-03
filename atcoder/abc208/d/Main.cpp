#include <bits/stdc++.h>
using namespace std;

int main(){
    int n, m;
    cin >> n >> m;
    vector<vector<int>> graph(n);
    vector<vector<int>> cost(n, vector<int>(n));
    for(int i=0; i<m; i++){
        int a, b, c;
        cin >> a >> b >> c;
        graph.at(a-1).push_back(b-1);
        cost.at(a-1).at(b-1) = c;
    }
    vector<vector<int>> dp(n, vector<int>(n, INT32_MAX/2));
    for(int i=0; i<n; i++){
        dp.at(i).at(i) = 0;
        for(int j: graph.at(i)){
            dp.at(i).at(j) = cost.at(i).at(j);
        }
    }
    long ans = 0;
    for(int i=0; i<n; i++){
        vector<vector<int>> nxt(n, vector<int>(n,0));
        for(int j = 0; j<n; j++){
            for(int k=0; k<n; k++){
                nxt.at(j).at(k) = min(dp.at(j).at(k), dp.at(j).at(i) + dp.at(i).at(k));
                if(nxt.at(j).at(k) < INT32_MAX/2) ans += nxt.at(j).at(k); 
            }
        }
        dp = nxt;
    }
    cout << ans << endl;
}