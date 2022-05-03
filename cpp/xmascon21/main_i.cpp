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

int main(){
    using namespace std;
    
    int a, b, c, d;
    cin >> a >> b >> c >> d;
    vector<pair<int, int>> mole(0);
    int score = 0;
    while(true){
        int e, f;
        cin >> e >> f;
        if(e==0 && f==0)break;
        mole.push_back(make_pair(e, f));
        int bbminy = min(a, c);
        int bbmaxy = max(a, c);
        int bbminx = min(b, d);
        int bbmaxx = max(b, d);
        int bbpy = 0;
        if(e < bbminy) bbpy = bbminy;
        else if(e<=bbmaxy) bbpy = e;
        else bbpy = bbmaxy;
        int bbpx = 0;
        if(f < bbminx) bbpx = bbminx;
        else if(f<=bbmaxx) bbpx = f;
        else bbpx = bbmaxx;
        int d1 = abs(bbpy-a) + abs(bbpx-b);
        int d2 = abs(bbpy-c) + abs(bbpx-d);
        if(d1<= d2){
            score += abs(a-e) + abs(b-f);
            a = e;
            b = f;
            if(d1 > 0){
                if(c == bbpy){
                    d = d + (bbpx-d)/abs(bbpx-d) * d1;
                }else{
                    d = d + (bbpx-d)/abs(bbpx-d) * (d1-1);
                }
                c = bbpy;
            }
            cout << 1 << endl <<  flush; 
        }else{
            score += abs(c-e) + abs(d-f);
            c = e;
            d = f;
            if(d2 > 0){
                if(a == bbpy){
                    b = b + (bbpx-b)/abs(bbpx-b) * d2;
                }else{
                    b = b + (bbpx-b)/abs(bbpx-b) * (d2-1);
                }
                a = bbpy;
            }
            cout << 2 << endl <<  flush; 
        }
        // cout << a << " " << b << " " << c << " " << d << endl << flush;
    }
    
    return 0;
}