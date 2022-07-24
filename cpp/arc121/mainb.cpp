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
    vector<vector<long long>> A(3);
    for(int i=0; i<2*n; i++){
        long long a;
        char c;
        cin >> a >> c;
        if(c=='R') A[0].push_back(a);
        if(c=='G') A[1].push_back(a);
        if(c=='B') A[2].push_back(a);
    }
    if(A[0].size()%2==0 && A[1].size()%2==0 && A[2].size()%2==0){
        cout << 0 << endl;
        return 0;
    }
    if(A[0].size()%2==1){
        if(A[1].size()%2==0) swap(A[0], A[1]);
        else swap(A[0], A[2]);
    }
    std::sort(A[0].begin(), A[0].end());
    std::sort(A[1].begin(), A[1].end());
    std::sort(A[2].begin(), A[2].end());
    long long ans = LINF;
    for(int i=0; i<A[1].size(); i++){
        int idx = lower_bound(A[2].begin(), A[2].end(), A[1][i]+1) - A[2].begin();
        // cout << idx << endl;
        if(idx<A[2].size()) ans = min(ans, abs(A[1][i] - A[2][idx]));
        idx--;
        if(idx>=0) ans = min(ans, abs(A[1][i] - A[2][idx]));
    }
    long long mia = LINF;
    long long mib = LINF;
    for(int i=0; i<A[1].size(); i++){
        int idx = lower_bound(A[0].begin(), A[0].end(), A[1][i]+1) - A[0].begin();
        if(idx < A[0].size()) mia = min(mia, abs(A[0][idx] - A[1][i]));
        idx--;
        if(idx>=0) mia = min(mia, abs(A[0][idx] - A[1][i]));
    }
    for(int i=0; i<A[2].size(); i++){
        int idx = lower_bound(A[0].begin(), A[0].end(), A[2][i]+1) - A[0].begin();
        if(idx < A[0].size()) mib = min(mib, abs(A[0][idx] - A[2][i]));
        idx--;
        if(idx>=0) mib = min(mib, abs(A[0][idx] - A[2][i]));
    }

    ans = min(ans, mia + mib);
    cout << ans << endl;
    return 0;
}