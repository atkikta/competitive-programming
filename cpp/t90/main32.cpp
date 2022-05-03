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
    vector<vector<int>> a(n+1, vector<int>(n+1));
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin >> a[i][j];
        }
    }
    int m;
    cin >> m;
    vector<vector<int>> rel(n+1, vector<int>(n+1,false));
    for(int i=0; i<m; i++){
        int x,y;
        cin >> x >> y;
        rel[x-1][y-1] = true;
        rel[y-1][x-1] = true;
    }
    vector<int> order;
    for(int i=0; i<n; i++){
        order.push_back(i);
    }
    int ans = INF;
    do{
        bool isok = true;
        for(int i=0; i<n-1; i++){
            if(rel[order[i]][order[i+1]]==true) isok = false;
        }
        int sum=0;
        for(int i=0; i<n; i++){
            sum += a[order[i]][i];
        }
        if(isok) ans = min(ans, sum);
    }while(next_permutation(order.begin(),order.end()));
    if(ans == INF) ans = -1;
    cout << ans << endl;

    return 0;
}