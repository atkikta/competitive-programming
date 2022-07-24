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
class SegmentTree {
public:
    int n;
    vector<long long> node;
    vector<long long> lazy;
    vector<bool> lazy_flag;
public:
    SegmentTree(vector<long long> vec) {
        int sz = vec.size();
        n = 1; while(n<sz) n*=2;
        node.resize(2*n-1, -LINF);
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
        :SegmentTree(vector<long long>(sz, 0)){}

    // 要求区間 [a, b) 中の要素の最小値を答える
    // k := 自分がいるノードのインデックス
    // 対象区間は [l, r) にあたる
    long long range_max(int a, int b, int k=0, int l=0, int r=-1) {
        if(r<0) r = n;
        lazy_evaluate(k, l, r);
        //交わらない場合
        if(r<=a||b<=l) return -LINF;
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
    void update(int a, int b, long long x, int k=0, int l=0, int r=-1) {
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
    using namespace std;
    
    int w, n;
    cin >> w >> n;
    vector<int> l(n);
    vector<int> r(n);
    vector<long long> v(n);
    for(int i=0; i<n; i++){
        cin >> l[i] >> r[i] >> v[i];
    }
    // cout << join(v) << endl;
    vector<long long> dp(w+1, -1);
    // for(int i=l[0]; i<=r[0]; i++){
    //     dp[i] = v[0];
    // }
    dp[0] = 0;
    // cout << join(dp) << endl;
    for(int i=0; i<n; i++){
        SegmentTree sgt(dp);
        // cout << join(sgt.node) << endl;
        // cout << sgt.range_max(3,5) << endl;
        for(int j=0; j<=w; j++){
            if(j-l[i] < 0) continue;
            int left = max(0, j-r[i]);
            int right = max(0, j-l[i]);
            long long maxval = sgt.range_max(left, right+1);
            // cout <<  i << " " << j << " " << left << " " << right << " "<< maxval << endl;
            if(maxval>=0){
                dp[j] = max(dp[j], maxval+v[i]);
            }
        }
        // cout << join(dp) << endl;
        // cout << join(sgt.node) << endl;
    }
    cout << dp[w] << endl;
    return 0;
}