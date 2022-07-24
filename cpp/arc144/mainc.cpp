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
using namespace std;

int n, k;
vector<int> used_at;
bool found = false;
void dfs(int pos, int val){
    if(used_at[val] != -1){
        return;
    }
    if(abs((pos+1)-val)<k){
        return;
    }
    if(found) return;
    used_at[val] = pos;
    if(pos==n-1){
        // cout<< "found" << endl;
        found = true;
        vector<int> ans(n, -1);
        for(int i=1; i<=n; i++){
            ans[used_at[i]] = i;
        }
        for(int i=0; i<n; i++){
            cout << ans[i];
            if(i==n-1) cout << endl;
            else cout << " ";
        }
        return;
    }
    for(int i=1; i<=n; i++){
        dfs(pos+1, i);
    }
    used_at[val] = -1;
}

int main(){
    cin >> n >> k;
    if(n/2 < k){
        cout << -1 << endl;
        return 0;
    }
    used_at = vector<int>(n+1, -1);
    for(int i=1; i<=n; i++){
        dfs(0,i);
    }
    
    return 0;
}