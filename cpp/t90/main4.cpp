#include <bits/stdc++.h>
using namespace std;

int main(){
    int h, w;
    cin >> h >> w;
    vector<vector<int>> grid(h, vector<int>(w));
    vector<int> hsum(w);
    vector<int> wsum(h);
    for (size_t i = 0; i < h; i++)
    {
        for (size_t j = 0; j < w; j++)
        {
            int a;
            cin >> a;
            grid[i][j] = a;
            wsum[i] += a;
        }
    }
    for (size_t i = 0; i < h; i++)
    {
        for (size_t j = 0; j < w; j++)
        {
            hsum[j] += grid[i][j];
        }
    }
    for (size_t i = 0; i < h; i++)
    {
        for (size_t j = 0; j < w; j++)
        {
            cout << hsum[j] + wsum[i] - grid[i][j] << " ";
        }
        cout << endl;        
    }
    
    
}