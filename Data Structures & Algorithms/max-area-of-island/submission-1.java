class Solution {

    public int dfs(int[][] grid, int i, int j,int[][] vis){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length|| vis[i][j]==1 || grid[i][j]==0){
            return 0;
        }

        vis[i][j] =1;
        int row[] = new int[]{0,0,1,-1};
        int col[] = new int[]{1,-1,0,0};
        int area =0;
        for(int k=0;k<4;k++){
            area += dfs(grid,i+row[k],j+col[k],vis);
        }

        return area+1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n =grid[0].length;

        int vis[][] = new int[m][n];
        int maxArea =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]!=1 && grid[i][j]==1){
                    int currentIslandArea = dfs(grid, i, j, vis);                    
                    maxArea = Math.max(maxArea, currentIslandArea); 
                }
            }
        }
        return maxArea;
    }
}
