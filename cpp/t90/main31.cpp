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
    vector<int> w(n);
    vector<int> b(n);
    cin >> w;
    cin >> b;

    vector<vector<int>> grundy(51, vector<int>(1550, 0));
    grundy[0][0] = 0;
    grundy[0][1] = 0;
    for(int i=0; i<51; i++){
        for(int j=0; j<1500; j++){
            vector<int> mex(1550);
            if(i>=1)mex[grundy[i-1][j+i]] = 1;
            if(j>=2){
                for(int k=1; k<=j/2; k++){
                    mex[grundy[i][j-k]] = 1;
                }
            }
            for(int l=0; l<1550; l++){
                if(mex[l]==0){
                    grundy[i][j] = l;
                    break;
                }
            }
        }
    }

    int sumxor = 0;
    for(int i=0; i<n; i++){
        sumxor ^= grundy[w[i]][b[i]];
    }
    if(sumxor==0){
        cout << "Second" << endl;
    }else{
        cout << "First" << endl;
    }
    
    return 0;
}