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
    vector<int> a(n);
    cin >> a;

    map<int , int> count;
    for(int i=0; i<n; i++){
        count[a[i]]++;
    }

    vector<int> c;
    for(auto p: count){
        c.push_back(p.second);
    }
    vector<long long>csum(c.size()+1);
    for(int i=1; i<=c.size(); i++){
        csum[i] = csum[i-1] + c[i-1];
    }
    // cout << c.size() << endl;
    // cout << join(c) << endl;
    // cout << join(csum) << endl;
    long long ans = 0;
    long long base = c[c.size()-1] * c[c.size()-2];
    for(int i=c.size()-3; i>=0; i--){
        ans += c[i] * base;
        base += c[i] * (csum[c.size()] - csum[i+1]);
        // cout << i << " " << ans << " " << base << endl;
    }
    cout << ans << endl;
    return 0;
}