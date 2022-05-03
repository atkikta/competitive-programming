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

int digit_sum(int x) {
	int ans = 0;
	while (x > 0) {
		ans += x % 10;
		x /= 10;
	}
	return ans;
}
std::vector<int> digit_list(int x){
    std::vector<int> ans;
    while(x>0){
        ans.push_back(x%10);
        x /= 10;
    }
    std::reverse(ans.begin(), ans.end());
    return ans;
}

int main(){
    using namespace std;
    
    int n;
    long long k;
    cin >> n >> k;
    const int mod = 100000;
    vector<int> step(mod, -1);
    int pos = n;
    int count = 0;
    while(step[pos] == -1){
        step[pos] = count;
        pos = (digit_sum(pos)+pos)%mod;
        count++;
    }
    int cycle = count - step[pos];
    if(k >= step[pos]){
        k = step[pos] + (k-step[pos])%cycle;
    }
    int ans = -1;
    for(int i=0; i<mod; i++){
        if(step[i] == k) ans = i;
    }
    cout << ans <<endl;
    return 0;
}