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
    
    string s, t;
    cin >> s >>t;

    vector<int> sintlen;
    vector<char> sintchar;
    vector<int> tintlen;
    vector<char> tintchar;
    
    int diff = t.size() - s.size();
    if(diff<0){
        cout << "No" << endl;
        return 0;
    }
    
    int intlen = 0;
    int intchar = '0';
    for(int i=0; i<s.size(); i++){
        if(s[i] == intchar){
            intlen++;
        }else{
            if(intlen != 0){
                sintchar.push_back(intchar);
                sintlen.push_back(intlen);
            }
            intchar = s[i];
            intlen = 1;
        }
        if(i==s.size()-1){
            sintchar.push_back(intchar);
            sintlen.push_back(intlen);
        }
    }
    intlen = 0;
    intchar = '0';
    for(int i=0; i<t.size(); i++){
        if(t[i] == intchar){
            intlen++;
        }else{
            if(intlen != 0){
                tintchar.push_back(intchar);
                tintlen.push_back(intlen);
            }
            intchar = t[i];
            intlen = 1;
        }
        if(i==t.size()-1){
            tintchar.push_back(intchar);
            tintlen.push_back(intlen);
        }
    }

    if(tintchar.size() != sintchar.size()){
        cout << "No" << endl;
        return 0;
    }else{
        bool ans = true;
        for(int i=0; i<tintchar.size(); i++){
            if(sintchar[i] != tintchar[i]) ans = false;
            if(sintlen[i]>tintlen[i]) ans = false;
            if(sintlen[i]==1 && tintlen[i]>=2) ans = false;
        }
        if(ans) cout << "Yes" << endl;
        else cout << "No" << endl;
    }
    // cout << join(sintlen) << endl;
    // cout << join(tintlen) << endl;
    return 0;
}