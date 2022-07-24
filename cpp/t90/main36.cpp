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
    
    int n, q;
    cin >> n >> q;

    vector<long long> X(0);
    vector<long long> Y(0);
    long long max_x = -LINF;
    long long min_x = LINF;
    long long max_y = -LINF;
    long long min_y = LINF;
    for(int i=0; i<n; i++){
        long long x, y;
        cin >> x >> y;
        X.push_back(x+y);
        Y.push_back(x-y);
        max_x = max(max_x, x+y);
        min_x = min(min_x, x+y);
        max_y = max(max_y, x-y);
        min_y = min(min_y, x-y);
    }
    
    for(int i=0; i<q; i++){
        int q;
        cin >> q;
        q--;
        long long a1 = abs(max_x - X[q]);
        long long a2 = abs(min_x - X[q]);
        long long a3 = abs(max_y - Y[q]);
        long long a4 = abs(min_y - Y[q]);
        long long ans = max({a1, a2, a3, a4});
        cout << ans << endl;
    }

    return 0;
}