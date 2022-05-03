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
    
    int q;
    cin >> q;
    multiset<long long> set;
    for(int i=0; i<q; i++){
        int t;
        cin >> t;
        if(t==1){
            long long x;
            cin >> x;
            set.insert(x);
        }else if(t==2){
            
            long long x;
            int k;
            cin >> x >> k;
            auto pos = set.upper_bound(x);
            int count = 0;
            bool isok = true;
            while(pos!=set.begin()){
                pos--;
                count++;
                if(count == k){
                    cout << *pos << endl;
                    isok = false;
                    break;
                } 
            }
            if(isok) cout << -1 << endl;
        }else{
            long long x;
            int k;
            cin >> x >> k;
            auto pos = set.lower_bound(x);
            // cout << "pos:" << *pos<< flush;
            int count = 0;
            bool isok = true;
            while(pos!=set.end()){
                if(count == k-1){
                    cout << *pos << endl;
                    isok = false;
                    break;
                } 
                pos++;
                count++;
            }
            if(isok) cout << -1 << endl;
        }
    }
    
    return 0;
}