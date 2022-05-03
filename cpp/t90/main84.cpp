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
    string s;
    cin >> s;
    vector<int> loco(0);
    vector<int> locx(0);
    for(int i=0; i<n; i++){
        if(s[i]=='o') loco.push_back(i);
        if(s[i]=='x') locx.push_back(i);
    }
    long long ans =0;
    for(int i=0; i<n; i++){
        // cout <<"i " <<i << endl;
        if(s[i]=='o'){
            int ri = lower_bound(locx.begin(), locx.end(),i) - locx.begin();
            // cout << ri << endl;
            if(ri<locx.size()){
                int right = locx[ri];
                // cout << right << endl;
                ans += n-right;
            }
        }else{
            int ri = lower_bound(loco.begin(), loco.end(), i) - loco.begin();
            // cout << ri << endl;
            if(ri < loco.size()){
                int right = loco[ri];
                // cout << right << endl;
                ans += n-right;
            }
        }
    }
    cout << ans << endl;

    return 0;
}