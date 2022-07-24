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
using namespace std;
vector<int> a;
vector<vector<long long>> memo;
long long dp(int lh, int rh){
    if(memo[lh][rh]!=-1){
        return memo[lh][rh];
    }
    if(rh - lh <=2){
        return memo[lh][rh] = abs(a[lh] - a[rh-1]);
    }
    long long res = LINF;
    res = min(res, abs(a[lh] - a[rh-1]) + dp(lh+1, rh-1));
    for (int  i = lh+2; i <=rh-2; i+=2){
        res = min(res, dp(lh, i)+dp(i, rh));
    }
    return memo[lh][rh] = res;
}
int main(){
    int n;
    cin >> n;
    for (int i = 0; i <= 2*n; i++){
        memo.push_back(vector<long long>(2*n+1, -1));
    }
    
    a = vector<int>(2*n);
    cin >> a;
    long long ans = dp(0, 2*n);

    cout << ans << endl;
    
    return 0;
}