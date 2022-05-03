#include <bits/stdc++.h>
using namespace std;

int main(){
    int n, k;
    cin >> n >> k;
    string s;
    cin >> s;
    vector<vector<int>> pos(26, vector<int>(n, -1));
    for(int i=n-1; i>=0; i--){
        int cha = (int)(s.at(i) - 'a');
        for(int j=0;j<26;j++){
            if(cha == j) pos[j][i] = i;
            else if(i != n-1) pos[j][i] = pos[j][i+1];
        }    
    }

    // for(int i=0; i<26; i++){
    //     for(int j=0;j<n;j++){
    //         cout << pos[i][j] << " ";
    //     }    
    //     cout << endl;
    // }


    int now = 0;
    for(int i=0; i<k; i++){
        for(int j=0; j<26; j++){
            if(pos[j][now] != -1 && n-pos[j][now] >= k-i){
                now = pos[j][now]+1;
                cout<< (char)(j + 'a');
                break;
            }
        }
    }
    cout << endl;
}