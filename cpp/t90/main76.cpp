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
    vector<int> a(n);
    cin >> a;
    long long sum = 0;
    for(int i=0; i<n; i++){
        sum += a[i];
    }
    vector<int> a2(2*n);
    for(int i=0; i<n; i++){
        a2[i] = a[i];
    }
    for(int i=0; i<n; i++){
        a2[n+i] = a[i];
    }
    vector<long long> b(2*n);
    for(int i=1; i<2*n; i++){
        b[i] = b[i-1] + a2[i-1];
    }
    // cout << join(b) << endl;
    int ans = false;
    int r = 0;
    for(int l=0; l<2*n; l++){
        while(r<2*n){
            if((b[r]-b[l])*10 >= sum) break;
            r++;
        }
        //update ans
        if((b[r]-b[l])*10 == sum){
            ans = true;
        }
    }
    if(ans) cout << "Yes" << endl;
    else cout << "No" << endl;
    return 0;
}