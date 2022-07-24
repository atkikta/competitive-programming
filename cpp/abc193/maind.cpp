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
    
    int k;
    cin >> k;
    string s, t;
    cin >> s >> t;
    vector<int> count(10, k);
    vector<int> s_count(10, 0);
    vector<int> t_count(10, 0);
    vector<int> tens = {1, 10, 100, 1000, 10000, 100000};
    for(int i=0; i<4; i++){
        int si = s[i] - '0';
        count[si]--;
        s_count[si]++;
        int ti = t[i] - '0';
        count[ti]--;
        t_count[ti]++;
    }
    // cout << join(s_count) << endl;
    // cout << join(t_count) << endl;
    // cout << join(count) << endl;
    double ans = 0;
    for(int i=1; i<=9; i++){
        for(int j=1; j<=9; j++){
            if(count[i]==0)continue;
            if(count[j]==0)continue;
            s_count[i]++;
            t_count[j]++;
            int s_score=0;
            int t_score=0;
            for(int m=1; m<=9; m++){
                s_score += m*tens[s_count[m]];
                t_score += m*tens[t_count[m]];
            }
            double prob;
            if(i!=j)prob = ((double)(count[i])*(double)(count[j]))/((double)(9*k-8)*(double)(9*k-9));
            else prob = ((double)(count[i])*(double)(count[i]-1))/((double)(9*k-8)*(double)(9*k-9));
            if(s_score>t_score) ans += prob;
            s_count[i]--;
            t_count[j]--;
        }
    }
    cout << ans << endl;
    return 0;
}