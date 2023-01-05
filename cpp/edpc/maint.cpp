#include <bits/stdc++.h>
// vector input
template<typename T> std::istream& operator >> (std::istream& is, std::vector<T>& vec){
    for(T& x: vec) is >> x;
    return is;
}
// vector join
template<typename T> std::string join(std::vector<T>& vec, std::string sep = ","){
    std::stringstream ss;
    ss << "{";
    for(long long i=0; i<vec.size(); i++){
        ss << vec[i] << ( i+1 == vec.size() ? "}" : sep );
    }
    return ss.str();
}

// pair join
template<typename T, typename U> std::string join(std::pair<T, U>& pair_var, std::string sep = ",") {
    std::stringstream ss;
    ss << "(" << pair_var.first << sep << pair_var.second << ")";
    return ss.str();
}
// map join
template<typename T, typename U> std::string join (std::map<T, U>& map_var, std::string sep = ",") {
    std::stringstream ss;
    ss << "{";
    for (auto itr = map_var.begin(); itr != map_var.end(); itr++) {
        ss << "{" << itr->first << ":" << itr->second << "}";
        itr++;
        if(itr != map_var.end()) ss << sep;
        itr--;
    }
    ss << "}";
    return ss.str();
}
// set join
template<typename T> std::string join(std::set<T>& set_var, std::string sep = ",") {
    std::stringstream ss;
    ss << "{";
    for (auto itr = set_var.begin(); itr != set_var.end(); itr++) {
        ss << *itr;
        ++itr;
        if(itr != set_var.end()) ss << sep;
        itr--;
    }
    ss << "}";
    return ss.str();
}

//constant
const int INF = INT32_MAX/2;
const int MOD = 1e9+7;
const long long LINF = LONG_LONG_MAX/2;

int main(){
    using namespace std;
    
    int n;
    cin >> n;
    string s;
    cin >> s;
    vector<vector<long long>> dp(n+5, vector<long long>(n+5,0));
    vector<long long> csum(n+5);
    for(int i=0; i<n; i++){
        dp[1][i] = 1;
    }
    for(int i=2; i<n+1; i++){
        csum[0] = 0;
        for(int j=1; j<n-i+3; j++){
            csum[j] = (csum[j-1]+dp[i-1][j])%MOD;
        }
        if(s[i-1]=='<'){
            for(int j=0; j<n-i+1; j++){
                dp[i][j] = (csum[n-i+2] - csum[j+1] + MOD)%MOD;
                // for(int k=j+1; k<n-i+1; k++){
                //     dp[i][j] = (dp[i][j] + dp[i-1][k])%MOD;
                // } 
            }
        }else{
            for(int j=0; j<n-i+1; j++){
                dp[i][j] = csum[j+1];
                // for(int k=0; k<j+1; k++){
                //     dp[i][j] = (dp[i][j] + dp[i-1][k])%MOD;
                // } 
            }
        }
    }

    long long ans = dp[n][0];
    cout << ans << endl;
    return 0;
}