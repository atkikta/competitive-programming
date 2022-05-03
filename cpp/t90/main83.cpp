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
    
    int n, m;
    cin >> n >> m;
    vector<vector<int>> graph(n, vector<int>());
    for(int i=0; i<m; i++){
        int a, b;
        cin >> a >> b;
        a--;b--;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }
    vector<bool> isbig(n, false);
    vector<vector<int>> nei_big(n,vector<int>());
    for(int i=0; i<n; i++){
        if(graph[i].size() > sqrt(2*m)) {
            isbig[i] =true;
        }
    }
    for(int i=0; i<n; i++){
        for(int nei:graph[i]){
            if(isbig[nei]) nei_big[i].push_back(nei);
        }
    }
    vector<int> last(n, -1);
    vector<int> last_big(n, -1);
    int q;
    cin >> q;
    vector<pair<int, int>> query(0);
    for(int i=0; i<q; i++){
        int x,y;
        cin >> x >> y;
        x--;
        query.push_back(make_pair(x, y));
    }
    vector<int> color(n, 1);
    for(int i=0; i<q; i++){
        int x = query[i].first;
        int y = query[i].second;
        int la = last[x];
        for(int nb:nei_big[x]){
            la = max(la, last_big[nb]);
        }
        if(la == -1){
            cout << 1 << endl;
        }else {
            cout << query[la].second << endl;
        }
        if(isbig[x]){
            last_big[x] = i;
        }else{
            for(int nei: graph[x]){
                last[nei] = i;
            }
        }
        last[x] = i;
    }
    return 0;
}