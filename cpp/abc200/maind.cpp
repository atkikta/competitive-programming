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
    int n;
    cin >> n;
    vector<int> a(n);
    cin >> a;
    vector<vector<int>> record(200, vector<int>(0));
    int count = min(n, 8);
    for(int i=0; i<(1<<count); i++){
        int val = 0;
        vector<int> nums;
        for(int j=0; j<8; j++){
            if(((i>>j)&1)==1){
                val = val + a[j];
                val %= 200;
                nums.push_back(j);
            }
        }
        if(record[val].size()!=0){
            cout << "Yes" << endl;
            cout << record[val].size() << " ";
            for(int k=0; k<record[val].size(); k++){
                cout << record[val][k]+1 << " ";
            }
            cout << endl;
            cout << nums.size() << " ";
            for(int k=0; k<nums.size(); k++){
                cout << nums[k]+1 << " ";
            }
            cout << endl;
            return 0;
        }
        record[val] = nums;
    }
    cout << "No" << endl;
    return 0;
}