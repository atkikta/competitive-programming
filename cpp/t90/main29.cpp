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
class SegmentTree {
private:
    int n;
    vector<int> node;
    vector<int> lazy;
    vector<bool> lazy_flag;
public:
    SegmentTree(vector<int> vec) {
        int sz = vec.size();
        n = 1; while(n<sz) n*=2;
        node.resize(2*n-1, 0);
        lazy.resize(2*n-1, 0);
        lazy_flag.resize(2*n-1, false);
        for(int i=0; i<sz; i++){
            node[i+n-1] = vec[i];
        }
        for(int i=n-2; i>=0; i--){
            node[i] = max(node[i*2+1], node[i*2+2]);
        }
    }
    SegmentTree(int sz)
        :SegmentTree(vector<int>(sz, 0)){}
    
    // 要求区間 [a, b) 中の要素の最小値を答える
    // k := 自分がいるノードのインデックス
    // 対象区間は [l, r) にあたる
    int range_max(int a, int b, int k=0, int l=0, int r=-1) {
        if(r<0) r = n;
        lazy_evaluate(k, l, r);
        //交わらない場合
        if(r<=a||b<=l) return 0;
        //包含する場合
        if(a<=l&&r<=b) return node[k];
        //それ以外の場合
        return max(
            range_max(a, b, 2*k+1, l, (l+r)/2),
            range_max(a, b, 2*k+2, (l+r)/2, r)
        );
    }
    // 要求区間 [a, b) の要素をxに更新する
    // k := 自分がいるノードのインデックス
    // 対象区間は [l, r) にあたる
    void update(int a, int b, int x, int k=0, int l=0, int r=-1) {
        if(r<0) r = n;
        lazy_evaluate(k, l, r);
        if( r<=a || b<=l ) return;
        if( a<=l && r<=b ){
            lazy[k] = x;
            lazy_flag[k] = true;
            lazy_evaluate(k, l, r);
        }else{
            update(a ,b, x, 2*k+1, l, (l+r)/2);
            update(a ,b, x, 2*k+2, (l+r)/2, r);
            node[k] = max(node[2*k+1], node[2*k+2]);
        }
    }
private:
    void lazy_evaluate(int k, int l, int r){
        if(lazy_flag[k]){
            node[k] = lazy[k];
            if(r-l>1){
                lazy[2*k+1] = lazy[k];
                lazy[2*k+2] = lazy[k];
                lazy_flag[2*k+1] = true;
                lazy_flag[2*k+2] = true;
            }
            lazy_flag[k] = false;
        }
    }
};

int main(){
    int w, n;
    cin >> w >> n;
    SegmentTree sgt(w);
    for(int i=0; i<n; i++){
        int l, r;
        cin >> l >> r;
        l--;r--;
        int hight = sgt.range_max(l, r+1);
        cout << hight+1 << endl;
        sgt.update(l, r+1, hight+1);
    }
    
    
    return 0;
}