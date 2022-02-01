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
    vector<int> p(n);
    vector<int> q(n);
    cin >> p;
    cin >> q;
    vector<int> pos(n+1);
    for(int i=0; i<n; i++){
        pos[q[i]] = i;
    }
    // cout << join(pos) << endl;
    vector<int> z(n, INF);
    for(int i=0; i<n; i++){
        int pi = p[i];
        vector<int> li(0);
        for(int j=pi; j<n+1; j+=pi){
            li.push_back(pos[j]);
        }
        std::sort(li.begin(), li.end(), greater<int>());
        // cout << join(li) << endl;
        for(int j: li){
            z[distance(z.begin(), lower_bound(z.begin(), z.end(), j))] = j;
        }
    }
    // cout << join(z) << endl;
    cout << distance(z.begin(), lower_bound(z.begin(), z.end(), INF));
    
    return 0;
}