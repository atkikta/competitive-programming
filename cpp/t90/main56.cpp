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
    for(int i=0; i<vec.size(); i++){
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
    
    int n,s;
    cin >> n >> s;
    vector<int> a(n);
    vector<int> b(n);
    for(int i=0; i<n; i++){
        cin >> a[i] >> b[i];
    }
    vector<vector<bool>> dp(n+1, vector<bool>(s+1, false));
    dp[0][0] = true;
    for(int i=0; i<n; i++){
        for(int j=0; j<=s; j++){
            if(dp[i][j]) {
                if(j+a[i] <= s) dp[i+1][j+a[i]] = true;
                if(j+b[i] <= s) dp[i+1][j+b[i]] = true;
            }
        }
    } 
    vector<char> ans(n);
    if(dp[n][s]==false){
        cout << "Impossible" << endl;
    }else{
        int val = s;
        for(int i=n; i>=1; i--){
            if(val-a[i-1]>=0 && dp[i-1][val-a[i-1]]){
                ans[i-1] = 'A';
                val -= a[i-1];
            }else{
                ans[i-1] = 'B';
                val -= b[i-1];
            }
        }
        for(int i=0; i<n; i++){
            cout << ans[i];
        }
        cout << endl;
    }
    return 0;
}