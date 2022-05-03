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
    
    int n;
    cin >> n;
    vector<int> a(n);
    vector<int> b(n);
    cin >> a;
    cin >> b;

    for(int i=n-1; i>=3; i--){
        int tarb = b[i];
        // cout << "tarb:" << tarb << endl;
        int pos = -1;
        for(int j=0; j<=i; j++){
            if(a[j] == tarb) pos = j;
        }
        if(pos == -1) {
            cout << "No" << endl;
            return 0;
        }else if(pos == i){
            continue;
        }else if(pos+1 == i){
            int x = a[pos-1];
            int y = a[pos];
            int z = a[pos+1];
            a[pos-1] = z;
            a[pos] = x;
            a[pos+1] = y; 
        }else{
            while(a[i] != tarb){
                int x = a[pos];
                int y = a[pos+1];
                int z = a[pos+2];
                a[pos] = z;
                a[pos+1] = x;
                a[pos+2] = y; 
                if(pos<i-2)pos++;
                // cout << join(a) << endl;
            }
        }
    }
    if(
        (a[0] == b[0] && a[1] == b[1] && a[2] == b[2])||
        (a[0] == b[1] && a[1] == b[2] && a[2] == b[0])||
        (a[0] == b[2] && a[1] == b[0] && a[2] == b[1])
    ) cout << "Yes" << endl;
    else cout << "No" << endl;

    return 0;
}