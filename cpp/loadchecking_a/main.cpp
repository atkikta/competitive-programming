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
    int N = 20;
    vector<int> d = {3,9,8,5,8,10,16,14,1,6,2,11,11,8,10,13,15,8,5,8}; //887
    vector<int> e = {3,9,14,5,8,10,16,14,1,6,2,11,11,8,10,13,15,8,5,8}; //893
    vector<int> f = {3,9,20,5,8,10,16,14,1,6,2,11,11,8,10,13,15,8,5,8}; //897
    vector<int> g = {3,9,19,5,8,10,16,14,1,6,2,11,11,8,10,13,15,8,5,8}; //898
    vector<int> h = {20,9,19,5,8,10,16,14,1,6,2,11,11,8,10,13,15,8,5,8}; //881
    vector<int> j = {1,9,19,5,8,10,16,14,1,6,2,11,11,8,10,13,15,8,5,8}; //898
    vector<int> k = {2,9,19,5,8,10,16,14,1,6,2,11,11,8,10,13,15,8,5,8}; //899
    vector<int> l = {2,1,19,5,8,10,16,14,1,6,2,11,11,8,10,13,15,8,5,8}; //891
    vector<int> m = {2,20,19,5,8,10,16,14,1,6,2,11,11,8,10,13,15,8,5,8}; //910
    vector<int> n = {2,20,19,4,8,10,16,14,1,6,2,11,11,8,10,13,15,8,5,8}; //909
    vector<int> o = {2,20,19,20,8,10,16,14,1,6,2,11,11,8,10,13,15,8,5,8}; //905
    vector<int> p = {2,20,19,10,8,10,16,14,1,6,2,11,11,8,10,13,15,8,5,8}; //915
    vector<int> q = {2,20,19,10,7,10,16,14,1,6,2,11,11,8,10,13,15,8,5,8}; //914
    vector<int> r = {2,20,19,10,14,10,16,14,1,6,2,11,11,8,10,13,15,8,5,8}; //914

    for(int i=0; i<N; i++){
        cout << r[i]<< endl;
    }    
    return 0;
}