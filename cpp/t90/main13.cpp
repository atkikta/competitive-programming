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

struct Edge{
    int from;
    int to;
    int cost;
    Edge(int f, int t, int c){
        from = f;
        to = t;
        cost = c;
    }
};
struct DiGraph{
    int num_node;
    std::vector<std::vector<Edge>> edges;
    DiGraph(int size){
        num_node = size;
        edges = std::vector<std::vector<Edge>>(size);
    }
    void addEdge(int from, int to, int cost){
        edges.at(from).push_back(Edge(from, to, cost));
    }
    std::vector<long long> dijkstra(int start_node){
        std::vector<long long> distance(num_node, LONG_LONG_MAX/2);
        std::priority_queue<std::pair<long long, int>, std::vector<std::pair<long long, int>>, std::greater<std::pair<long long, int>>> que;
        distance[start_node] = 0;
        que.push(std::make_pair(0, start_node));
        while(!que.empty()){
            int pos = que.top().second; que.pop();
            for(Edge e:edges[pos]){
                if(distance[e.to] > distance[pos] + e.cost){
                    distance[e.to] = distance[pos] + e.cost;
                    que.push(std::make_pair(distance[e.to], e.to));
                }
            }
        }
        return distance;
    }
};


int main(){
    using namespace std;
    int n, m;
    cin >> n >> m;
    DiGraph graph(n);
    for(int i=0; i<m; i++){
        int a, b, c;
        cin >> a >> b >> c;
        graph.addEdge(a-1, b-1, c);
        graph.addEdge(b-1, a-1, c);
    }
    vector<long long> dist1 = graph.dijkstra(0);
    vector<long long> dist2 = graph.dijkstra(n-1);
    for(int i=0; i<n; i++){
        cout << dist1[i] + dist2[i] << endl;
    }
    
    return 0;
}

