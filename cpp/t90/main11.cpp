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

bool comp(const std::vector<int>& lh, const std::vector<int>& rh){
    return lh[0] < rh[0];
}
int main(){
    using namespace std;
    
    int n;
    cin >> n;
    vector<vector<int>> dcs;
    for(int i=0; i<n; i++){
        int di, ci, si;
        cin >> di >> ci >> si;
        dcs.push_back({di, ci, si});
    }
    std::sort(dcs.begin(), dcs.end(), comp);
    
    vector<vector<long long>> dp(5001, vector<long long>(n+1));
    
    for(int i=0; i<=5000; i++){
        for(int j=1; j<n+1; j++){
            auto job = dcs[j-1];
            if(job[1] <= i && i <= job[0]){
                dp[i][j] = max(dp[i][j-1], dp[i-job[1]][j-1] + job[2]);
            }else{
                dp[i][j] = max(dp[i][j-1], dp[i][j]);
            }
        }
    }
    long long ans = 0;
    for(int i=0; i<=5000; i++){
        ans = max(ans, dp[i][n]);
    }
    cout << ans << endl;
    return 0;
}