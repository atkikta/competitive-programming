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
    
    int n, k;
    long long p;
    cin >> n >> k >> p;
    vector<long long> a(n);
    cin >> a;
    vector<long long> half_count1[100];
    vector<long long> half_count2[100];
    int mid = n/2;
    for(int i=0; i<(1<<mid); i++){
        long long popc = 0, valc = 0;
        for(int j=0; j<mid; j++){
            if((i & (1 << j)) != 0){
                popc++;
                valc += a[j];
            }
        }
        half_count1[popc].push_back(valc);
    }
    for(int i=0; i<(1<<(n-mid)); i++){
        long long popc=0, valc=0;
        for(int j=0; j<n-mid; j++){
            if((i & (1 << j)) != 0){
                popc++;
                valc+=a[mid+j];
            }
        }
        half_count2[popc].push_back(valc);
    }

    for(int i=0; i<=n; i++){
        std::sort(half_count1[i].begin(), half_count1[i].end());
        std::sort(half_count2[i].begin(), half_count2[i].end());
    }
    long long ans = 0;
    for(int h=0; h<=k; h++){
        for(int i=0; i<half_count1[h].size(); i++){
            int pos = lower_bound(half_count2[k-h].begin(), half_count2[k-h].end(), p-half_count1[h][i]+1) - half_count2[k-h].begin(); 
            ans += pos;
        }
    }
    cout << ans << endl;
    return 0;
}