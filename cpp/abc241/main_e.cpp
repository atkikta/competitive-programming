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
    long long k;
    cin >> n >> k;
    vector<int> a(n);
    cin >> a ;

    vector<int> visited(n, -1);
    vector<long long> sum(n, -1);
    long long count = 0;
    int next = count % n;
    int t = 0;
    while(visited[next]==-1){
        visited[next] = t;
        sum[next] = count;
        count += a[next];
        next = count % n;
        t++;
        // cout << t << " " << next << " " << a[next] << endl;
        if(t>=k) break;
    }
    int cycle_len = t - visited[next];
    long long cycle_value = count - sum[next];
    count += cycle_value * ((k-t)/cycle_len);
    for(int i=0; i<(k-t)%cycle_len; i++){
        count += a[next];
        next = count % n;
    }
    cout << count << endl;
    return 0;
}