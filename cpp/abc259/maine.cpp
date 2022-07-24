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
    
    int n;
    cin >> n;
    map<int, int> maxe;
    map<int, int> maxcount;
    vector<map<int, int>> pe(n);

    for(int i=0; i<n; i++){
        pe[i] = {};
        int m;
        cin >> m;
        for(int j=0; j<m; j++){
            int p, e;
            cin >> p >> e;
            pe[i].emplace(p ,e);
            if(maxe.find(p) == maxe.end()){
                maxe[p] = e;
                maxcount[p] = 1;
            }else{
                if(maxe[p]==e){
                    maxcount[p]++;
                }else if(maxe[p] < e){
                    maxe[p] = e;
                    maxcount[p] = 1;
                }
            }
        }
    }
    int ans = 0;
    bool nochange = true;
    for(int i=0; i<n; i++){
        for(auto pa: pe[i]){
            int p = pa.first;
            int e = pa.second;
            if(maxe[p] == e && maxcount[p]==1){
                ans++;
                break;
            }
        }
    }
    if(ans < n) ans++;
    cout << ans << endl;
    return 0;
}