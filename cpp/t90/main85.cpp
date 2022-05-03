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
    
    long long k;
    cin >> k;
    vector<long long> div(0);
    for(long long i=1; i*i<=k; i++){
        if(k%i==0){
            if(i*i==k) div.push_back(i);
            else{
                div.push_back(i);
                div.push_back(k/i);
            }
        }
    }
    std::sort(div.begin(), div.end());
    // cout << join(div) << endl;
    long long count = 0;
    for(int i=0; i<div.size(); i++){
        for(int j=i; j<div.size(); j++){
            for(int l=j; l<div.size(); l++){
                long long a = div[i];
                long long b = div[j];
                long long c = div[l];
                // cout << a << b << c << endl;
                if(k < a*b*c)break;
                if(k == (a*b*c) && a<= b && b<=c){
                    count++;
                }
            }
        }
    }
    cout << count << endl;
    return 0;
}