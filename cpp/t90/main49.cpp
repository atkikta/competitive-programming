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
struct UnionFind {
  std::vector<int> d;
  UnionFind(int n=0): d(n,-1) {}
  int find(int x) {
    if (d[x] < 0) return x;
    return d[x] = find(d[x]);
  }
  bool unite(int x, int y) {
    x = find(x); y = find(y);
    if (x == y) return false;
    if (d[x] > d[y]) std::swap(x,y);
    d[x] += d[y];
    d[y] = x;
    return true;
  }
  bool same(int x, int y) { return find(x) == find(y);}
  int size(int x) { return -d[find(x)];}
};

int main(){
    using namespace std;
    
    int n,m;
    cin >> n >> m;
    vector<tuple<int, int, int>> item(0);


    for(int i=0; i<m; i++){
        int c, l, r;
        cin >> c >> l >> r;
        item.push_back(make_tuple(c, l, r));
        // l[i]--;r[i]--;
    }
    std::sort(item.begin(), item.end());

    UnionFind uf(n+1);
    uf.unite(get<1>(item[0])-1, get<2>(item[0]));
    long long ans = get<0>(item[0]);
    for(int i=0; i<m; i++){
        if(uf.size(get<1>(item[0])-1)==n+1)break;
        int l = get<1>(item[i])-1;
        int r = get<2>(item[i]);
        // cout << l << " " << r << endl;
        if(!uf.same(l, r)){
            // cout << get<0>(item[i]) << endl;
            uf.unite(l, r);
            ans += get<0>(item[i]);
        }
    }
    if(uf.size(get<1>(item[0])-1)==n+1) cout << ans << endl;
    else cout << -1 << endl;
    return 0;
}