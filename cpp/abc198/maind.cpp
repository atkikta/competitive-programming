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


int main(){
    
    string s1, s2 ,s3;
    cin >> s1 >> s2 >> s3;

    set<char> used;
    for(int i=0; i<s1.size(); i++){
        used.emplace(s1[i]);
    }
    for(int i=0; i<s2.size(); i++){
        used.emplace(s2[i]);
    }
    for(int i=0; i<s3.size(); i++){
        used.emplace(s3[i]);
    }
    if(used.size()>10){
        cout << "UNSOLVABLE" << endl;
        return 0;
    }
    map<char, int> cidx;
    vector<int> digits={0,1,2,3,4,5,6,7,8,9};
    int idx = 0;
    for(auto p:used){
        cidx.emplace(p, idx);
        idx++;
    }
    while(next_permutation(digits.begin(), digits.end())){
        long long n1=0;
        long long n2=0;
        long long n3=0;
        if(digits[cidx[s1[0]]]==0)continue;
        if(digits[cidx[s2[0]]]==0)continue;
        if(digits[cidx[s3[0]]]==0)continue;
        for(int i=0; i<s1.size(); i++){
            n1 = n1*10 + digits[cidx[s1[i]]];
        }
        for(int i=0; i<s2.size(); i++){
            n2 = n2*10 + digits[cidx[s2[i]]];
        }
        for(int i=0; i<s3.size(); i++){
            n3 = n3*10 + digits[cidx[s3[i]]];
        }
        // cout << join(digits) << endl;
        // cout << n1 << " " << n2 << " " << n3 << endl;
        if(n1 + n2 == n3){
            cout << n1 << endl;
            cout << n2 << endl;
            cout << n3 << endl;
            return 0;
        }
    }
    cout << "UNSOLVABLE" << endl;
    return 0;
}