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
    
    int n;
    cin >> n;
    vector<vector<int>>grid(1002, vector<int>(1002));
    for(int i=0; i<n; i++){
        int lx, ly, rx, ry;
        cin >> lx >> ly >> rx >> ry;
        grid[lx][ly]++;
        grid[lx][ry]--;
        grid[rx][ly]--;
        grid[rx][ry]++;
    }
    for(int i=1; i<1001; i++){
        for(int j=0; j<1001; j++){
            grid[i][j] = grid[i][j] + grid[i-1][j];
        }
    }
    for(int j=1; j<1001; j++){
        for(int i=0; i<1001; i++){
            grid[i][j] = grid[i][j] + grid[i][j-1];
        }
    }
    vector<int> ans(n+1);
    for(int i=0; i<1001; i++){
        for(int j=0; j<1001; j++){
            if(grid[i][j] > 0) ans[grid[i][j]]++;
        }
    }
    for(int i=1; i<=n; i++){
        cout << ans[i] << endl;
    }

    return 0;
}