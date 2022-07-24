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
const int MOD = 998244353;
const long long LINF = LONG_LONG_MAX/2;

using namespace std;
vector<vector<int>> graph;
vector<vector<vector<int>>> dp;
int x, k;
void dfs(int node, int count, int is0){
    if(count == k){
        return;
    }
    for(auto next: graph[node]){
        if(next == x){
            if(is0==0){
                dp[next][count+1][1] += dp[node][count][0];
                dp[next][count+1][1] %= MOD;
                dfs(next, count+1, 1);
            }else{
                dp[next][count+1][0] += dp[node][count][1];
                dp[next][count+1][0] %= MOD;
                dfs(next, count+1, 0);
            }
        }else{
            if(is0==0){
                dp[next][count+1][0] += dp[node][count][0];
                dp[next][count+1][0] %= MOD;
                dfs(next, count+1, 0);
            }else{
                dp[next][count+1][1] += dp[node][count][1];
                dp[next][count+1][1] %= MOD;
                dfs(next, count+1, 1);
            }
        }
    }
}

int main(){
    
    int n, m, s, t;
    cin >> n >> m >> k >> s >> t >>x;
    s--; t--; x--;
    graph = vector<vector<int>>(n);
    for(int i=0; i<m; i++){
        int u, v;
        cin >> u >> v;
        u--;v--;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    dp = vector<vector<vector<int>>>(n, vector<vector<int>>(k+1, vector<int>(2, 0)));
    dp[s][0][0] = 1;
    dp[s][0][1] = 0;
    for(int i=0; i<k; i++){
        for(int node=0; node<n; node++){
            for(auto next: graph[node]){
                if(next==x){
                    dp[next][i+1][1] += dp[node][i][0];
                    dp[next][i+1][1] %= MOD;
                    dp[next][i+1][0] += dp[node][i][1];
                    dp[next][i+1][0] %= MOD;
                }else{
                    dp[next][i+1][0] += dp[node][i][0];
                    dp[next][i+1][0] %= MOD;
                    dp[next][i+1][1] += dp[node][i][1];
                    dp[next][i+1][1] %= MOD;
                }
            }
        }
    }
    
    cout << dp[t][k][0] << endl;
    // cout << dp[t][k][1] << endl;

    return 0;
}