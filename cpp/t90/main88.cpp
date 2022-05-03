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
using namespace std;

vector<int> a, x, y;
int n,q;

map<int, vector<int>> cards_map;
vector<int> pattern;
vector<int> ans1;
vector<int> ans2;
vector<int> c;
vector<vector<int>>g;
bool flag = false;
void dfs(int pos, int total){
    if(flag == true) return;
    if(pos == n){
        if(cards_map.find(total)!=cards_map.end()){
            flag = true;
            ans1 = cards_map[total];
            ans2 = pattern;
        }else{
            cards_map[total] = pattern;
        }
        return;
    }else{
        dfs(pos+1, total);
        if(c[pos]==0){
            pattern.push_back(pos);
            for(int i:g[pos]) c[i]++;
            dfs(pos+1, total+a[pos]);
            for(int i:g[pos]) c[i]--;
            pattern.pop_back();
        }
    }
}

int main(){
    cin >> n >> q;
    a = vector<int>(n);
    cin >> a;
    x = vector<int>(q);
    y = vector<int>(q);
    c = vector<int>(n, 0);
    g = vector<vector<int>>(n);
    for(int i=0; i<q; i++){
        cin>>x[i] >> y[i];
        x[i]--;y[i]--;
        g[x[i]].push_back(y[i]);
    }
    dfs(0, 0);
    cout << ans1.size() << endl;
    for(int i=0; i<ans1.size(); i++){
        cout << ans1[i]+1;
        if(i==ans1.size()-1){
            cout << endl;
        }else{
            cout << " ";
        }
    }
    cout << ans2.size() << endl;
    for(int i=0; i<ans2.size(); i++){
        cout << ans2[i]+1;
        if(i==ans2.size()-1){
            cout << endl;
        }else{
            cout << " ";
        }
    }

    
    return 0;
}