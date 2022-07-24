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
struct Edge{
    int from;
    int to;
    int cost;
    int k;
    Edge(int from, int to, int cost, int k): 
        from(from), to(to), cost(cost), k(k){}
};
struct DiGraph{
    int num_node;
    std::vector<std::vector<Edge>> edges;
    std::vector<std::vector<Edge>> reverse_edges;
    DiGraph(int size){
        num_node = size;
        edges = std::vector<std::vector<Edge>>(size);
        reverse_edges = std::vector<std::vector<Edge>>(size);
    }
    void addEdge(int from, int to, int cost, int k){
        edges.at(from).push_back(Edge(from, to, cost, k));
        reverse_edges.at(to).push_back(Edge(to, from, cost, k));
    }
    std::vector<long long> dijkstra(int start_node){
        std::vector<long long> distance(num_node, LONG_LONG_MAX/2);
        std::priority_queue<std::pair<long long, int>, std::vector<std::pair<long long, int>>, std::greater<std::pair<long long, int>>> que;
        distance[start_node] = 0;
        que.push(std::make_pair(0, start_node));
        while(!que.empty()){
            long long time = que.top().first;
            int pos = que.top().second; que.pop();
            if(distance[pos]<time) continue;
            for(Edge e:edges[pos]){
                long long leavetime = ((distance[pos]-1)/e.k + 1) * e.k;
                if(time==0) leavetime = 0;
                if(distance[e.to] > leavetime + e.cost){
                    distance[e.to] = leavetime + e.cost;
                    que.push(std::make_pair(distance[e.to], e.to));
                }
            }
        }
        return distance;
    }
    void scc_dfs_fwd(int v, std::vector<bool>& used, std::vector<int>& postorder){
        used[v] = true;
        for(Edge e:edges[v]){
            if(!used[e.to])scc_dfs_fwd(e.to, used, postorder);
        }
        //帰りがけ順
        postorder.push_back(v);
    }
    void scc_dfs_bwd(int v, int k, std::vector<bool>& used, std::vector<int>& topo_order){
        used[v] = true;
        topo_order[v] = k;
        for(Edge e: reverse_edges[v]){
            if(!used[e.to])scc_dfs_bwd(e.to, k, used, topo_order);
        }
    }
    std::vector<int> scc(){
        std::vector<bool> used(num_node, false);
        std::vector<int> postorder(num_node, 0);
        std::vector<int> topo_order(num_node, -1);

        postorder.clear();
        //forward dfs
        for(int i=0; i<num_node; i++){
            if(!used[i]) scc_dfs_fwd(i, used, postorder);
        }
        //backward dfs
        std::fill(used.begin(), used.end(), false);
        int k=0;
        for(int i = num_node-1; i>=0; i--){
            if(!used[postorder[i]]){
                scc_dfs_bwd(postorder[i], k, used, topo_order);
                k++;
            }
        }
        return topo_order;
    }
};
int main(){
    using namespace std;
    
    int n, m, x, y;
    cin >> n >> m >> x >> y;
    x--;y--;

    DiGraph graph(n);
    for(int i=0; i<m; i++){
        int a, b, t, k;
        cin >> a >> b >> t >> k;
        a--; b--;
        graph.addEdge(a, b, t, k);
        graph.addEdge(b, a, t, k);
    }

    auto res = graph.dijkstra(x);
    if(res[y]==LONG_LONG_MAX/2) cout << -1 << endl;
    else cout << res[y] << endl;
    
    return 0;
}