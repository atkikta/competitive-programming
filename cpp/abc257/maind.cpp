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
vector<bool>visited;
vector<vector<int>> graph;
void dfs(int node){
    visited[node] = true;
    for(auto next: graph[node]){
        if(visited[next]) continue;
        dfs(next);
    }
}
int main(){
    
    int n;
    cin >> n;
    vector<long long> x(n);
    vector<long long> y(n);
    vector<long long> p(n);
    for(int i=0; i<n; i++){
        cin >> x[i] >> y[i] >> p[i];
    }
    graph = vector<vector<int>>(n, vector<int>(0));
    visited = vector<bool>(n, false);
    long long right = 10'000'000'000;
    long long left = 0;
    while(right-left>1){
        long long mid = (right + left) /2;
        for(int i=0; i<n; i++){
            graph[i].clear();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(p[i] * mid >= abs(x[i]-x[j]) + abs(y[i]-y[j])){
                    graph[i].push_back(j);
                }
            }
        }
        bool isok = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                visited[j] = false;
            }
            dfs(i);
            bool vis = true;
            for(int j=0; j<n; j++){
                if(visited[j]==false) vis = false;
            }
            if(vis){
                isok = true;
                break;
            }
        }
        if(isok){
            right = mid;
        }else{
            left = mid;
        }
    }
    cout << right << endl;
    
    return 0;
}