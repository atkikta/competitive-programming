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
using namespace std;

vector<vector<int>> a;
long long n, p, k;
int count_pair(long long x){
    vector<vector<long long>> distance(n, vector<long long>(n));
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(a[i][j]!=-1)distance[i][j] = a[i][j];
            else distance[i][j] = x;
        }
    }
    for(int k=0; k<n; k++){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(distance[i][j] > distance[i][k] + distance[k][j]){
                    distance[i][j] = distance[i][k] + distance[k][j];
                }
            }
        }
    }
    int count = 0;
    for(int i=0; i<n; i++){
        for(int j=i+1; j<n; j++){
            if(distance[i][j]<=p) count++;
        }
    }
    return count;
}
int main(){
    cin >> n >> p >> k;
    for(int i=0; i<n; i++){
        a.push_back(vector<int>(n));
    }
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin >> a[i][j];
        }
    }
    long long llb = 1;
    long long rlb = 5000000000LL;
    long long l = rlb;
    for(int i=0; i<40; i++){
        long long mlb = (llb+rlb)/2;
        int count = count_pair(mlb);
        if(count<=k) { rlb = mlb; l = min(l, mlb); }
        else llb = mlb;
    }
    long long lub = 1;
    long long rub = 5000000000LL;
    long long r = rub;
    for(int i=0; i<40; i++){
        long long mub = (lub+rub)/2;
        if(count_pair(mub)<=k-1) { rub = mub; r = min(r, mub); }
        else lub = mub;
    }
    // for(int i=0; i<=p+1; i++){
    //     cout << i << " " << count_pair(i) << endl;
    // }
    if(r - l >= 2000000000LL){
        cout << "Infinity" << endl;
    }else{
        cout << r - l<< endl;
    }
    return 0;
}