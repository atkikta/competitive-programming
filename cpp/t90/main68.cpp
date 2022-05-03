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
class union_find {
private:
	int N;
	vector<int> par;
public:
	union_find() : N(0), par() {}
	union_find(int N_) : N(N_) {
		par.resize(N);
		for (int i = 0; i < N; ++i) {
			par[i] = i;
		}
	}
	int root(int x) {
		if (x == par[x]) return x;
		return par[x] = root(par[x]);
	}
	void link(int x, int y) {
		par[root(x)] = root(y);
	}
	bool connected(int x, int y) {
		return root(x) == root(y);
	}
};
int main(){
    using namespace std;
    
    int n, q;
    cin >> n >> q;
    union_find uf(n);
    vector<vector<long long>> query(q, vector<long long>(4, 0));
    vector<long long> sum_next(n-1);
    vector<bool> is_feasible(q, false);
    for(int i=0; i<q; i++){
        int t, x, y;
        long long v;
        cin >> t >> x >> y >> v;
        x--;
        y--;
        if(t==0){
            query[i] = {0,x,y,v};
            uf.link(x,y);
            sum_next[x] = v;
        }else{
            query[i] = {1,x,y,v};
            if(uf.connected(x,y)){
                is_feasible[i] = true;
            }
        }
    }
    vector<long long> case0(n, 0);
    vector<long long> case1(n, 1);
    for(int i=0; i<n-1; i++){
        case0[i+1] = sum_next[i] - case0[i];
    }
    for(int i=0; i<q; i++){
        if(query[i][0]==1){
            int x = query[i][1];
            int y = query[i][2];
            long long v = query[i][3];
            if(is_feasible[i]){
                if((x+y)%2==0){
                    cout << v + (case0[y] - case0[x]) << endl;
                }else{
                    cout << -v + (case0[x] + case0[y]) << endl;
                }
            }else{
                cout << "Ambiguous" << endl;
            }
        }
    }
    
    return 0;
}