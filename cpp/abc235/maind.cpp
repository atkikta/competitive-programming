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
    
    long long a,n;
    cin >> a >> n;
    vector<long long> count(n*10+1, LINF);
    count[1] = 0;
    queue<long long> cand;
    cand.push(1);
    while(cand.size()>0){
        long long i= cand.front();
        // cout << i << endl;
        cand.pop();
        if(i*a <= n*10){
            if(count[i*a]==LINF){
                count[i*a] = count[i] + 1;
                cand.push(i*a);
            }
        }
        if(i>=10 && i%10!=0){
            string s = to_string(i);
            long long dn = 1;
            for(int ii=0; ii<s.size()-1; ii++){
                dn *= 10;
            }
            long long head = i / dn;
            long long tail = i % 10;
            long long rot = tail*dn + i/10;
            if(rot <= n*10) {
                if(count[rot]==LINF) {
                    count[rot] = count[i]+1;
                    cand.push(rot);
                }
            }
        }

    }
    if(count[n]==LINF) cout << -1 << endl;
    else cout << count[n] << endl;
    return 0;
}