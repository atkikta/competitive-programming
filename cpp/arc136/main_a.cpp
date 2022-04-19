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
    
    int n;
    cin >> n;
    string s;
    cin >> s;
    vector<string> list;
    bool isab = false;
    for(int i=0; i<s.size(); i++){
        if(s[i]=='C'){
            list.push_back("C");
            isab = false;
        }else{
            if(isab){
                list[list.size()-1].push_back(s[i]);
            }else{
                string str = {s[i]};
                list.push_back(str);
            }
            isab = true;
        }
    }
    // cout << join(list) << endl;
    for(string str:list){
        if(str=="C"){
            cout << "C";
        }else{
            int counta = 0;
            for(int i=0; i<str.size(); i++){
                if(str[i]=='A') {
                    counta++;
                    cout << "A";
                }
            }
            int numb = (str.size() - counta)/2;
            for(int i=0; i<numb; i++){
                cout << "A";
            }
            if((str.size() - counta)%2==1){
                cout << "B";
            }
        }
    }
    
    return 0;
}