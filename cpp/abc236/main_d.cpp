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


using namespace std;
int n;
vector<vector<long long>> a;

vector<pair<int, int>> vec;
vector<bool>used;

int calc(){
    if(vec.size() == n){
        int ret = 0;
        for(auto p: vec){
            ret ^= a[p.first][p.second];
        }
        return ret;
    }
    int left;
    for(int i=0; i<2*n; i++){
        if(used[i]==false){
            left = i;
            used[i] = true;
            break;
        }
    }
    int ret = 0;
    for(int i=0; i<2*n; i++){
        if(used[i]==false){
            int right = i;
            used[i] = true;
            vec.push_back(make_pair(left, right));
            ret = max(ret,calc());
            vec.pop_back();
            used[i] = false;
        }
    }
    used[left] = false;
    return ret;
}


int main(){
    
    cin >> n;
    used = vector<bool>(n*2, false);
    for(int i=0; i<2*n-1; i++){
        a.push_back(vector<long long>(2*n));
    }
    for(int i=0; i<2*n-1; i++){
        for(int j=i+1; j<2*n; j++){
            cin >> a[i][j];
        }
    }

    cout << calc() << endl;

    return 0;
}