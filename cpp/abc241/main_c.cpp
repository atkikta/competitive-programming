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
    vector<vector<int>> grid(n, vector<int>(n, 0));
    for(int i=0; i<n; i++){
        string s;
        cin >> s;
        for(int j=0; j<n; j++){
            if(s[j]=='#') grid[i][j] = 1;
        }
    }
    for(int left=0; left<n-5; left++){
        for(int upper=0; upper<n-5; upper++){
            // cout << left << "," << upper << endl;
            vector<vector<int>> sg(6, vector<int>(6, 0));
            for(int i=0; i<6; i++){
                for(int j=0; j<6; j++){
                    sg[i][j] = grid[left+i][upper+j];
                }
            }
            bool isok = false;
            for(int i=0; i<6; i++){
                int rc = 0;
                for(int j=0; j<6; j++){
                    if(sg[i][j]==1)rc++;
                }
                if(rc>=4) isok=true;
            }
            for(int j=0; j<6; j++){
                int cc = 0;
                for(int i=0; i<6; i++){
                    if(sg[i][j]==1) cc++;
                }
                if(cc>=4) isok=true;
            }
            int ac = 0;
            for(int i=0; i<6; i++){
                if(sg[5-i][i]==1) ac++;
            }
            if(ac>=4) isok=true;
            int dc = 0;
            for(int i=0; i<6; i++){
                if(sg[i][i]==1) dc++;
            }
            if(dc>=4) isok=true;

            if(isok){
                cout<<"Yes"<<endl;
                return 0;
            }
        }
    }
    cout << "No" << endl;
    return 0;
}