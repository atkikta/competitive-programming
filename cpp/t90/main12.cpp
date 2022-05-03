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
    int h, w;
    cin >> h >> w;
    int q;
    cin >> q;
    UnionFind uf(h*w);
    vector<int> color(h*w);
    for(int i=0; i<q; i++){
        int t;
        cin >> t;
        if(t==1){
            int r, c;
            cin >> r>> c;
            r--;
            c--;
            int center = r * w + c;
            color[center] = 1;
            if(r>0){
                int top = (r-1) *w + c;
                if(color[top]==1)uf.unite(center, top);
            }
            if(r<h-1){
                int bottom = (r+1)*w + c;
                if(color[bottom]==1)uf.unite(center, bottom);
            }
            if(c>0){
                int left = r*w+(c-1);
                if(color[left]==1)uf.unite(center, left);
            }
            if(c < w-1){
                int right = r*w + c+1;
                if(color[right]==1)uf.unite(center, right);
            }
        }else{
            int ra, ca, rb, cb;
            cin >> ra >> ca >> rb >> cb;
            ra--;
            ca--;
            rb--;
            cb--;
            int a = ra*w+ca;
            int b = rb*w+cb;
            if(color[a]==1 && color[b]==1 && uf.same(a, b)){
                cout << "Yes" << endl;
            }else{
                cout << "No" << endl;
            }
        }
    }
    
    
    return 0;
}