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
vector<vector<int>> grid;
int h,w;
vector<int> dx = {1, 0, -1, 0};
vector<int> dy = {0, 1, 0, -1};
int step(int i, int j, int len, int si, int sj){
    // cout << i << ", " << j << ", "  << len<< endl;    
    // for(int i=0; i<h; i++){
    //     cout << join(grid[i]) << endl;
    // }
    if(len!=0&&i==si&&j==sj) return len;
    if(grid[i][j]==1) return -1;
    grid[i][j] = 1;
    int ret = 0;
    for(int d=0; d<4; d++){
        int ni = i+dx[d];
        int nj = j+dy[d];  
        if(ni>=0&&ni<h&&nj>=0&&nj<w){
            ret = max(ret, step(ni, nj, len+1, si, sj));
        }
    }
    grid[i][j] = 0;
    return ret;
}
int main(){
    
    cin >> h >> w;
    for(int i=0; i<h; i++){
        grid.push_back(vector<int>(w, 0));        
    }
    for(int i=0; i<h; i++){
        string s;
        cin >> s;
        for(int j=0; j<w; j++){
            if(s[j]=='#') grid[i][j] = 1;
        }
    }

    int ans = 0;
    for(int i=0; i<h; i++){
        for(int j=0; j<w; j++){
            if(grid[i][j]==1) continue;
            ans = max(ans, step(i, j, 0, i, j));
        }
    }
    if(ans < 3) cout << -1 << endl;
    else cout << ans << endl;
    return 0;
}