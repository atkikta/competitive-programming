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
    
    int h, w, k;
    cin >> h >> w >> k;
    vector<int> a(h);
    vector<int> b(w);
    cin >> a;
    cin >> b;

    long long lastcolsum = 0;
    for(int i=0; i<h-1; i++){
        lastcolsum += (a[i] + k - (((k-1)*(w-1))%k))%k;
    }
    long long lastrowsum = 0;
    for(int i=0; i<w-1; i++){
        lastrowsum = (b[i] + k - (((k-1)*(h-1))%k))%k;
    }
    long long colval = (a[h-1] + k - (lastrowsum%k))%k;
    long long rowval = (b[w-1] + k - (lastcolsum%k))%k;
    cout << colval << " " << rowval << endl;
    if(colval == rowval){
        long long ans = (k-1) *1LL* (h-1) * 1LL* (w-1);
        ans += lastcolsum;
        ans += lastrowsum;
        ans += colval;
        cout << ans << endl;
    }else{
        cout << -1 << endl;
    }
    
    return 0;
}