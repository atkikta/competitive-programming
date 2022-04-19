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
    
    int h,w;
    cin >> h >> w;
    vector<vector<int>> grid(h, vector<int>(w, 0));
    for(int i=0; i<h; i++){
        for(int j=0; j<w; j++){
            cin >> grid[i][j];
        }
    }
    int ans = 0;
    for(int i=0; i<(1<<h); i++){
        int nrow = 0;
        for(int j=0; j<h; j++){
            if(((i>>j)&1)==1) nrow++;
        }
        map<int, int> list;
        for(int x=0; x<w; x++){
            set<int> cat;
            for(int j=0; j<h; j++){
                if(((i>>j)&1) == 1){
                    cat.insert(grid[j][x]);
                }
            }
            if(cat.size()==1){
                list[*cat.begin()]++;
            }
        }
        int res = 0;
        for(auto it = list.begin(); it!=list.end(); it++){
            pair<int, int> kv = *it;
            res = max(res, kv.second);
        }
        ans = max(ans, nrow*res);
    }
    cout << ans << endl;
    return 0;
}