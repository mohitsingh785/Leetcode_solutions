//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++
int ans;
class Solution {
public:
    bool issafe(vector<vector<int>> &arr, int x, int y, vector<vector<bool>> &vis, int n, int m){
        if(x >=0 && x<n && y>=0 && y<m && vis[x][y] == false && arr[x][y] == 1)
            return true;
        return false;
    }
    
    void solve(vector<vector<int>> &arr, int xd, int yd, vector<vector<bool>> &vis, int n, int m, int cnt, int x, int y){
        if(x == xd && y == yd){
            ans = max(cnt, ans);
            return;
        }
        
        vis[x][y] = true;
        
        if(issafe(arr, x, y+1, vis, n, m)){
            solve(arr, xd, yd, vis, n, m, cnt+1, x, y+1);
        }
        
        if(issafe(arr, x+1, y, vis, n, m)){
            solve(arr, xd, yd, vis, n, m, cnt+1, x+1, y);
        }
        
        if(issafe(arr, x-1, y, vis, n, m)){
            solve(arr, xd, yd, vis, n, m, cnt+1, x-1, y);
        }
        
        if(issafe(arr, x, y-1, vis, n,  m)){
            solve(arr, xd, yd, vis, n, m, cnt+1, x, y-1);
        }
        
        vis[x][y] = false;
    }
    int longestPath(vector<vector<int>> arr, int xs, int ys, int xd, int yd)
    {
        if(arr[xs][ys] == 0 || arr[xd][yd] == 0)
            return -1;
            
        ans = -1;
        int cnt = 0;
        int n = arr.size();
        int m = arr[0].size();
        
        vector<vector<bool>> vis(n, vector<bool>(m, false));
        solve(arr, xd, yd, vis, n, m, cnt, xs, ys);
        return ans;
    }

};

//{ Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n, m;
        cin >> n >> m;
        int xs, ys, xd, yd;
        cin >> xs >> ys >> xd >> yd;
        vector<vector<int>> mat(n, vector<int>(m));
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                cin >> mat[i][j];
            }
        }
        Solution ob;
        int ans = ob.longestPath(mat, xs, ys, xd, yd);
        cout << ans;
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends