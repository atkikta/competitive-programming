#include <bits/stdc++.h>
using namespace std;

int main(){
    string s;
    cin >> s;
    string t = "oxxoxxoxxoxxoxxoxxoxxoxxoxxoxx";
    bool ans = false;
    for(int i=0; i<3; i++){
        bool res = true;
        for(int j=0; j<s.size(); j++){
            if(s[j] != t[i+j]) res = false;
        }
        if(res) ans = true;
    }
    if(ans){
        cout << "Yes" << endl;
    }else{
        cout << "No" << endl;
    }
}