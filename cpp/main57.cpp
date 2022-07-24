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

int main(){
    using namespace std;
    
    int n, m;
    cin >> n >> m;
    vector<vector<int>> D(n, vector<int>(m, 0));
    for(int i=0; i<n; i++){
        int t, x;
        cin >> t;
        for(int j=0; j<t; j++){
            cin >> x;
            D[i][x-1] = 1;
        }
    }
    vector<int> S(m);
    cin >> S;
    // cout << join(S) << endl;
    int rowpos = 0;
    for(int i=0; i<m; i++){
        bool found = false;
        for(int j=rowpos; j<n; j++){
            if(D[j][i] == 1){
                if(j!=rowpos){
                    swap(D[rowpos], D[j]);
                }
                found = true;
                break;
            }
        }
        if(found){
            for(int j=0; j<n; j++){
                if(j!=rowpos && D[j][i]==1){
                    for(int k=i; k<m; k++){
                        D[j][k] ^= D[rowpos][k];
                    }
                }
            }
            if(S[i]==1){
                for(int j=i; j<m; j++){
                    S[j] ^= D[rowpos][j];
                }
            }
            rowpos++;
        }
    }
    if(S == vector<int>(m,0)){
        int ans = 1;
        for(int i=rowpos; i<n; i++){
            ans = ans * 2 % 998244353;
        }
        cout << ans << endl;
    }else {
        cout << 0 << endl;
    }
    
    return 0;
}