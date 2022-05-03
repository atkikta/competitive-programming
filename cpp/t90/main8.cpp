#include <bits/stdc++.h>
using namespace std;

const int MOD = 1000000007;

int main(){
    int n;
    cin >> n ;
    string s;
    cin >> s;
    vector<vector<int>> dp(n+1, vector<int>(8));
    string target = "atcoder";
    dp[0][0] = 1;
    for(int i=0; i<n; i++){
        for(int j=0; j<=7; j++){
            dp[i+1][j] += dp[i][j];
            dp[i+1][j] %= MOD;
            if(j<7 && s[i] == target[j]) {
                dp[i+1][j+1] += dp[i][j];
                dp[i+1][j+1] %= MOD;
            }
        }
    }
    cout << dp[n][7] << endl;
}