#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin >> n;
    set<string> sset;
    for (int i = 0; i < n; i++)
    {
        int L;
        cin >> L;
        string str = "";
        for (int i = 0; i < L; i++)
        {
            int a;
            cin >> a;
            str += to_string(a);
            if(i<L-1){
                str += ",";
            }
        }
        sset.insert(str);
    }
    cout << sset.size() << endl;
}