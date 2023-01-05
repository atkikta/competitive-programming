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

int main(){
    using namespace std;
    
    string s;
    cin >> s;
    int q;
    cin >> q;
    for(int i=0; i<q; i++){
        long long t, k;
        cin >> t >> k;
        long long at = k;
        long long count = 0;
        vector<long long> position;
        position.push_back(at);
        while(count < t && at>1){
            if(at%2==0){
                at = at/2;
            }else{
                at = (at+1)/2;
            }
            position.push_back(at);
            count++;
        }
        long long ones = t - count;
        reverse(position.begin(), position.end());
        // cout << ones << endl;
        // cout << join(position) << endl;
        char ch;
        if(ones == 0){
            ch = s[position[0]-1];
        }else{
            if(s[0]=='A'){
                if(ones%3==0) ch = 'A';
                else if(ones%3==1) ch = 'B';
                else if(ones%3==2) ch = 'C';
            }else if(s[0]=='B'){
                if(ones%3==0) ch = 'B';
                else if(ones%3==1) ch = 'C';
                else if(ones%3==2) ch = 'A';
            }else{
                if(ones%3==0) ch = 'C';
                else if(ones%3==1) ch = 'A';
                else if(ones%3==2) ch = 'B';

            }
        }
        for(int i=1; i<position.size(); i++){
            // cout << ch << endl;
            if(position[i]%2==0){
                if(ch=='A') ch = 'C';
                else if(ch=='B') ch = 'A';
                else if(ch=='C') ch = 'B';
            }else{
                if(ch=='A') ch = 'B';
                else if(ch=='B') ch = 'C';
                else if(ch=='C') ch = 'A';
            }
        }
        cout << ch << endl;
    }
    
    return 0;
}