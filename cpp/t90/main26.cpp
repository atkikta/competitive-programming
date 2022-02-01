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
vector<vector<int>> graph;
vector<int> color;
void dfs(int node, int col){
    color[node] = col;
    for(int next: graph[node]){
        if(color[next] != -1) continue;
        if(col==0) dfs(next, 1);
        else dfs(next, 0);
    }
}
int main(){
    
    int n;
    cin >> n;
    graph = vector<vector<int>>(n);
    color = vector<int>(n,-1);
    for(int i=0; i<n-1; i++){
        int a, b;
        cin >> a >> b;
        a--;
        b--;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }
    dfs(0, 0);
    int count0 = 0;
    for(int i=0; i<n; i++){
        if(color[i]==0) count0++;
    }
    int num=0;
    int out = count0 >= n-count0 ? 0 : 1 ;
    for(int i=0; i<n; i++){
        if(num>=n/2) {
            cout << endl;
            break;
        }
        if(color[i]==out){
            cout << i+1 << " ";
            num++;
        }
    }

    
    return 0;
}