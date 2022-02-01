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

int main(){
    using namespace std;
    
    int n;
    cin >> n;
    vector<int> c;
    vector<int> p;
    vector<int> csum1(n+1);
    vector<int> csum2(n+1);
    for(int i=0; i<n; i++){
        int ci, pi;
        cin >> ci >> pi;
        c.push_back(ci);
        p.push_back(pi);
    }
    for(int i=0; i<n; i++){
        if(c[i]==1) {
            csum1[i+1] = csum1[i] + p[i];
        }else{
            csum1[i+1] = csum1[i];
        }
        if(c[i]==2) {
            csum2[i+1] = csum2[i] + p[i];
        }else{
            csum2[i+1] = csum2[i];
        }
    }
    // cout << join(csum1) << endl;
    // cout << join(csum2) << endl;

    int q;
    cin >> q;
    for(int i=0; i<q; i++){
        int l, r;
        cin >> l >> r;
        l--;
        r--;
        cout << csum1[r+1] - csum1[l] << " " << csum2[r+1] - csum2[l] << endl;
    } 
    return 0;
}