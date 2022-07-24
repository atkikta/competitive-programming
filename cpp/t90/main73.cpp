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
vector<char> c;
vector<vector<long long>> dp;
vector<vector<int>> graph;
void dfs(int node, int prev){
    long long val1 = 1, val2 = 1;
    for(int next:graph[node]){
        if(next != prev){
            dfs(next, node);
            if(c[node]=='a'){
                val1 *= (dp[next][0] + dp[next][2]);
                val2 *= (dp[next][0] + dp[next][1] + 2LL*dp[next][2]);
            }
            if(c[node]=='b'){
                val1 *= (dp[next][1] + dp[next][2]);
                val2 *= (dp[next][0] + dp[next][1] + 2LL*dp[next][2]);
            }
            val1 %= MOD;
            val2 %= MOD;
        }
    }
    if(c[node]=='a'){
        dp[node][0] = val1;
        dp[node][2] = (val2-val1+MOD)%MOD;
    }
    if(c[node]=='b'){
        dp[node][1] = val1;
        dp[node][2] = (val2-val1+MOD)%MOD;
    }
}

int main(){
    
    int n;
    cin >> n;
    dp = vector<vector<long long>>();
    for(int i=0; i<n; i++){
        dp.push_back(vector<long long>(3));
    }
    c = vector<char>(n);
    cin >> c;
    graph = vector<vector<int>>();
    for(int i=0; i<n; i++){
        graph.push_back(vector<int>(0));
    }
    for(int i=0; i<n-1; i++){
        int a, b;
        cin >> a >> b;
        a--;b--;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    dfs(0, -1);
    cout << dp[0][2] << endl;
    return 0;
}