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
    
    int n;
    long long sx, sy, tx, ty;
    cin >> n;
    cin >> sx >> sy >> tx >> ty;
    vector<long long> x(n);
    vector<long long> y(n);
    vector<long long> r(n);
    for(int i=0; i<n; i++){
        cin >> x[i] >> y[i] >> r[i];
    }

    int si = -1;
    int ti = -1;
    for(int i=0; i<n; i++){
        if((sx-x[i])*(sx-x[i]) + (sy-y[i])*(sy-y[i]) == r[i] * r[i]){
            si = i;
            break;
        }
    }
    for(int i=0; i<n; i++){
        if((tx-x[i])*(tx-x[i]) + (ty-y[i])*(ty-y[i]) == r[i] * r[i]){
            ti = i;
            break;
        }
    }
    UnionFind uf(n);
    for(int i=0; i<n; i++){
        for(int j=i+1; j<n; j++){
            long long d = (x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]);
            if(r[i]*r[i] - 2* r[i]*r[j] + r[j]*r[j]<= d && d <= r[i]*r[i] + 2* r[i]*r[j] + r[j]*r[j]){
                uf.unite(i, j);
            }
        }
    }
    if(uf.same(si, ti)){
        cout << "Yes" << endl;
    }else{
        cout << "No" << endl;
    }
    return 0;
}