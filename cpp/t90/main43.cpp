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
std::vector<int> dx = {1, 0, -1, 0};
std::vector<int> dy = {0, -1, 0, 1};

struct state{
    int dist, row, col, dir;
};
int main(){
    using namespace std;
    
    int h, w;
    cin >> h >> w;
    int rs, cs, rt, ct;
    cin >> rs >> cs >> rt >> ct;
    rs--;
    cs--;
    rt--;
    ct--;
    vector<vector<int>> grid(h, vector<int>(w, 0));
    for(int i=0; i<h; i++){
        string s;
        cin >> s;
        for(int j=0; j<w; j++){
            if(s[j] == '#') grid[i][j] = 1;
        }
    }
    vector<vector<vector<int>>> dist(h, vector<vector<int>>(w, vector<int>(4,INF)));
    for(int i=0; i<4; i++){
        dist[rs][cs][i] = 0;   
    }
    deque<state> que = {};
    que.push_back({0, rs, cs, 0});
    que.push_back({0, rs, cs, 1});
    que.push_back({0, rs, cs, 2});
    que.push_back({0, rs, cs, 3});
    while(que.size()>0){
        state current = que.front();
        que.pop_front();
        // cout << current.dist << " " << current.row << " " << current.col << " " << current.dir << endl;
        for(int i=0; i<4; i++){
            int ny = current.row + dy[i];
            int nx = current.col + dx[i];
            // cout << nx << " " << ny << endl;
            if(0<=nx && nx<=w-1 && 0<=ny && ny<=h-1 && grid[ny][nx]==0){
                int nextdist = (current.dir==i) ? current.dist : current.dist+1;
                // cout << nextdist << endl;
                if(dist[ny][nx][i] > nextdist){
                    dist[ny][nx][i] = nextdist;
                    if(current.dir==i) que.push_front({nextdist, ny, nx, i});
                    else que.push_back({nextdist, ny, nx, i});
                }
            }
        }
    }
    int ans = INF;
    for(int i=0; i<4; i++){
        ans = min(ans, dist[rt][ct][i]);
    }
    cout << ans << endl;
    return 0;
}